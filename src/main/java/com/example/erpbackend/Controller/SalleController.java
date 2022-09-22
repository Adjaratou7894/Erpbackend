package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Service.SalleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salle")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class SalleController {
   @Autowired
    private  SalleService SalleService;
    @ApiOperation(value = "Ajout d'une Salle")
   @PostMapping("/AjouterSalle")
    public Salle AjouterSalle(@RequestBody Salle salle){
       return SalleService.AjouterSalle(salle);
   }
    @ApiOperation(value = "Affichage de Toutes Les Salles")
   @GetMapping("/afficherToutesLesSalles")
    public List<Salle> afficherToutesLesSalles(){
       return SalleService.AffichageDesSalle();
   }
    @ApiOperation(value = "Affichage de Toutes Les Salles Occupées")
    @GetMapping("/afficherToutesLesSallesOccupee")
    public List<Salle> afficherToutesLesSallesOccupee(){
        return SalleService.AffichageDesSalleOccupee();
    }
    @ApiOperation(value = "Affichage de Toutes Les Salles Libres")
    @GetMapping("/afficherToutesLesSallesLibre")
    public List<Salle> afficherToutesLesSallesLibre(){
        return SalleService.AffichageDesSalleOccupee();
    }
    @ApiOperation(value = "Modification d'une Salle")
    @PutMapping("/modifierSalle/{id}")
    public Salle modifier(@PathVariable Long id,@RequestBody Salle Salle){
        return SalleService.modifierSalle(id,Salle);}

    @ApiOperation(value = "Suppression d'une Salle")
    @DeleteMapping("/SupprimerSalle")
    public String supprimer(@PathVariable Long id){
        return SalleService.SupprissionSalle(id);
    }
}

