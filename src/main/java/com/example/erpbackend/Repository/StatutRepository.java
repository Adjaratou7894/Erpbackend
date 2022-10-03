package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface StatutRepository extends JpaRepository<Statut,Long> {

    Statut findByNom(String nom);

    Statut findByIdstatut(Long idstatut);

    @Query(value = "SELECT idstatut  FROM `statut` WHERE nom=:nomm", nativeQuery = true)
    int retrouverid(String nomm);


}
