package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    @Query(value = "SELECT * from salle where disponibilite = True", nativeQuery = true)
    public List<Salle> AfficherLesSallesDisponible();
    @Query(value = "SELECT * from salle where disponibilite = False", nativeQuery = true)
    public List<Salle> AfficherLesSallesOccupee();

    Salle findByIdsalle(Long idsalle);

}
