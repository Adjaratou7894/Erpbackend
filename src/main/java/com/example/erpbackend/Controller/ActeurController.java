package com.example.erpbackend.Controller;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Service.ActeurService;
import com.example.erpbackend.Service.StatutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant Gestion des Acteur")
@CrossOrigin(origins = "http://localhost:8100")
@AllArgsConstructor
@RequestMapping("/acteur")
public class ActeurController {

    @Autowired
    final private ActeurService acteurService;

    @Autowired
    final private StatutService statutService;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ACTEUR======================
    @ApiOperation(value = "ici on ajoute un Acteur")
    @PostMapping("/ajouter/{stat}")
    public ReponseMessage creerActeur(@RequestBody Acteur acteur, @PathVariable String stat){
        Statut ok=new Statut();
        ok= statutService.trouverparnom(stat);
        acteur.setStatut(ok);
        return acteurService.creerActeur(acteur);
        //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTEUR======================
    }

    @ApiOperation(value = "ici on Modifier un Acteur")
    @PutMapping("/modifier/{idacteur}")
    public Acteur modifierActeur(@RequestBody Acteur acteur, @PathVariable Long idacteur){

        return acteurService.modifierActeur(acteur, idacteur);
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
    @ApiOperation(value = "ici on Afficher la liste des Acteur")
    @GetMapping("/afficherAvecRole")
    public List<Object> AfficherActeurRoleTout(){

        return acteurService.AfficherActeurRoleTout();
    }

    @ApiOperation(value = "ici on Afficher la liste des Acteur")
    @GetMapping("/unacteur/{idacteur}")
    public List<Acteur> trouverActeurParId(@PathVariable long idacteur) {
        return acteurService.trouverActeurParId(idacteur);
    }


}
