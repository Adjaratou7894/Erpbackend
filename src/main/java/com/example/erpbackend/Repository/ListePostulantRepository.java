package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Liste_postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ListePostulantRepository extends JpaRepository<Liste_postulant, Long> {
}
