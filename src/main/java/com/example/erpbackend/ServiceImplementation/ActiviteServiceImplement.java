package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Repository.ActiviteRepository;
import com.example.erpbackend.Repository.Activite_ActeurRepository;
import com.example.erpbackend.Service.ActiviteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ActiviteServiceImplement implements ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private Activite_ActeurRepository activite_acteurRepository;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================
    @Override
    public ReponseMessage ajouterActivite(Activite activite, String idacteurs, String idacteurInternes,  String idacteursOrg,
                                          String idacteurInternesOrg, String idacteursInterv,
                                          String idacteurInternesInterv, String idacteursLead,
                                          String idacteurInternesLead) {


        if(activiteRepository.findByNom(activite.getNom()) == null){

            activite.setEtat(true);


         int mois =  activite.getDateDebut().getMonth()+1;


         activite.setMois(mois);

             Activite act = activiteRepository.save(activite);

            // //Un tableau qui contenera l'id des acteurs par case

                    ////formateurs

            //formateurs externes
            if(idacteurs.contains("")){

            }else {
                //System.out.println("ghbbbbbbbbbbbbbbbbbbbbbbbbbbbbb : "+ idacteurs);
                String[] allIdActeurs = idacteurs.split(",");
                System.out.println(allIdActeurs);


                for (String idact : allIdActeurs) {

                    long l = Long.parseLong(idact);

                    activite_acteurRepository.INSERT_ACTEUR_ACTIVITES_Formateurs(l, act.getIdactivite());

                }
            }

            //Formateurs internes
            if(idacteurInternes.contains("")){

                }else{
                String[] allIdActeursInternes = idacteurInternes.split(",");

                System.out.println(allIdActeursInternes);

                for (String idact : allIdActeursInternes) {

                    long l = Long.parseLong(idact);

                    activiteRepository.insert_activites_utilisateurs_animer_formateurs(l, act.getIdactivite());
                }
            }




            ///organisateurs



            //Organisateurs externes
            if(idacteursOrg.contains("")){

            }else {
                //System.out.println("ghbbbbbbbbbbbbbbbbbbbbbbbbbbbbb : "+ idacteurs);
                String[] allIdActeurs = idacteurs.split(",");
                System.out.println(allIdActeurs);


                for (String idact : allIdActeurs) {

                    long l = Long.parseLong(idact);

                    activite_acteurRepository.INSERT_ACTEUR_ACTIVITES_Organisateurs(l, act.getIdactivite());

                }
            }

            //Organisateurs internes
            if(idacteurInternesOrg.contains("")){

            }else{
                String[] allIdActeursInternes = idacteurInternes.split(",");

                System.out.println(allIdActeursInternes);

                for (String idact : allIdActeursInternes) {

                    long l = Long.parseLong(idact);

                    activiteRepository.insert_activites_utilisateurs_animer_Organisateurs(l, act.getIdactivite());
                }
            }





            ////intervenants


            //Intervenant externes
            if(idacteursInterv.contains("")){

            }else {
                //System.out.println("ghbbbbbbbbbbbbbbbbbbbbbbbbbbbbb : "+ idacteurs);
                String[] allIdActeurs = idacteurs.split(",");
                System.out.println(allIdActeurs);

                for (String idact : allIdActeurs) {

                    long l = Long.parseLong(idact);

                    activite_acteurRepository.INSERT_ACTEUR_ACTIVITES_Intervenants(l, act.getIdactivite());

                }
            }



            //Intervenant internes
            if(idacteurInternesInterv.contains("")){

            }else{
                String[] allIdActeursInternes = idacteurInternes.split(",");

                System.out.println(allIdActeursInternes);

                for (String idact : allIdActeursInternes) {

                    long l = Long.parseLong(idact);

                    activiteRepository.insert_activites_utilisateurs_animer_Intervenants(l, act.getIdactivite());
                }
            }




            /////Lead


            //Lead externes
            if(idacteursLead.contains("")){

            }else {
                //System.out.println("ghbbbbbbbbbbbbbbbbbbbbbbbbbbbbb : "+ idacteurs);
                String[] allIdActeurs = idacteurs.split(",");
                System.out.println(allIdActeurs);


                for (String idact : allIdActeurs) {

                    long l = Long.parseLong(idact);

                    activite_acteurRepository.INSERT_ACTEUR_ACTIVITES_Lead(l, act.getIdactivite());

                }
            }

            //Lead internes
            if(idacteurInternesLead.contains("")){

            }else{
                String[] allIdActeursInternes = idacteurInternes.split(",");

                System.out.println(allIdActeursInternes);

                for (String idact : allIdActeursInternes) {

                    long l = Long.parseLong(idact);

                    activiteRepository.insert_activites_utilisateurs_animer_Leads(l, act.getIdactivite());
                }
            }



            ReponseMessage message = new ReponseMessage("Activité ajoutée avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cette activité existe déjà ", false);

            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================
    @Override
    public ReponseMessage modifierActivite(Activite activite) {
        if (activiteRepository.findByIdactivite(activite.getIdactivite()) !=null) {
            return activiteRepository.findById(activite.getIdactivite())
                    .map(p -> {
                        p.setNom(activite.getNom());
                        p.setDateDebut(activite.getDateDebut());
                        p.setDateFin(activite.getDateFin());
                        p.setEtat(activite.getEtat());
                        p.setEtatActivite(activite.getEtatActivite());
                        p.setTypeActivite(activite.getTypeActivite());
                        p.setSalle(activite.getSalle());
                        activiteRepository.save(p);
                        ReponseMessage message = new ReponseMessage("Activité modifiée avec succes", true);
                        return  message;

                    }).orElseThrow(() -> new RuntimeException("Activité non trouvée !"));
        }else {
            ReponseMessage message = new ReponseMessage("Activité non trouvée ", false);

            return message;
        }
    }
    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES=========================
    @Override
    public List<Activite> afficherActivite() {

        return activiteRepository.FIND_ALL_ACTIVITE_RECENT_CREATION();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES=========================


    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE=========================
    @Override
    public ReponseMessage supprimerActivite(Long idactivite) {
        if(activiteRepository.findByIdactivite(idactivite) != null){
            activiteRepository.deleteById(idactivite);
            ReponseMessage message = new ReponseMessage("Activité supprimée avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Activité non trouvée", false);
            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================
    @Override
    public Activite trouverActiviteParId(Long idactivite) {

        return activiteRepository.findByIdactivite(idactivite);
    }

    @Override
    public Activite trouverActiviteParLibelle(String libelleActivite) {

        return activiteRepository.findByNom(libelleActivite);

        }

    @Override
    public List<Object> afficheActiviteEnFonctionEtat(String etat) {
        return activiteRepository.FIND_ACTIVITE_PAR_ETAT(etat);
    }

    @Override
    public List<Object> ActiviteParAnnee(int annee) {
        List<Object> activites = activiteRepository.ActiviteEnFonctionAnnee(annee);
        if (activites.size() != 0){
            return activites;
        }
        return Collections.singletonList("Aucune activité trouvée !");

    }




    @Override
    public List<Activite> activiteParEtat(String etat) {
        return activiteRepository.findByEtat(etat);
    }


    @Override
    public List<Activite> formation(Long entite_id) {
        return activiteRepository.formation(entite_id);
    }

    @Override
    public List<Activite> eve(Long entite_id) {
        return activiteRepository.eve(entite_id);
    }

    @Override
    public List<Activite> talk(Long entite_id) {
        return activiteRepository.talk(entite_id);
    }

    @Override
    public List<Object> activiteParDatePlusRecente() {
        List<Object> activites = activiteRepository.findByDateRecent();
        if (activites.size() != 0){
            return activites;
        }
        return Collections.singletonList("Aucune activité trouvée !");
    }

    @Override
    public List<Object> activiteParDateIntervale(String dateDebutt, String dateFinn) throws ParseException {
        Date dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutt);

        Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinn);
        List<Object> activites = activiteRepository.findByDateIntervale(dateDebut, dateFin);
        if (activites.size() != 0){
            return activites;
        }
        return Collections.singletonList("Aucune activité trouvée dans l'intervale des dates données !");
    }

    @Override
    public List<Object> activiteParEntite(String entite) {
        List<Object> activites = activiteRepository.findByEntite(entite);
        if (activites.size() != 0){
            return activites;
        }
        return Collections.singletonList("Aucune activité ne trouvée pour cette entité !");
    }

    @Override
    public List<Object> activiteParEntiteEtStatut(String entite, String statut) {
        List<Object> activites = activiteRepository.findByEntiteAndStatus(entite, statut);
        if (activites.size() != 0){
            return activites;
        }
        return Collections.singletonList("Aucune activité ne trouvée pour cette entité en fonction de cette entite et status !");
    }

    @Override

    public int recupererNombreActiviteParMois(int mois) {
        return activiteRepository.GET_NUMBER_ACTIVITE_PER_MONTH(mois);
    }

    @Override
    public int recupererNombreActivitePartypeactivite(String type_activite) {

        return activiteRepository.findByTypeActivite(type_activite).size();
    }
//debut du statisque pour kalanso
    @Override
    public int janvierKalanso() {
        return activiteRepository.janvierKalanso();
    }
    @Override
    public int fevrierKalanso() {
        return activiteRepository.fevrierKalanso();
    }
    @Override
    public int MarsKalanso() {
        return activiteRepository.MarsKalanso();
    }
    @Override
    public int AvrilKalanso() {
        return activiteRepository.AvrilKalanso();
    }
    @Override
    public int MaiKalanso() {
        return activiteRepository.MaiKalanso();
    }
    @Override
    public int juinKalanso() {
        return activiteRepository.juinKalanso();
    }
    @Override
    public int juilletKalanso() {
        return activiteRepository.juilletKalanso();
    }

    @Override
    public int AoutKalanso() {
        return activiteRepository.AoutKalanso();
    }
    @Override
    public int SepKalanso() {
        return activiteRepository.SepKalanso();
    }
    @Override
    public int octKalanso() {
        return activiteRepository.octKalanso();
    }
    @Override
    public int noKalanso() {
        return activiteRepository.noKalanso();
    }
    @Override
    public int deKalanso() {
        return activiteRepository.deKalanso();
    }

    // fin statistique pour kalanso
    // debut statistique pour fab
    @Override
    public int janvierfab() {
        return activiteRepository.janvierfab();
    }

    @Override
    public int fevrierfab() {
        return activiteRepository.fevrierfab();
    }

    @Override
    public int Marsfab() {
        return activiteRepository.Marsfab();
    }

    @Override
    public int Avrilfab() {
        return activiteRepository.Avrilfab();
    }

    @Override
    public int Maifab() {
        return activiteRepository.Avrilfab();
    }

    @Override
    public int juinfab() {
        return activiteRepository.juinfab();
    }

    @Override
    public int juilletfab() {
        return activiteRepository.juilletfab();
    }

    @Override
    public int Aoutfab() {
        return activiteRepository.Aoutfab();
    }

    @Override
    public int Sepfab() {
        return activiteRepository.Sepfab();
    }

    @Override
    public int octfab() {
        return activiteRepository.octfab();
    }

    @Override
    public int nofab() {
        return activiteRepository.nofab();
    }

    @Override
    public int defab() {
        return activiteRepository.defab();
    }
// fin statistique pour fab
    // debut statistique pour fablab
    @Override
    public int janvierFablab() {
        return activiteRepository.janvierFablab();
    }

    @Override
    public int fevrierFablab() {
        return activiteRepository.fevrierFablab();
    }

    @Override
    public int MarsFablab() {
        return activiteRepository.MarsFablab();
    }

    @Override
    public int AvrilFablab() {
        return activiteRepository.AvrilFablab();
    }

    @Override
    public int MaiFablab() {
        return activiteRepository.MaiFablab();
    }

    @Override
    public int juinFablab() {
        return activiteRepository.juinFablab();
    }

    @Override
    public int juilletFablab() {
        return activiteRepository.juilletFablab();
    }

    @Override
    public int AoutFablab() {
        return activiteRepository.AoutFablab();
    }

    @Override
    public int SepFablab() {
        return activiteRepository.SepFablab();
    }

    @Override
    public int octFablab() {
        return activiteRepository.octFablab();
    }

    @Override
    public int noFablab() {
        return activiteRepository.noFablab();
    }

    @Override
    public int deFablab() {
        return activiteRepository.deFablab();
    }
    // fin stistique pour fablab



    public int nombreFormation() {
        return activiteRepository.nombreFormation();
    }

    @Override
    public int nombreTalks() {
        return activiteRepository.nombreTalks();
    }

    @Override
    public int nombreEvenement() {
        return activiteRepository.nombreEvenement();

    }

    @Override
    public List<Object> troisActiviteRecente() {
        return activiteRepository.troisActiviteRecente();
    }



    @Override
    public List<Activite> activiteParTypeActiviteEtEntite(String typeActivite, Long idEntite) {
        return activiteRepository.findByTypeActiviteAndEntite(typeActivite, idEntite);
    }

    @Override
    public List<Object> activiteParEntiteEtTypeActivite(String etatActivite, Long idEntite) {
        return activiteRepository.findByEtatAndTypeActivite(etatActivite, idEntite);
    }



    //================FIN DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================



    @Override
    public ReponseMessage AgetBytes(long idactivite) throws IOException {
         Activite activite = new Activite();
         if(activiteRepository.findByNom(activite.getNom()) == null){
             Activite act = activiteRepository.findByIdactivite(idactivite);

             String imgactiphoto = act.getPhotoactivite();

             File actfile = new File("src/main/resources/imgActivite" + act.getIdactivite() + "/" + imgactiphoto);

             Path path = Paths.get(actfile.toURI());
             Files.readAllBytes(path);
             activiteRepository.save(activite);
             ReponseMessage message = new ReponseMessage("activite ajouter avec succes", true);
             return message;
         } else {
             ReponseMessage message = new ReponseMessage("cet activite existe déjà", false);
             return message;
         }
    }

    @Override
    public List<Object> troisActiviteavenir() {
        return activiteRepository.troisActiviteAvenir();
    }

    @Override
    public List<Activite> recupererActivitesSansListe() {
        return activiteRepository.FIND_ALL_ACTIVITE_NOT_VALILIDE();
    }
    public List<Object> afficherActiviteParId(int idactivite) {
        return activiteRepository.afficherActiviteParId(idactivite);
    }

    @Override
    public List<Object> LES_PERONNES_TIREE_V(Long idactivite) {
        return activiteRepository.LES_PERONNES_TIREE_VALIDE(idactivite);
    }

    public List<Object> afficherActiviteParEntiteEtat(Long entite,String etat) {
        return activiteRepository.afficherActiviteParEntiteEtat(entite,etat);

    }


    public int counterActivite(Long idactivite) {
        return activiteRepository.counterActivite(idactivite);
    }


}
