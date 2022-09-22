package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Entite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EntiteRepository extends JpaRepository<Entite, Long> {
}
