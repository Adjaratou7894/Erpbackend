package com.example.erpbackend.Service;


import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Acteur;

import java.util.List;

public interface ActeurService {

    // Création d'un acteur
    ReponseMessage creerActeur(Acteur acteur);

    // Mise à jour d'un acteur
    Acteur modifierActeur(Acteur acteur, Long idacteur);

    List<Acteur> trouverActeurParId(long idacteur);

    List<Acteur> afficherToutLesActeurs();
    ReponseMessage SupprimerActeur(Long idacteur);

    public List<Object> AfficherActeurRoleTout();




}
