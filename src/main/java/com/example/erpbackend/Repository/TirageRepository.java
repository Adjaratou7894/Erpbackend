package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TirageRepository extends JpaRepository<Tirage,Long> {
    Tirage findByLibelleTirage(String libelleTirage);

    Tirage findByIdtirage(Long idtirage);

    @Query(value = "SELECT COUNT(idtirage) FROM `tirage`", nativeQuery = true)
    Long nombretirageTotale();


    @Query(value = "SELECT * FROM `tirage` WHERE tirage.id_liste_postulant = :id_liste_postulant", nativeQuery = true)
    Iterable<Object[]> trouverParId(Long id_liste_postulant);

    @Query(value = "select * from tirage where tirage.liste_postulant_idliste = :liste_postulant_idliste", nativeQuery = true)
    List<Tirage> FIND_ALL_TIRAGE_PAR_LISTE(@Param("liste_postulant_idliste") Long liste_postulant_idliste);

    @Query(value = "select * from tirage where validite = 1 ORDER BY idtirage DESC", nativeQuery = true)
    List<Tirage> FIND_ALL_TIRAGE_ValidiDE();

    @Query(value = "select * from tirage where validite = 0 ORDER BY idtirage DESC", nativeQuery = true)
    List<Tirage> FIND_ALL_TIRAGE_BY_NONVILIDE();


    @Query(value = "select * from tirage where validite = 1 and tirage.liste_postulant_idliste = :liste_postulant_idliste", nativeQuery = true)
    List<Tirage> FIND_ALL_TIRAGE_NOT_VALIDE_LISTE(@Param("liste_postulant_idliste") Long liste_postulant_idliste);



}
