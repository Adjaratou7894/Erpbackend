package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    Activite findByNom(String nom);

    Activite findByIdactivite(Long idactivite);

    @Query(value = "select activite.nom, etat_activite.etat from activite, etat_activite " +
            "where activite.etat_activite_idetat = etat_activite.idetat and " +
            "etat_activite.etat = :etat order by date_debut LIMIT 3", nativeQuery = true)
    List<Object> FIND_ACTIVITE_PAR_ETAT(@Param("etat") String etat);

    @Query(value = "SELECT activite.nom, activite.date_debut, activite.date_fin, activite.nombrepersonnedemande, annee.annee FROM activite, annee WHERE annee.id= activite.annee_id AND annee.annee=:annee",
            nativeQuery = true)
    List<Object> ActiviteEnFonctionAnnee(@Param("annee") int annee);



    @Query(value = "SELECT * FROM activite, etat_activite WHERE activite.etat_activite_idetat = etat_activite.idetat AND etat_activite.etat =:etat", nativeQuery = true)
            List<Activite> findByEtat(@Param("etat") String etat);
  /*
    @Query(value = "SELECT activite.nom as \"nomactivite\",entite.nom as 'entitenom', " +
            "activite.date_debut,etat_activite.etat from activite,entite,etat_activite " +
            "WHERE activite.entite_id_entite = entite.id_entite AND activite.etat_activite_idetat =" +
            " etat_activite.idetat AND etat_activite.etat=:etat;", nativeQuery = true)

   */




    @Query(value = "SELECT nom, date_debut FROM activite ORDER BY date_debut desc", nativeQuery = true)
    List<Object> findByDateRecent();
    // debut des statistiques  pour entité kalanso
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=1", nativeQuery = true)
        int janvierKalanso();

        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=2", nativeQuery = true)
        int fevrierKalanso();

        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=3", nativeQuery = true)
        int MarsKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=4", nativeQuery = true)
        int AvrilKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=5", nativeQuery = true)
        int MaiKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=6", nativeQuery = true)
        int juinKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=7", nativeQuery = true)
        int juilletKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=8", nativeQuery = true)
        int AoutKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=9", nativeQuery = true)
        int SepKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=10", nativeQuery = true)
        int octKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=11", nativeQuery = true)
        int noKalanso();
        @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=1 AND mois=12", nativeQuery = true)
        int deKalanso();
    // fin des statistiques  pour entité kalanso


    // debut des statistiques  pour entité fab
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=1", nativeQuery = true)
    int janvierfab();

    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=2", nativeQuery = true)
    int fevrierfab();

    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=3", nativeQuery = true)
    int Marsfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=4", nativeQuery = true)
    int Avrilfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=5", nativeQuery = true)
    int Maifab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=6", nativeQuery = true)
    int juinfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=7", nativeQuery = true)
    int juilletfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=8", nativeQuery = true)
    int Aoutfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=9", nativeQuery = true)
    int Sepfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=10", nativeQuery = true)
    int octfab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=11", nativeQuery = true)
    int nofab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=2 AND mois=12", nativeQuery = true)
    int defab();
    // fin des statistiques  pour entité fab


    // debut des statistiques  pour entité Fablab
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=1", nativeQuery = true)
    int janvierFablab();

    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=2", nativeQuery = true)
    int fevrierFablab();

    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=3", nativeQuery = true)
    int MarsFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=4", nativeQuery = true)
    int AvrilFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=5", nativeQuery = true)
    int MaiFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=6", nativeQuery = true)
    int juinFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=7", nativeQuery = true)
    int juilletFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=8", nativeQuery = true)
    int AoutFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=9", nativeQuery = true)
    int SepFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=10", nativeQuery = true)
    int octFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=11", nativeQuery = true)
    int noFablab();
    @Query (value = "SELECT COUNT(idactivite) FROM `activite` WHERE entite_id_entite=3 AND mois=12", nativeQuery = true)
    int deFablab();
    // fin des statistiques  pour entité Solidaire fablab


    @Query(value = "SELECT activite.nom, activite.date_debut, activite.date_fin FROM `activite`" +
            " WHERE date_debut BETWEEN :dateDebut AND :dateFin", nativeQuery = true)
    List<Object> findByDateIntervale(Date dateDebut, Date dateFin);

    //filtrage par entité

    @Query(value = "SELECT activite.idactivite,activite.nom,entite.nom as 'entitenom', activite.date_debut,etat_activite.etat" +
            " from activite,entite,etat_activite WHERE activite.entite_id_entite = entite.id_entite " +
            "AND activite.etat_activite_idetat = etat_activite.idetat AND entite.nom =:entite", nativeQuery = true)
    List<Object> findByEntite(@Param("entite") String entite);



    @Query(value = "SELECT activite.nom,activite.description,etat_activite.etat,activite.date_debut,activite.date_fin FROM activite,entite,etat_activite WHERE activite.entite_id_entite = entite.id_entite AND activite.etat_activite_idetat = etat_activite.idetat AND etat_activite.etat = :etatActivite AND entite.id_entite=:idEntite", nativeQuery = true)
    List<Object> findByEtatAndTypeActivite(@Param("etatActivite") String etatActivite, @Param("idEntite") Long idEntite);

    @Query(value = "SELECT * FROM activite,type_activite WHERE activite.type_activite_idactivite = type_activite.idactivite AND type_activite.type_activite=:typeActivite AND activite.entite_id_entite=:idEntite", nativeQuery = true)
    List<Activite> findByTypeActiviteAndEntite(@Param("typeActivite") String typeActivite, @Param("idEntite") Long idEntite);

    @Query(value = "SELECT activite.nom as 'nom activité', activite.date_debut,activite.date_fin,entite.nom as 'nom entité',activite.etat,statut.nom as 'statut' FROM `activite`,entite,statut,acteur_activites,acteur WHERE activite.entite_id_entite=entite.id_entite AND activite.idactivite = acteur_activites.activite_id AND acteur_activites.acteur_id = acteur.idacteur AND statut.idstatut = acteur.statut_idstatut AND entite.nom=:entite AND statut.nom=:statut", nativeQuery = true)

    List<Object> findByEntiteAndStatus(@Param("entite") String entite, @Param("statut") String statut);


    @Modifying
    @Transactional
    @Query(value = "insert into activites_utilisateurs_animer(iduser, idactivite, status) values (?,?, \"Formateur\");", nativeQuery = true)
    int insert_activites_utilisateurs_animer_formateurs(Long iduser, Long idactivite);

    @Modifying
    @Transactional
    @Query(value = "insert into activites_utilisateurs_animer(iduser, idactivite, status) values (?,?, \"Organisateur\");", nativeQuery = true)
    int insert_activites_utilisateurs_animer_Organisateurs(Long iduser, Long idactivite);

    @Modifying
    @Transactional
    @Query(value = "insert into activites_utilisateurs_animer(iduser, idactivite, status) values (?,?, \"Intervenant\");", nativeQuery = true)
    int insert_activites_utilisateurs_animer_Intervenants(Long iduser, Long idactivite);


    @Modifying
    @Transactional
    @Query(value = "insert into activites_utilisateurs_animer(iduser, idactivite, status) values (?,?, \"Lead\");", nativeQuery = true)
    int insert_activites_utilisateurs_animer_Leads(Long iduser, Long idactivite);


    @Query(value = "select count(mois) from activite where mois = :mois", nativeQuery = true)
    int GET_NUMBER_ACTIVITE_PER_MONTH(@Param("mois") int mois);

    @Query(value = "SELECT * FROM activite,type_activite WHERE activite.type_activite_idactivite = type_activite.idactivite AND type_activite.type_activite= :type_activite", nativeQuery = true)
    List<Object> findByTypeActivite(@Param("type_activite") String type_activite);

    @Query(value = "SELECT COUNT(*) FROM activite,type_activite WHERE activite.type_activite_idactivite = " +
            "type_activite.idactivite AND type_activite.type_activite = \"Formation\";", nativeQuery = true)
    int nombreFormation();

    @Query(value = "SELECT COUNT(*) FROM activite,type_activite WHERE activite.type_activite_idactivite = " +
            "type_activite.idactivite AND type_activite.type_activite = \"Talk\";", nativeQuery = true)
    int nombreTalks();
    @Query(value = "SELECT COUNT(*) FROM activite,type_activite WHERE activite.type_activite_idactivite = " +
            "type_activite.idactivite AND type_activite.type_activite = \"Evennement\";", nativeQuery = true)
    int nombreEvenement();

    //les trois activite les plus recente l'id etatactivite represente l'activite en cour
    @Query(value = "SELECT activite.nom AS nomactivite,activite.description,utilisateur.nom AS nomUser, utilisateur.prenom AS prenomUser,activite.idactivite " +
            "FROM activite,utilisateur,etat_activite WHERE utilisateur.iduser=activite.createur_iduser AND etat_activite.idetat = activite.etat_activite_idetat " +
            "AND etat_activite.etat =\"encours\" ORDER BY activite.date_debut DESC LIMIT 3;", nativeQuery = true)
    List<Object> troisActiviteRecente();

    //les trois activite les plus recente l'id etatactivite represente l'activite à venir
    @Query(value = "SELECT activite.nom AS \"nomactivite\",activite.description,utilisateur.nom AS" +
            " \"nomUser\",utilisateur.prenom AS \"prenomUser\",activite.idactivite FROM activite,utilisateur,etat_activite" +
            " WHERE etat_activite.idetat =" +
            " activite.idactivite AND etat_activite.etat =\"avenir\" ORDER BY activite.date_debut DESC LIMIT 3",
            nativeQuery = true)
    List<Object> troisActiviteAvenir();

    @Query(value = "select * from activite where liste_idliste is NULL;", nativeQuery = true)
    List<Activite> FIND_ALL_ACTIVITE_NOT_VALILIDE();


    @Query(value = "select * from activite order by datecreation desc", nativeQuery = true)
    List<Activite> FIND_ALL_ACTIVITE_RECENT_CREATION();


    @Query(value = "SELECT * FROM activite WHERE idactivite=:idactivite;",
            nativeQuery = true)
    List<Object> afficherActiviteParId(int idactivite);
    @Query(value = "SELECT activite.nom,activite.description,etat_activite.etat,activite.date_debut,activite.date_fin FROM activite,entite,etat_activite WHERE activite.entite_id_entite =" +
            " entite.id_entite AND activite.etat_activite_idetat = etat_activite.idetat " +
            "AND etat_activite.etat =:etat AND entite.id_entite =:entite;",
            nativeQuery = true)
    List<Object> afficherActiviteParEntiteEtat(Long entite,String etat);


    @Query(value = "SELECT COUNT(activite.idactivite) FROM activite WHERE activite.entite_id_entite =:idactivite", nativeQuery = true)
    int counterActivite(@Param("idactivite") Long idactivite );

    // ============================ ICI ON RECUPERE LES PERSONNE TIRES SUR UN TIRAGE VALIDE ET SUR UNE ACTIVITE PRECIS


    @Query(value = "SELECT postulant.nom_postulant,postulant.prenom_postulant," +
            "postulant.email,postulant.numero_postulant, postulant.genre FROM postulant," +
            "tirage,postulant_tire,activite WHERe tirage.validite = 1 AND postulant.id = postulant_tire.id " +
            "AND postulant_tire.tirage_idtirage = tirage.idtirage AND activite.idactivite = tirage.activite_idactivite " +
            "AND activite.idactivite = :idactivite",nativeQuery = true)

    List<Object> LES_PERONNES_TIREE_VALIDE(Long  idactivite);




    @Query(value = "SELECT activite.nom as \"nomactivite\",entite.nom as 'entitenom'" +
            ", activite.date_debut,etat_activite.etat,activite.idactivite from activite,entite,etat_activite WHERE" +
            " activite.entite_id_entite = entite.id_entite AND activite.etat_activite_idetat = " +
            "etat_activite.idetat",
            nativeQuery = true)
    List<Object> afficherActiviteDansFront();


    /*============================================ ici on fait les filtre de reporting =========================================================  */


    @Query(value = "SELECT * FROM activite,etat_activite,entite WHERE" +
            " entite.id_entite=activite.entite_id_entite AND etat_activite.idetat=activite.etat_activite_idetat AND" +
            " activite.date_debut =:dateDebut AND" +
            " etat_activite.etat=:etatActivite AND entite.nom = :entite_nom;",nativeQuery = true)
    List<Object> filtreReporting(@Param("dateDebut") String date_debut,@Param("etatActivite") String etat_activite,@Param("entite_nom") String nom);


}
