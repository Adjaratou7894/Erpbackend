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


    @Query(value = "SELECT * FROM activite,etat_activite WHERE activite.etat_activite_idetat = etat_activite.idetat AND etat_activite.etat =:etat", nativeQuery = true)
    List<Activite> findByEtat(@Param("etat") String etat);


    @Query(value = "SELECT nom, date_debut FROM activite ORDER BY date_debut desc", nativeQuery = true)
    List<Object> findByDateRecent();

    @Query(value = "SELECT activite.nom, activite.date_debut, activite.date_fin FROM `activite` WHERE date_debut BETWEEN :dateDebut AND :dateFin", nativeQuery = true)
    List<Object> findByDateIntervale(Date dateDebut, Date dateFin);

    @Query(value = "SELECT activite.nom, activite.date_debut,activite.date_fin,entite.nom as 'entitenom',activite.etat FROM `activite`,entite WHERE activite.entite_id_entite=entite.id_entite AND entite.nom=:entite", nativeQuery = true)
    List<Object> findByEntite(@Param("entite") String entite);


    @Query(value = "SELECT activite.nom as 'nom activité', activite.date_debut,activite.date_fin,entite.nom as 'nom entité',activite.etat,statut.nom as 'statut' FROM `activite`,entite,statut,acteur_activites,acteur WHERE activite.entite_id_entite=entite.id_entite AND activite.idactivite = acteur_activites.activite_id AND acteur_activites.acteur_id = acteur.idacteur AND statut.idstatut = acteur.statut_idstatut AND entite.nom=:entite AND statut.nom=:statut", nativeQuery = true)
    List<Object> findByEntiteAndStatus(@Param("entite") String entite, @Param("statut") String statut);
}
