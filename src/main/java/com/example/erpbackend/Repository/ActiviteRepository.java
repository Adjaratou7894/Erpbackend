package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

    Activite findByNom(String nom);

    Activite findByIdactivite(Long idactivite);

}
