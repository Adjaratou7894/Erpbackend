package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TachesRepository extends JpaRepository<Taches, Long> {
    Taches findByIdTache(Long idTache);
}
