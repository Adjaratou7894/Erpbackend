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

    List<Object> troisActiviteRecente();


    int recupererNombreActiviteParMois(int mois);

    int recupererNombreActivitePartypeactivite(String type_activite);

    // debut de statistique kalanso
    int janvierKalanso();int fevrierKalanso();int MarsKalanso();  int AvrilKalanso();
    int MaiKalanso(); int juinKalanso(); int juilletKalanso(); int AoutKalanso();
    int SepKalanso();  int octKalanso();    int noKalanso();   int deKalanso();
    // fin du statisqtique kalanso

    // debut de statistique fab
    int janvierfab();int fevrierfab();int Marsfab();  int Avrilfab();
    int Maifab(); int juinfab(); int juilletfab(); int Aoutfab();
    int Sepfab();  int octfab();    int nofab();   int defab();
    // fin du statisqtique fab



    // debur de statistique kalanso
    int janvierFablab();int fevrierFablab();int MarsFablab();  int AvrilFablab();
    int MaiFablab(); int juinFablab(); int juilletFablab(); int AoutFablab();
    int SepFablab();  int octFablab();    int noFablab();   int deFablab();
    // fin du statisqtique kalanso







    public ReponseMessage AgetBytes(long idactivite) throws IOException;

    List<Object> troisActiviteavenir();

    List<Object> afficherActiviteParId(int idactivite);
    List<Activite> activiteParEntiteEtTypeActivite(String etatActivite, Long idEntite);

    List<Activite> activiteParTypeActiviteEtEntite(String typeActivite, Long idEntite);



    //++++++++++++++++++++++++++++++++++++++++++ List<Object> LES_PERONNES_TIREE_VALIDE(Long  idActivite);

    List<Object> LES_PERONNES_TIREE_V(Long  idActivite);



}
