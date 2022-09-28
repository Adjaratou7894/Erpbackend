package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
    Designation findByLibelle(String libelle);
}
