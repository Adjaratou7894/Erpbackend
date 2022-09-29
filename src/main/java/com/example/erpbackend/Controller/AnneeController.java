package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Annee;
import com.example.erpbackend.ServiceImplementation.AnneeSerciceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@Api(value = "hello", description = "controller permettant la Gestion des Années")
@RequestMapping("/annee")
public class AnneeController {

    @Autowired
    private final AnneeSerciceImplement anneeServiceImplement;

    @ApiOperation(value = "ici on ajoute un Entité")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterAnnee(@RequestBody Annee annee){
        return anneeServiceImplement.ajouterAnnee(annee);
    }
}
