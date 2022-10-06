package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.*;
import com.example.erpbackend.Repository.EtatActiviteRepository;
import com.example.erpbackend.Repository.UtilisateurRepository;
import com.example.erpbackend.Service.*;
import com.example.erpbackend.ServiceImplementation.ActiviteServiceImplement;
import com.example.erpbackend.img.ConfigImage;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.query.Param;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/activite")
@Api(value = "hello", description = "controller permettant la Gestion des activtés")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

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
    public ReponseMessage createactivite(@Param("file") MultipartFile file, @Param("nom") String nom, @Param("description") String description, @Param("nombrepersonnedemande") int nombrepersonnedemande, @Param("datedeb") Date datedeb, @Param("datefin") Date datefin
            ,@Param("idacteurs") String idacteurs, @Param("idacteurInternes") String idacteurInternes,  @Param("libelleEntite") String libelleEntite, @Param("typeAct") String typeAct, @Param("libelleSalle") String libelleSalle, @Param("idresponsable") Long idresponsable, @Param("userid") Long userid) throws IOException {
          Activite activite = new Activite();

        Entite entite = entiteService.recupererEntiteParNom(libelleEntite);

        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());

        activite.setPhotoactivite(nomfile);

        activite.setNom(nom);

        activite.setDescription(description);

        activite.setDateDebut(datedeb);

        activite.setDateFin(datefin);

        activite.getMois();

        activite.setCreateur(utilisateurService.trouverUtilisateurParId(userid));

        activite.setNombrepersonnedemande(nombrepersonnedemande);

        activite.setResponsable(utilisateurService.trouverUtilisateurParId(idresponsable));

        String url= "src/main/resources/imgActivite/";

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
        return activiteService.ajouterActivite(activite, idacteurs, idacteurInternes);

    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Modifier une activité")
    @PutMapping("/modifier ")
    public ReponseMessage updateactivite(@RequestBody Activite activite){

        return activiteService.modifierActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher")
    public List<Activite> readactivite(){

        return activiteService.afficherActivite();
    }


    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher/{mois}")
    public int  nombreActiviteParMois(@PathVariable int mois){

        return activiteService.recupererNombreActiviteParMois(mois);
    }

    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES========================

    @ApiOperation(value = "ici on Supprimer une activité")
    @DeleteMapping("/supprimer/{idactivite}")
    public ReponseMessage deleteactivite(@PathVariable Long idactivite){

        return activiteService.supprimerActivite(idactivite);
    }

    @ApiOperation(value = "Ici on affiche les activites en fontion de l'etat")
    @GetMapping("/activitesRecentes/{etatActivite}")
    public List<Object> trouverTroisActviteParEtat(@PathVariable String etatActivite){

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
    List<Object> activiteParDatePlusRecente(){

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
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================


    @GetMapping("/afficher/{typeactivite}")
    public int  nombreActivitePartypeactivite(@PathVariable String type_activite){

        return activiteService.recupererNombreActivitePartypeactivite(type_activite);
    }


 //   @PostMapping("/ajouterE")
   // public ReponseMessage ajouteractivite(){

    //}
    @GetMapping("/nombreFormation")
    public int nombreFormation() {
        return activiteService.nombreFormation();
    }@GetMapping("/nombreTalks")
    public int nombreTalks() {
        return activiteService.nombreTalks();
    }

    @GetMapping("/nombreEvenements")
    public int nombreEvenements(){
        return activiteService.nombreEvenement();
    }


    //trois activité recente
    @GetMapping("/afficherTroisActiviteRecente")
    List<Object> troisActiviteRecente() {
        return activiteService.troisActiviteRecente();
    }
    @GetMapping("/nombreActiviteAvenir")
    List<Object> nombreActiviteAvenir(){
        return activiteService.troisActiviteavenir();

    }
}


