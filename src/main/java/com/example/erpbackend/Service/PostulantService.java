package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Postulant;

import java.util.List;

public interface PostulantService {

    List<Postulant> enregistrerPostulant(List<Postulant> listPost);

    Postulant ajouterPostulant(Postulant postulant, String libelleListe);

    List<Postulant> afficherPostulant();

    Postulant trouverPostulantParGenre(String genre);

    List<Object> trouverAllApprenantOuParticipant(String typePostulant);
}
