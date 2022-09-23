package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import com.example.erpbackend.Service.ActiviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activite")

public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================
    @ApiOperation(value = "Ajouter une activité")
    @PostMapping("/ajouter")
    public ReponseMessage create(@RequestBody Activite activite){
        return activiteService.ajouterActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================
    @ApiOperation(value = "Modifier une activité")
    @PutMapping("/modifier")
    public ReponseMessage update(@RequestBody Activite activite){
        return activiteService.modifierActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES======================
    @ApiOperation(value = "Afficher la liste des activités")
    @GetMapping("/Afficher")
    public List<Activite> read(){

        return activiteService.afficherActivite();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES========================

    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================
    @ApiOperation(value = "Supprimer une activité")
    @DeleteMapping("/supprimer/{idactivite}")
    public ReponseMessage delete(@PathVariable Long idactivite){

        return activiteService.supprimerActivite(idactivite);
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================
}
