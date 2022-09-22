package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;

import java.util.List;

public interface EtatActiviteService {

    //ajoute un etat activite
    Etat_activite ajouterEtatActivite(Etat_activite etat_activite);

    //modifie un etat activite
    Etat_activite modifierEtatActivite(Etat_activite etat_activite);

    //supprime un etat activite
    ReponseMessage supprimerEtatActivite(Long id);

    //afficher les etat activites
    List<Etat_activite> afficherEtatActivite();
}
