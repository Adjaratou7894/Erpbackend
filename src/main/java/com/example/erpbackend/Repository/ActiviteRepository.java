package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
}
