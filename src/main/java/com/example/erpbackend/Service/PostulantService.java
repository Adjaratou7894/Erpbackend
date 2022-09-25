package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Postulant;

import java.util.List;

public interface PostulantService {

    List<Postulant> enregistrerPostulant(List<Postulant> listPost);

    Postulant ajouterPostulant(Postulant postulant);

    List<Postulant> afficherPostulant();

    Postulant trouverPostulantParGenre(String genre);
}
