package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.*;
import com.example.erpbackend.Repository.EtatActiviteRepository;
import com.example.erpbackend.Repository.UtilisateurRepository;
import com.example.erpbackend.Service.*;
import com.example.erpbackend.ServiceImplementation.ActiviteServiceImplement;
import com.example.erpbackend.img.ConfigImage;

import com.example.erpbackend.ServiceImplementation.ActiviteServiceImplement;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erpbackend.Message.ReponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activite")
@Api(value = "hello", description = "controller permettant la Gestion des activtés")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class ActiviteController {

    @Autowired
    private ActiviteServiceImplement activiteService;

    final private EntiteService entiteService;

    final private TypeActiviteService typeActiviteService;

    final private AnneeService anneeService;

    final private SalleService salleService;

    final private UtilisateurService utilisateurService;

    final private UtilisateurRepository utilisateurRepository;

    final private EtatActiviteRepository etatActiviteRepository;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Ajouter une activité")

    @PostMapping("/ajouter")
    public ReponseMessage createactivite(@Param("file") MultipartFile file, @Param("nom") String nom, @Param("description") String description, @Param("nombrepersonnedemande") int nombrepersonnedemande, @RequestParam("datedeb") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datedeb, @RequestParam("datefin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datefin
            ,@Param("idacteurs") String idacteurs, @Param("idacteurInternes") String idacteurInternes
            ,@Param("idacteursInterv") String idacteursInterv, @Param("idacteurInternesInterv") String idacteurInternesInterv
            ,@Param("idacteursOrg") String idacteursOrg, @Param("idacteurInternesOrg") String idacteurInternesOrg
            ,@Param("idacteursLead") String idacteursLead, @Param("idacteurInternesLead") String idacteurInternesLead
            ,@Param("typeAct") String libelleEntite, @Param("typeAct") String typeAct, @Param("idresponsable") String libelleSalle
            ,@Param("idresponsable") Long idresponsable, @Param("userid") Long userid) throws IOException, ParseException {

         //file, nom, description,nombrepersonnedemande, datedeb, datefin, idacteurs, idacteurInternes, libelleEntite, typeAct, libelleSalle, idresponsable, userid


        //Date dateDebut = new SimpleDateFormat("yyyy/MM/dd").parse(datedeb);

        //Date dateFin = new SimpleDateFormat("yyyy/MM/dd").parse(datefin);


        System.out.println("les id de l'acteurs aaaaaaaaaaaaaaaaaaa : " + idacteurs);

        Activite activite = new Activite();

        Entite entite = entiteService.recupererEntiteParNom(libelleEntite);

        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());

        activite.setPhotoactivite(nomfile);

        activite.setNom(nom);

        activite.setDatecreation(new Date());

        activite.setDescription(description);


        activite.setDateDebut(datedeb);

        activite.setDateFin(datefin);

        activite.getMois();

       // activite.setCreateur(utilisateurService.trouverUtilisateurParId(userid));

       // activite.setNombrepersonnedemande(nombrepersonnedemande);

        activite.setResponsable(utilisateurService.trouverUtilisateurParId(idresponsable));

        //String url= "src/main/resources/imgActivite/";

        String url= "C:\\Users\\sddiakite\\Desktop\\Awa\\ApplicationERPInterface\\src\\assets\\images/";

        ConfigImage.saveimgA(url, nomfile, file);

        Type_activite type_activite = typeActiviteService.recupererTypeActParLibelle(typeAct);

        activite.setEtatActivite(etatActiviteRepository.findByIdetat(2L));

        Salle salle = salleService.trouverSalleParNom(libelleSalle);


        activite.setEntite(entite);
        activite.setTypeActivite(type_activite);

        activite.setSalle(salle);

        int anneeAct =  activite.getDateDebut().getYear()+1900;

        System.out.println("annee: " + anneeAct);

        activite.setAnnee(anneeService.recupererAnneeParLibelle(anneeAct));

        // idacteurs
        return activiteService.ajouterActivite(activite, idacteurs, idacteurInternes, idacteursOrg, idacteurInternesOrg, idacteursInterv, idacteurInternesInterv, idacteursLead, idacteurInternesLead);

    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Modifier une activité")
    @PutMapping("/modifier ")
    public ReponseMessage updateactivite(@RequestBody Activite activite) {

        return activiteService.modifierActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher")

    public List<Activite> readactivite() {

        return activiteService.afficherActivite();
    }


    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher/{mois}")
    public int nombreActiviteParMois(@PathVariable int mois) {

        return activiteService.recupererNombreActiviteParMois(mois);
    }

    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES========================

    @ApiOperation(value = "ici on Supprimer une activité")
    @DeleteMapping("/supprimer/{idactivite}")
    public ReponseMessage deleteactivite(@PathVariable Long idactivite) {

        return activiteService.supprimerActivite(idactivite);
    }

    @ApiOperation(value = "Ici on affiche les activites en fontion de l'etat")
    @GetMapping("/activitesRecentes/{etatActivite}")
    public List<Object> trouverTroisActviteParEtat(@PathVariable String etatActivite) {

        return activiteService.afficheActiviteEnFonctionEtat(etatActivite);
    }

    @ApiOperation(value = "Ici on affiche les activites en fontion de l'année")
    @GetMapping("/ParAnnee/{annee}")
    public List<Object> ActiviteParAnnee(@PathVariable int annee) {

        return activiteService.ActiviteParAnnee(annee);
    }

    @ApiOperation(value = "Ici on affiche les activites en fontion de l'etat")
    @GetMapping("/ParEtat/{etat}")
    public List<Activite> activiteParEtat(@PathVariable String etat) {
        return activiteService.activiteParEtat(etat);
    }

    @GetMapping("/parDatePlusRecente")
    List<Object> activiteParDatePlusRecente() {

        return activiteService.activiteParDatePlusRecente();
    }


    @GetMapping("/parDateIntervale/{dateDebut}/{dateFin}")
    public List<Object> activiteParDateIntervale(@PathVariable String dateDebut, @PathVariable String dateFin) throws ParseException {

        return activiteService.activiteParDateIntervale(dateDebut, dateFin);
    }


    @GetMapping("/parEntite/{entite}")
    public List<Object> activiteParEntite(@PathVariable String entite) {

        return activiteService.activiteParEntite(entite);
    }


    @GetMapping("/parEntiteStatus/{entite}/{statut}")
    public List<Object> activiteParEntiteEtStatut(@PathVariable String entite, @PathVariable String statut) {

        return activiteService.activiteParEntiteEtStatut(entite, statut);
    }

    //================ FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE ======================

    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================


    @GetMapping("/afficher/{typeactivite}")
    public int nombreActivitePartypeactivite(@PathVariable String type_activite) {

        return activiteService.recupererNombreActivitePartypeactivite(type_activite);
    }




 //   @PostMapping("/ajouterE")
   // public ReponseMessage ajouteractivite(){

    //}



    @GetMapping("/nombreTalks")
    public int nombreTalks() {

        return activiteService.nombreTalks();
    }

        // controlleur statistique kalanso
        @GetMapping("/janvierKalanso")
        public Object janvierKalanso() {
            return activiteService.janvierKalanso();
        }

        @GetMapping("/fevrierKalanso")
        public Object fevrierKalanso() {
            return activiteService.fevrierKalanso();
        }
        @GetMapping("/marsKalanso")
        public Object MarsKalanso() {
            return activiteService.MarsKalanso();
        }
        @GetMapping("/avrilKalanso")
        public Object AvrilKalanso() {
            return activiteService.AvrilKalanso();
        }
        @GetMapping("/maiKalanso")
        public Object MaiKalanso() {
            return activiteService.MaiKalanso();
        }
        @GetMapping("/juinKalanso")
        public Object juinKalanso() {
            return activiteService.juinKalanso();
        }
        @GetMapping("/juilletKalanso")
        public Object juilletKalanso() {
            return activiteService.juilletKalanso();
        }
        @GetMapping("/aoutKalanso")
        public Object AoutKalanso() {
            return activiteService.AoutKalanso();
        }
        @GetMapping("/sepKalanso")
        public Object SepKalanso() {
            return activiteService.SepKalanso();
        }
        @GetMapping("/octKalanso")
        public Object octKalanso() {
            return activiteService.octKalanso();
        }
        @GetMapping("/noKalanso")
        public Object noKalanso() {
            return activiteService.noKalanso();
        }
        @GetMapping("/deKalanso")
        public Object deKalanso() {
            return activiteService.deKalanso();
        }
// controlleur statistique kalanso fin

    // controlleur statistique kalanso
    @GetMapping("/janvierfablab")
    public Object janvierFablab() {
        return activiteService.janvierFablab();
    }
    @GetMapping("/fevrierfablab")
    public Object fevrierFablab() {
        return activiteService.fevrierFablab();
    }
    @GetMapping("/marsfablab")
    public Object MarsFablab() {
        return activiteService.MarsFablab();
    }
    @GetMapping("/avrilfablab")
    public Object AvrilFablab() {
        return activiteService.AvrilFablab();
    }
    @GetMapping("/maifablab")
    public Object MaiFablab() {
        return activiteService.MaiFablab();
    }
    @GetMapping("/juinfablab")
    public Object juinFablab() {
        return activiteService.juinFablab();
    }
    @GetMapping("/juilletfablab")
    public Object juilletFablab() {
        return activiteService.juilletFablab();
    }
    @GetMapping("/aoutfablab")
    public Object AoutFablab() {
        return activiteService.AoutFablab();
    }
    @GetMapping("/sepfablab")
    public Object SepFablab() {
        return activiteService.SepFablab();
    }
    @GetMapping("/octfablab")
    public Object octFablab() {
        return activiteService.octFablab();
    }
    @GetMapping("/nofablab")
    public Object noFablab() {
        return activiteService.noFablab();
    }
    @GetMapping("/defablab")
    public Object deFablab() {
        return activiteService.deFablab();
    }
// controlleur statistique fab fin


    // controlleur statistique kalanso
    @GetMapping("/janvierfab")
    public Object janvierfab() {
        return activiteService.janvierfab();
    }
    @GetMapping("/fevrierfab")
    public Object fevrierfab() {
        return activiteService.fevrierfab();
    }
    @GetMapping("/marsfab")
    public Object Marsfab() {
        return activiteService.Marsfab();
    }
    @GetMapping("/avrilfab")
    public Object Avrilfab() {
        return activiteService.Avrilfab();
    }
    @GetMapping("/maifab")
    public Object Maifab() {
        return activiteService.Maifab();

    }
    @GetMapping("/juinfab")
    public Object juinfab() {
        return activiteService.juinfab();
    }
    @GetMapping("/juilletfab")
    public Object juilletfab() {
        return activiteService.juilletfab();
    }
    @GetMapping("/aoutfab")
    public Object Aoutfab() {
        return activiteService.Aoutfab();
    }
    @GetMapping("/sepfab")
    public Object Sepfab() {
        return activiteService.Sepfab();
    }
    @GetMapping("/octfab")
    public Object octfab() {
        return activiteService.octfab();
    }
    @GetMapping("/nofab")
    public Object nofab() {
        return activiteService.nofab();
    }
    @GetMapping("/defab")
    public Object defab() {
        return activiteService.defab();
    }
// controlleur statistique fab fin




    //   @PostMapping("/ajouterE")
        // public ReponseMessage ajouteractivite(){


    @GetMapping("/nombreEvenements")
    public int nombreEvenements(){

        return activiteService.nombreEvenement();
    }


    //trois activité recente




        @GetMapping("/nombreFormation")
        public int nombreFormation () {
            return activiteService.nombreFormation();
        }



        @GetMapping("/counterActivite/{idactivite}")
        public  int counterActivite(@PathVariable("idactivite") Long idactivite) {
        return activiteService.counterActivite(idactivite);
        }

        //trois activité recente
        @GetMapping("/afficherTroisActiviteRecente")
        List<Object> troisActiviteRecente () {
            return activiteService.troisActiviteRecente();
        }
        @GetMapping("/afficherActiviteAvenir")
        List<Object> nombreActiviteAvenir () {
            return activiteService.troisActiviteavenir();

        }

        @GetMapping("/afficherActiviteParId/{idactivite}")
        List<Object> afficherActiviteParId ( @PathVariable int idactivite){
            return activiteService.afficherActiviteParId(idactivite);

        }


        @GetMapping("/lesPersonnes/{idactivite}")
        List<Object> lesPersonnes(@PathVariable Long  idactivite){
        return  this.activiteService.LES_PERONNES_TIREE_V(idactivite);
        }


    @GetMapping("/parEntiteEtEtat/{etatActivite}/{idEntite}")
    List<Object> activiteParEntiteEtTypeActivite(@PathVariable String etatActivite, @PathVariable Long idEntite) {
        return activiteService.activiteParEntiteEtTypeActivite(etatActivite, idEntite);
    }


    @GetMapping("/parTypeActiviteEtEntite/{typeActivite}/{idEntite}")
    int activiteParTypeActiviteEtEntite(@PathVariable String typeActivite, @PathVariable Long idEntite){
        return activiteService.activiteParTypeActiviteEtEntite(typeActivite, idEntite).size();
    }


    @GetMapping("/afficherActiviteParEntiteEtat/{entite}/{etat}")
    List<Object> afficherActiviteParEntiteEtat(@PathVariable Long entite, @PathVariable String etat){
        return activiteService.afficherActiviteParEntiteEtat(entite, etat);
    }

    @GetMapping("/activiteSansListe")
    List<Activite> recupererActiviteNonlierAliste(){

        return activiteService.recupererActivitesSansListe();
    }


}


