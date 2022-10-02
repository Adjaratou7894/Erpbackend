package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface EntiteRepository extends JpaRepository<Entite, Long> {

    Entite findByNom(String nom);

    Entite findByIdEntite(Long idEntite);

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO ENTITE (nom) VALUES (\"Kalanso\");",nativeQuery = true)
    void creationentite();
}
