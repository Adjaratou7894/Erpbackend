package com.example.erpbackend.Repository;


import com.example.erpbackend.Model.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeRepository extends JpaRepository<Annee, Long> {
    Annee findByAnnee(int annee);
}
