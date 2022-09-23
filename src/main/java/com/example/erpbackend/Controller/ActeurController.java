package com.example.erpbackend.Controller;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Service.ActeurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "Gestion des Acteur")
@AllArgsConstructor
@RequestMapping("/acteur")

public class ActeurController {

    private final ActeurService acteurService;

    @ApiOperation(value = "Creer un Acteur")
    @PostMapping("/ajouter")
    public ReponseMessage creerActeur(@RequestBody Acteur acteur){
        return acteurService.creerActeur(acteur);
    }
    @ApiOperation(value = "Modifier un Acteur")
    @PutMapping("/modifier")
    public ReponseMessage modifierActeur(@RequestBody Acteur acteur){
        return acteurService.modifierActeur(acteur);
    }
    @ApiOperation(value = "Afficher la liste des Acteur")
    @GetMapping("/afficheracteur")
    public List<Acteur> afficheracteur(){
        return acteurService.afficherToutLesActeurs();
    }
    @ApiOperation(value = "Supprimer un Acteur")
    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage delete (@PathVariable Long id){
        return acteurService.SupprimerActeur(id);
    }

}
