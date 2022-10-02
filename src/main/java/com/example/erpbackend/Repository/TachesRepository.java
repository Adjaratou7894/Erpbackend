package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TachesRepository extends JpaRepository<Taches, Long> {
    Taches findByIdTache(Long idTache);

    @Modifying
    @Transactional
    @Query(value = "insert into taches_utilisateurs(iduser, idst) values (?,?);", nativeQuery = true)
    int insert_taches_utilisateurs(Long iduser, Long idst);
}
