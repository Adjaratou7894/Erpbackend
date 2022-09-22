package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostulantRepository extends JpaRepository<Postulant,Long> {
}
