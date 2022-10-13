package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
    Acteur findByNom(String nom);

   // Acteur findByIdacteur(Long idacteur);

    Acteur findByNumero(String numero);

    @Query(
            value = "Select * from acteur where idacteur = :idacteur",
            nativeQuery = true
    )
    public List<Acteur> findByIdacteur(Long idacteur);

    @Query(value = "SELECT DISTINCT acteur.prenom, acteur.nom, acteur.numero, acteur.email, role.nom as" +
            " \"nomRole\" FROM `acteur`, role,utilisateur,statut WHERE acteur.statut_idstatut = " +
            "statut.idstatut AND utilisateur.role_idrole = role.idrole AND role.nom =:role.nom ", nativeQuery = true)
    public List<Object> AfficherActeurRole(String role);

    @Query(value = "SELECT DISTINCT acteur.prenom, acteur.nom, acteur.numero, acteur.email, role.nom as" +
            " \"nomRole\" FROM `acteur`, role,utilisateur,statut WHERE acteur.statut_idstatut = " +
            "statut.idstatut AND utilisateur.role_idrole = role.idrole  ", nativeQuery = true)
    public List<Object> AfficherActeurRoleTout();

}

