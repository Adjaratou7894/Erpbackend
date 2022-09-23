package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;

import java.util.List;

public interface ActiviteService {
    //================METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================
    ReponseMessage ajouterActivite(Activite activite);


    //================METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================
    ReponseMessage modifierActivite(Activite activite);

    //================METHODE PERMETTANT D'AFFICHER LES ACTIVITES=========================
    List<Activite> afficherActivite();

    //================METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE=========================
    ReponseMessage supprimerActivite(Long idactivite);


    //================METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================
    Activite trouverActiviteParId(Long idactivite);

    Activite trouverActiviteParLibelle(String libelleActivite);

}
