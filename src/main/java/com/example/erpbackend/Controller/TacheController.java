package com.example.erpbackend.Controller;


import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Model.Taches;
import com.example.erpbackend.Service.ActiviteService;
import com.example.erpbackend.Service.DesignationService;
import com.example.erpbackend.Service.TacheService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant d'ajouter une tache")
@AllArgsConstructor
@RequestMapping("/tache")
@CrossOrigin(origins = "http://localhost:8100")
public class TacheController {

    final private TacheService tacheService;

    final private ActiviteService activiteService;

    final DesignationService designationService;

    @PostMapping("/ajouter/{idusers}/{idActivite}/{libelleDesignation}")
    ReponseMessage ajouterTache(@RequestBody Taches taches, @PathVariable String idusers, @PathVariable Long idActivite, @PathVariable String libelleDesignation){
        taches.setActivite(activiteService.trouverActiviteParId(idActivite));
        taches.setDesignation(designationService.recupererDesignationParLibelle(libelleDesignation));
        System.out.println(taches.getDatedebut());
        Statut statut = new Statut();
        statut.setIdstatut(1L);
        taches.setStatut(statut);
        return tacheService.enregistrerTaches(taches, idusers);
    }

    @GetMapping("/RecupererTout")
    List<Taches> recupererLesTaches(){
        return tacheService.recupererTousLesTaches();
    }

}
