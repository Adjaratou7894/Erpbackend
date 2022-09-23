package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Role;
import com.example.erpbackend.Service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "hello", description = "Gestion des Rôles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================
    @ApiOperation(value = "Ajouter un rôle")
    @PostMapping("/ajouter")
    public ReponseMessage create(@RequestBody Role role){

        return roleService.ajouterRole(role);
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================
    @ApiOperation(value = "Modifier un rôle")
    @PutMapping("/modifier")
    public ReponseMessage update(@RequestBody Role role){

            return roleService.modifierRole(role);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ROLES======================
    @ApiOperation(value = "Afficher la liste des rôles")
    @GetMapping("/Afficher")
    public List<Role> read(){

        return roleService.afficherRole();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ROLES========================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================
    @ApiOperation(value = "Supprimer un rôle")
    @DeleteMapping("/supprimer/{idrole}")
    public ReponseMessage delete(@PathVariable Long idrole){

        return roleService.supprimerRole(idrole);
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================
}
