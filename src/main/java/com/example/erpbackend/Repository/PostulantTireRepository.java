package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Postulant_tire;
import com.example.erpbackend.Model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostulantTireRepository extends JpaRepository<Postulant_tire,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_tire(id_postulant, tirage_idtirage) VALUES(?,?);",nativeQuery = true)
    int INSERT_POST_TIRE(Long id_postulant, Long tirage_idtirage);

   // Postulant_tire findById(Long id);
   Postulant_tire findByIdPostulant(Long idPostulant);

   @Query(value = "select id_postulant from postulant_tire, tirage where postulant_tire.tirage_idtirage = tirage.idtirage and tirage.validite = 1", nativeQuery = true)
    List<Long> FIND_ALL_POSTULANT_TIRE();

   /*
    @Query(value = "select * from postulant where genre = :genre", nativeQuery = true)
    List<String> FIND_POSTULANT_PAR_GENRE(@Param("genre") String genre);
    */

    @Query(value = "select postulant_tire.id_postulant from postulant_tire where postulant_tire.tirage_idtirage = :tirage_idtirage", nativeQuery = true)
    List<Long> FIND_ALL_POSTULANT_TIRE_PAR_TIRAGE(@Param("tirage_idtirage") Long tirage_idtirage);

}
