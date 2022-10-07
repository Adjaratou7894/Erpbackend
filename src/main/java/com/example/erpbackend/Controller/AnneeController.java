package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Annee;
import com.example.erpbackend.ServiceImplementation.AnneeSerciceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@Api(value = "hello", description = "controller permettant la Gestion des Années")
@CrossOrigin(origins = "*")
@RequestMapping("/annee")
public class AnneeController {

    @Autowired
    private final AnneeSerciceImplement anneeServiceImplement;

    @ApiOperation(value = "ici on ajoute un Entité")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterAnnee(@RequestBody Annee annee){

        return anneeServiceImplement.ajouterAnnee(annee);
    }

    @GetMapping("/affiche")
    public List<Annee> afficherAnnee(){
       return anneeServiceImplement.afficherAnnee();
    }
}
