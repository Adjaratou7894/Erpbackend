package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;

import java.util.List;

public interface ListePostulantService {

    ReponseMessage ajouterListePostulant(Liste_postulant liste_postulant);

    List<Liste_postulant> afficherListePostulant();

    Liste_postulant modifierListePostulant (Liste_postulant liste_postulant);

    ReponseMessage supprimerListePostulant (Long idlistepostulant);

    Liste_postulant trouverStatuParIdListePostulant (Long idlistepostulant);
}
