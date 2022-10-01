package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByEmailAndPassword(String email, String password);

    Utilisateur findByEmail(String email);

    Utilisateur findByIduser(Long iduser);
}
