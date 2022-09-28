package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.StatutTache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutTacheRepository extends JpaRepository<StatutTache, Long> {

    StatutTache findByLibelle(String libelle);

}
