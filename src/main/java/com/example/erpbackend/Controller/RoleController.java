package com.example.erpbackend.Controller;

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
    public String create(@RequestBody Role role){
        roleService.ajouterRole(role);
        return "Rôle ajouté avec succès";
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ROLE======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE======================
    @ApiOperation(value = "Modifier un rôle")
    @PatchMapping("/modifier")
    public String update(@RequestBody Role role){
        roleService.modifierRole(role);
        return "Rôle modifié avec succès";
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
    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable Long id){
            return roleService.supprimerRole(id);
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE======================
}
