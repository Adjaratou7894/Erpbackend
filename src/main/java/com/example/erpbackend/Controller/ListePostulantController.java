package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Service.ListePostulantService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "controller permettant Gestion de la liste des Postulants")
@RequestMapping("/listepostulant")
@AllArgsConstructor
public class ListePostulantController {

    @Autowired
    private final ListePostulantService listePostulantService;

    @ApiOperation(value = "ici on ajouter la Liste Postulant ")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterListePostulant(@RequestBody Liste_postulant listePostulant) {

        return listePostulantService.ajouterListePostulant(listePostulant);
    }

    @ApiOperation(value = "ici on afficher la Liste Postulant ")
    @GetMapping("/afficher")
    public List<Liste_postulant> afficherListePostulant() {

        return listePostulantService.afficherListePostulant();
    }

    @ApiOperation(value = "ici on modifier la Liste Postulant ")
    @PutMapping("/modifier")
    public ReponseMessage updateListePostulant(@RequestBody Liste_postulant listePostulant) {
        if (listePostulantService.trouverStatuParIdListePostulant(listePostulant.getIdliste()) != null) {
            listePostulantService.modifierListePostulant(listePostulant);
            ReponseMessage message = new ReponseMessage("Liste Postulant modifié avec suces", true);

            return message;
        } else {
            ReponseMessage message = new ReponseMessage("Liste Postulant non trouvé", false);

            return message;
        }
    }

    @ApiOperation(value = "ici on supprimer la Liste Postulant ")
    @DeleteMapping("/supprimer/{idlistepostulant}")
    public ReponseMessage deleteListePostulant(@PathVariable Long idlistepostulant){

        return listePostulantService.supprimerListePostulant(idlistepostulant);
    }

}
