package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);

    Utilisateur modifierUtilisateur(Utilisateur utilisateur, Long id);

    List<Utilisateur> afficherUtilisateur();

    String supprimerUtilisateur(Long id);

    Object seConnecter(String email, String motDePasse);

}
