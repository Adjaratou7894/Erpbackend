package com.example.erpbackend.Controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Service.ActiviteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/activite")
@Api(value = "hello", description = "controller permettant la Gestion des activtés")
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================
    @ApiOperation(value = "ici on Ajouter une activité")
    @PostMapping("/ajouter/{idacteurs}")
    public ReponseMessage create(@RequestBody Activite activite , @PathVariable String idacteurs){
//
        //, idacteurs
        return activiteService.ajouterActivite(activite, idacteurs);

    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Modifier une activité")
    @PutMapping("/modifier")
    public ReponseMessage update(@RequestBody Activite activite){

        return activiteService.modifierActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher")
    public List<Activite> read(){

        return activiteService.afficherActivite();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES========================

    @ApiOperation(value = "ici on Supprimer une activité")
    @DeleteMapping("/supprimer/{idactivite}")
    public ReponseMessage delete(@PathVariable Long idactivite){

        return activiteService.supprimerActivite(idactivite);
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================
}
