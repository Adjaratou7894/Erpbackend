package com.example.erpbackend.Repository;


import com.example.erpbackend.Model.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnneeRepository extends JpaRepository<Annee, Long> {
    Annee findByAnnee(int annee);
    @Query(value = "SELECT annee.annee from annee;",nativeQuery = true)
    List<Object> afficherAnnee();
}
