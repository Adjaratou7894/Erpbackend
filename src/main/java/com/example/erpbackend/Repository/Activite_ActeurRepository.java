package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur_activites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Activite_ActeurRepository extends JpaRepository<Acteur_activites,Long> {


    @Modifying
    @Transactional
    @Query(value = "insert into acteur_activites(acteur_id, activite_id) values (?, ?);", nativeQuery = true)
    int INSERT_ACTEUR_ACTIVITES(Long acteur_id, Long activite_id);




}
