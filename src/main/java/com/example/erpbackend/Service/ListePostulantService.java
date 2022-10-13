package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;

import java.util.List;

public interface ListePostulantService {

    ReponseMessage ajouterListePostulant(Liste_postulant liste_postulant);

    List<Liste_postulant> afficherListePostulant();

    Liste_postulant modifierListePostulant (Liste_postulant liste_postulant);

    ReponseMessage supprimerListePostulant (Long idlistepostulant);

    Liste_postulant trouverStatuParIdListePostulant (Long idlistepostulant);

    Liste_postulant trouverListePostulantParLibelle(String libelleliste);

    Liste_postulant creerlistepostulant(Liste_postulant listePostulant);

    List<Liste_postulant> recupererListeAvecTirageNonValide();
    List<Object> trouver(String lib);

}
