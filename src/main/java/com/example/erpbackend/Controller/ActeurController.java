package com.example.erpbackend.Controller;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Service.ActeurService;
import com.example.erpbackend.Service.StatutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Api(value = "hello", description = "controller permettant Gestion des Acteur")
@AllArgsConstructor
@RequestMapping("/acteur")
@CrossOrigin(origins = "http://localhost:8100")
public class ActeurController {

    private final ActeurService acteurService;
    private final StatutService statutService;
    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ACTEUR======================
    @ApiOperation(value = "ici on ajoute un Acteur")
    @PostMapping("/ajouter/{lib}")
    public ReponseMessage creerActeur(@RequestBody Acteur acteur,@PathVariable String lib){
        Statut ok=new Statut();
       ok= statutService.trouverparnom(lib);
       acteur.setStatut(ok);
        return acteurService.creerActeur(acteur);
        //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTEUR======================
    }

    @ApiOperation(value = "ici on Modifier un Acteur")
    @PutMapping("/modifier")
    public ReponseMessage modifierActeur(@RequestBody Acteur acteur){

        return acteurService.modifierActeur(acteur);
    }

    @ApiOperation(value = "ici on Afficher la liste des Acteur")
    @GetMapping("/afficher")
    public List<Acteur> afficheracteur(){

        return acteurService.afficherToutLesActeurs();
    }

    @ApiOperation(value = "ici on Supprimer un Acteur")
    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage delete (@PathVariable Long id){

        return acteurService.SupprimerActeur(id);
    }

}
