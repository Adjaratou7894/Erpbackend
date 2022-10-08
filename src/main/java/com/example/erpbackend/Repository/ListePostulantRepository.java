package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ListePostulantRepository extends JpaRepository<Liste_postulant, Long> {

    Liste_postulant findByLibelleliste(String libelleliste);

    Liste_postulant findByIdliste(Long idlistepostulant);

    @Query(value = "SELECT * FROM liste_postulant, tirage WHERE liste_postulant.idliste = tirage.liste_postulant_idliste and validite = 0;", nativeQuery = true)
    List<Liste_postulant> FIND_ALL_LISTE_NOT_VALILIDE();
}
