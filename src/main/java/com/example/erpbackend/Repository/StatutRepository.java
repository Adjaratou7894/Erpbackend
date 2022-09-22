package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StatutRepository extends JpaRepository<Statut,Long> {
}
