package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Optional<Utilisateur> findByEmailAndPassword(String email, String password);

    Utilisateur findByEmail(String email);

    Utilisateur findByIduser(Long iduser);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO utilisateur (nom, prenom, email, numero, password, role_idrole, entite_id_entite)  VALUES(\"Kaloga\", \"Fatoumata\", \"fk1@orangemali.com\",  \"676665554\",  \"1234\", 1,1);",nativeQuery = true)
    void creationadmin();
}
