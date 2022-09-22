package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}
