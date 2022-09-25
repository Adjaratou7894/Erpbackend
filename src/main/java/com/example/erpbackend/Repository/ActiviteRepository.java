package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    Activite findByNom(String nom);

    Activite findByIdactivite(Long idactivite);

    @Query(value = "select activite.nom, etat_activite.etat from activite, etat_activite " +
            "where activite.etat_activite_idetat = etat_activite.idetat and " +
            "etat_activite.etat = :etat order by date_debut LIMIT 3", nativeQuery = true)
    List<Object> FIND_ACTIVITE_PAR_ETAT(@Param("etat") String etat);
}
