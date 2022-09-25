package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Postulant_tire;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Model.Tirage;

import java.util.List;

public interface PostulantTireService {

    ReponseMessage ajouterPostulantTrie(Postulant postulant, Tirage tirage);

    List<Postulant_tire> listerPostulantTrie();

    ReponseMessage supprimerPostulantTrie(Long id);

   // Postulant_tire trouverPostulantTrieParid (Long id);

    Postulant_tire trouverPostulantTrieParidPostulant (Long idPostulant);

    List<Postulant> recupererTousLesPostulantTire();

    List<Postulant> recupererTousLesPostulantTireFilter(String genre);

    List<Postulant> recupererIdPostulantTireParTirage(Long idTirage);

}
