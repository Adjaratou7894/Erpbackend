package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TirageRepository extends JpaRepository<Tirage,Long> {
    Tirage findByLibelleTirage(String libelleTirage);

    @Query(value = "SELECT COUNT(idtirage) FROM `tirage`", nativeQuery = true)
    Long nombretirageTotale();


    @Query(value = "SELECT * FROM `tirage` WHERE tirage.id_liste_postulant = :id_liste_postulant", nativeQuery = true)
    Iterable<Object[]> trouverParId(Long id_liste_postulant);

}
