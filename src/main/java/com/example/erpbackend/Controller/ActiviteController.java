package com.example.erpbackend.Controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Service.ActiviteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/activite")
@Api(value = "hello", description = "controller permettant la Gestion des activtés")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================
    @ApiOperation(value = "ici on Ajouter une activité")
    @PostMapping("/ajouter/{idacteurs}/{idacteurInternes}")
    public ReponseMessage createactivite(@RequestBody Activite activite , @PathVariable String idacteurs, @PathVariable String idacteurInternes){
//

        //, idacteurs
        return activiteService.ajouterActivite(activite, idacteurs, idacteurInternes);

    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Modifier une activité")
    @PutMapping("/modifier ")
    public ReponseMessage updateactivite(@RequestBody Activite activite){

        return activiteService.modifierActivite(activite);
    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE======================

    @ApiOperation(value = "ici on Afficher la liste des activités")
    @GetMapping("/afficher")
    public List<Activite> readactivite(){

        return activiteService.afficherActivite();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES========================

    @ApiOperation(value = "ici on Supprimer une activité")
    @DeleteMapping("/supprimer/{idactivite}")
    public ReponseMessage deleteactivite(@PathVariable Long idactivite){

        return activiteService.supprimerActivite(idactivite);
    }

    @ApiOperation(value = "Ici on affiche les trois activites recente en fontion de l'etat")
    @GetMapping("/activitesRecentes/{etatActivite}")
    public List<Object> trouverTroisActviteParEtat(@PathVariable String etatActivite){

        return activiteService.afficheActiviteEnFonctionEtat(etatActivite);
    }


    @GetMapping("/ParAnnee/{annee}")
    public List<Object> ActiviteParAnnee(@PathVariable int annee) {
        return activiteService.ActiviteParAnnee(annee);
    }


    @GetMapping("/ParEtat/{etat}")
    public List<Activite> activiteParEtat(@PathVariable String etat) {
        return activiteService.activiteParEtat(etat);
    }

    @GetMapping("/parDatePlusRecente")
    List<Object> activiteParDatePlusRecente(){
        return activiteService.activiteParDatePlusRecente();
    }



    @GetMapping("/parDateIntervale/{dateDebut}/{dateFin}")
    public List<Object> activiteParDateIntervale(@PathVariable String dateDebut, @PathVariable String dateFin) throws ParseException {
        return activiteService.activiteParDateIntervale(dateDebut, dateFin);
    }


    @GetMapping("/parEntite/{entite}")
    public List<Object> activiteParEntite(@PathVariable String entite) {
        return activiteService.activiteParEntite(entite);
    }


    @GetMapping("/parEntiteStatus/{entite}/{statut}")
    public List<Object> activiteParEntiteEtStatut(@PathVariable String entite, @PathVariable String statut) {
        return activiteService.activiteParEntiteEtStatut(entite, statut);
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE======================
}


