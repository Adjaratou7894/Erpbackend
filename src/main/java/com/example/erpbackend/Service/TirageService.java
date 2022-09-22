package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Tirage;

public interface TirageService {
    // Création d'un Tirage
    Tirage creerTirage(Tirage tirage);

    // Modification d'un tirage
    Tirage modifierTirage(Tirage tirage);

    //Recuperer le ti
    Tirage RecupererTirageParId(Long id);
}
