package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Utilisateur;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurService {

    ReponseMessage ajouterUtilisateur(Utilisateur utilisateur);

    ReponseMessage modifierUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> afficherUtilisateur();

    ReponseMessage supprimerUtilisateur(Long iduser);

    Object seConnecter(String email, String motDePasse);

    List<Object> afficherUtilisateurParEntite(String entite);

    List<Object> findUtilisateurParEntiteToute();

    Utilisateur trouverUtilisateurParId(Long id);

    List<Object> responsableParEntite(Long idEntite, String role);



}
