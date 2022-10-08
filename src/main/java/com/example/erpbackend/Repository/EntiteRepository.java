package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface EntiteRepository extends JpaRepository<Entite, Long> {

    Entite findByNom(String nom);

    Entite findByIdEntite(Long idEntite);

    @Modifying
    @Transactional
    @Query(value = " INSERT INTO ENTITE (nom) VALUES (\"Kalanso\");",nativeQuery = true)
    void creationentite();
    //Affichicher les entités au niveau du Dashbord Admin
    @Query(value = " SELECT entite.id_entite, entite.nom , entite.photoentite FROM entite LIMIT 4;",nativeQuery = true)
    List<Object> afficherEntiteAccueil();

}
