package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Role;

import java.util.List;

public interface RoleService {


    //================METHODE PERMETTANT D'AJOUTER UN ROLE=========================
    Role ajouterRole(Role role);


    //================METHODE PERMETTANT DE MODIFIER UN ROLE=========================
    Role modifierRole(Role role);

    //================METHODE PERMETTANT D'AFFICHER LES ROLES=========================
    List<Role> afficherRole();

    //================METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================
    String supprimerRole(Long id);
}
