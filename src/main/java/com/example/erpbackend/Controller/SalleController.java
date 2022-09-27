package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Service.SalleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Test", description = "controller permettent la Gestion Des Salle")
@RequestMapping("/salle")
@CrossOrigin(origins = "http://localhost:8100")
public class SalleController {
    @Autowired
    private SalleService SalleService;

    @ApiOperation(value = "ici on Ajout d'une Salle")
    @PostMapping("/ajouter")
    public ReponseMessage AjouterSalle(@RequestBody Salle salle) {

        return SalleService.AjouterSalle(salle);
    }

    @ApiOperation(value = "ici on Affichage de Toutes Les Salles")
    @GetMapping("/afficher")
    public List<Salle> afficherToutesLesSalles() {

        return SalleService.AffichageDesSalle();
    }

    @ApiOperation(value = "ici on Affiche de Toutes Les Salles Occupées")
    @GetMapping("/afficherToutesLesSallesOccupee")
    public List<Salle> afficherToutesLesSallesOccupee() {

        return SalleService.AffichageDesSalleLibre();
    }


    @ApiOperation(value = "ici on Affiche de Toutes Les Salles Libres")
    @GetMapping("/afficherToutesLesSallesLibre")
    public List<Salle> afficherToutesLesSallesLibre() {

        return SalleService.AffichageDesSalleOccupee();
    }
    // ============================== Récuperer le nombre de salle disponibles dans la base de données ===============
    @ApiOperation(value = "ici on Afficher le nombre de salle disponible ")
    @GetMapping("/affichernbresalledispo")
    public int nbresalledispo(){

        return SalleService.AffichageDesSalleOccupee().size();
    }

    @ApiOperation(value = "ici on Modifier d'une Salle")
    @PutMapping("/modifier")
    public ReponseMessage modifiersalle(@RequestBody Salle Salle){

            return SalleService.modifierSalle(Salle);
    }

    @ApiOperation(value = "ici on Supprime d'une Salle")
    @DeleteMapping("/supprimer/{idsalle}")
    public ReponseMessage supprimersalle(@PathVariable Long idsalle){

        return SalleService.SupprissionSalle(idsalle);
    }

}
