package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Postulant;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostulantService {

    List<Postulant> enregistrerPostulant(List<Postulant> listPost);

    Postulant ajouterPostulant(Postulant postulant);

    List<Postulant> afficherPostulant();

    List <Postulant> trouverPostulantParGenre(String genre);

    List<Object> trouverAllApprenantOuParticipant(String typePostulant);

    List<Object> filtreParGenreETActivite(String genre, String nom);

    List<Object> filtreParActivite(String activite);

}
