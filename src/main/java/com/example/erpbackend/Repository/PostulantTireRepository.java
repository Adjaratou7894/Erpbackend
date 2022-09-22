package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Postulant_tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantTireRepository extends JpaRepository<Postulant_tire,Long> {
}
