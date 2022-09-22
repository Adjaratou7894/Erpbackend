package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Etat_activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EtatActiviteRepository extends JpaRepository<Etat_activite,Long> {
    Etat_activite findByEtat(String etat);

    Etat_activite findByIdetat(Long idetat);
}
