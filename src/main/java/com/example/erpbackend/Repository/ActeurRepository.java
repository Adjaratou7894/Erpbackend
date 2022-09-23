package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
    Acteur findByNom(String nom);

    Acteur findByIdacteur(Long idacteur);

    Acteur findByNumero(String numero);
}

