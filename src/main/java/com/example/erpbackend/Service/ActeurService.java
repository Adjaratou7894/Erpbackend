package com.example.erpbackend.Service;


import com.example.erpbackend.Model.Acteur;

import java.util.List;

public interface ActeurService {
    // Création d'un acteur
    Acteur creerActeur(Acteur acteur);

    // Mise à jour d'un acteur
    Acteur modifierActeur( Long id ,Acteur acteur);

    List<Acteur> afficherToutLesActeurs();
    String SupprimerActeur(Long id);


}
