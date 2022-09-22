package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Model.Type_activite;

import java.util.List;

public interface TypeActiviteService {

    // Création d'un Type d'activités
    ReponseMessage ajouterTypeActivite(Type_activite type_activite);

    // Affichage d'un Type d'activités
    List<Type_activite> afficherTypeActivite();


    // Modification Type d'activités
    ReponseMessage modifierTypeActivite(Long id,Type_activite type_activite);

    //Supprimer un Type d'activités
 //
      ReponseMessage supprimerTypeActvite(Long id);


}
