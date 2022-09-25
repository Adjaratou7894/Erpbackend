package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface PostulantRepository extends JpaRepository<Postulant,Long> {

    //use in trie
    @Query(value = "select * from postulant where liste_postulant_idliste = :liste_postulant_idliste", nativeQuery = true)
    List<Postulant> FIND_POSTULANT_PAR_ID_LIST(@Param("liste_postulant_idliste") Long liste_postulant_idliste);

    //use in insertion postulant
    @Query(value = "select * from postulant where liste_postulant_idliste = :liste_postulant_idliste", nativeQuery = true)
    List<Postulant> FIND_POSTULANT_FROM_LISTE(@Param("liste_postulant_idliste") Long liste_postulant_idliste);

    @Query(value = "select * from postulant where numero_postulant = :numero_postulant", nativeQuery = true)
    Postulant FIND_POSTULANT_PAR_NUMERO(@Param("numero_postulant") String numero_postulant);

    @Query(value = "select * from postulant where id = :id", nativeQuery = true)
    Postulant FIND_POSTULANT_PAR_ID(@Param("id") Long id);



    Postulant findByGenre (String genre);
}
