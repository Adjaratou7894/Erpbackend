package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;

import java.util.List;

public interface TirageService {
    //methode permettant de faire le trie avec la liste des postulant à trie et le nombre à trié en parametre
    List<Postulant> trie(List<Postulant> listAtrier, Long nbre);

    //methode permettant de creer un tirage
    Tirage creer(Tirage tirage, Liste_postulant liste);

    //methode permettant de trouver un tirage par son libellet
    Tirage trouverTirageParLibelle(String libelleTirage);

    List<Tirage> lire();

    //methode permettant d'afficher nombre total des tirages
    Long nombreTotaltirage();

    //methode permettant d'affichertirage par idliste
    Iterable<Object[]> AfficherTousLesTirages(Long idlistepostulant);


    //methode permettant d'affichertirage par idTirage
    Tirage recupererTirageIdTirage(Long idtirage);


}
