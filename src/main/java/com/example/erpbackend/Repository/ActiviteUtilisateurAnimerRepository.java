package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.ActivitesUtilisateursAnimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActiviteUtilisateurAnimerRepository extends JpaRepository<ActivitesUtilisateursAnimer, Long> {

    @Query(value = "select utilisateur.nom, email, numero, status from utilisateur, activite, activites_utilisateurs_animer where activites_utilisateurs_animer.iduser = utilisateur.iduser and activites_utilisateurs_animer.idactivite = activite.idactivite and  activite.idactivite = :idactivite", nativeQuery = true)
    List<Object> recupererActeurUtilisateurAnimer(@Param("idactivite") Long idactivite);

}
