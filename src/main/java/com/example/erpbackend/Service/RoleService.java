package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Model.Role;

import java.util.List;

public interface RoleService {


    //================METHODE PERMETTANT D'AJOUTER UN ROLE=========================
    ReponseMessage ajouterRole(Role role);


    //================METHODE PERMETTANT DE MODIFIER UN ROLE=========================
    ReponseMessage modifierRole(Role role);

    //================METHODE PERMETTANT D'AFFICHER LES ROLES=========================
    List<Role> afficherRole();

    //================METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================
    ReponseMessage supprimerRole(Long idrole);


    //================METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UN ROLE=========================
    Role trouverRoleParId(Long idrole);
}
