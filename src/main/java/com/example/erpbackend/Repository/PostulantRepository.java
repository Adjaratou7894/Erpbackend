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

    /*
    @Query(value = "select nom_postulant, prenom_postulant,type_activite,type_postulant" +
            " from postulant, liste_postulant, activite, type_activite where " +
            "liste_postulant.idliste = postulant.liste_postulant_idliste and " +
            "activite.type_activite_idactivite = type_activite.idactivite and " +
            "type_activite.type_postulant = :type_postulant;", nativeQuery = true)
    List<Object> FIND_ALL_APPRENANT_OR_PARTICIPANT(@Param("type_postulant") String type_postulant);

     */


    @Query(value = "select distinct postulant_tire.id_postulant from" +
            " postulant_tire,tirage,liste_postulant,activite,type_activite" +
            " where postulant_tire.tirage_idtirage=tirage.idtirage and" +
            " tirage.liste_postulant_idliste = liste_postulant.idliste and " +
            "liste_postulant.activite_idactivite=activite.idactivite and " +
            "activite.type_activite_idactivite=type_activite.idactivite and " +
            "type_activite.type_postulant = :type_postulant", nativeQuery = true)
    List<Object> FIND_ALL_APPRENANT_OR_PARTICIPANT(@Param("type_postulant") String type_postulant);

    @Query(value = "SELECT * FROM postulant WHERE genre=:genre", nativeQuery = true)
   List <Postulant> findByGenre (String genre);

    @Query(value = "SELECT postulant.nom_postulant,postulant.numero_postulant,postulant.genre, activite.nom FROM" +
            " postulant ,liste_postulant ,activite WHERE postulant.liste_postulant_idliste = liste_postulant.idliste" +
            " AND activite.idactivite = liste_postulant.activite_idactivite AND genre=:genre AND activite.nom" +
            " =:activite",nativeQuery = true)
    List<Object> findByGenreAndActivite(@Param("genre") String genre, @Param("activite") String activite);

   @Query(value = "SELECT postulant.nom_postulant,postulant.numero_postulant,postulant.genre, activite.nom FROM postulant" +
           " ,liste_postulant ,activite WHERE postulant.liste_postulant_idliste = liste_postulant.idliste AND" +
           " activite.idactivite = liste_postulant.activite_idactivite AND activite.nom =:activite",nativeQuery = true)
    List<Object> findByActivite( @Param("activite") String activite);

}
