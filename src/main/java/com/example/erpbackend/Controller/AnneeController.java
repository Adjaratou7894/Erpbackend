package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Annee;
import com.example.erpbackend.Service.AnneeService;
import com.example.erpbackend.ServiceImplementation.AnneeSerciceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Data
@Api(value = "hello", description = "controller permettant la Gestion des Années")
@CrossOrigin(origins = "*")
@RequestMapping("/annee")
public class AnneeController {

    @Autowired
    private final AnneeService anneeService;

    @ApiOperation(value = "ici on ajoute un Entité")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterAnnee(@RequestBody Annee annee){

        return anneeService.ajouterAnnee(annee);
    }

/*
    @ApiOperation(value = "ici on affiche toutes année")
    @GetMapping("/afficher")
    public List<Annee> recupererLesAnnee() {

        return anneeService.recupererLesAnnee();
    }
    */

    @GetMapping("/affiche")
    public List<Annee> afficherAnnee(){
       return anneeService.afficherAnnee();
    }


}
