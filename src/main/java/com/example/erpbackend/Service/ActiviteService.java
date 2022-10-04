package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ActiviteService {
    //,
    //================METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================
    ReponseMessage ajouterActivite(Activite activite, String idacteurs, String idacteurInternes);


    //================METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================
    ReponseMessage modifierActivite(Activite activite);

    //================METHODE PERMETTANT D'AFFICHER LES ACTIVITES=========================
    List<Activite> afficherActivite();

    //================METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE=========================
    ReponseMessage supprimerActivite(Long idactivite);


    //================METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================
    Activite trouverActiviteParId(Long idactivite);

    Activite trouverActiviteParLibelle(String libelleActivite);

    //ReponseMessage lancerActivite(Long idAct);

    //ReponseMessage closeActivite(Long idAct);

    List<Object> afficheActiviteEnFonctionEtat(String etat);

    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES D'UNE ANNEE ====================================
    List<Object> ActiviteParAnnee(int annee);

    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES PAR ETAT ====================================
    List<Activite> activiteParEtat(String etat);


    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES PAR LA DATE LA PLUS RECENTE ====================
    List<Object> activiteParDatePlusRecente();



    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES PAR INTERVALE DE DATE ========================
    List<Object> activiteParDateIntervale(String dateDebut, String dateFin) throws ParseException;


    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES PAR ENTITE ===================================
    List<Object> activiteParEntite(String entite);

    //================METHODE PERMETTANT DE RECUPERER LES ACTIVITES PAR ENTITE et STATUS ===========================
    List<Object> activiteParEntiteEtStatut(String entite, String statut);

    int nombreFormation();
    int nombreTalks();
    int nombreEvenement();


    int recupererNombreActiviteParMois(int mois);

    int recupererNombreActivitePartypeactivite(String type_activite);


    public ReponseMessage AgetBytes(long idactivite) throws IOException;



}
