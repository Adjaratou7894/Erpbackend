package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.StatutTache;
import com.example.erpbackend.Service.StatutTacheService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant d'ajouter le statut d'une tache")
@AllArgsConstructor
@RequestMapping("/statutTache")
@CrossOrigin(origins = "http://localhost:8100")
public class StatutTacheController {

    final private StatutTacheService statutTacheService;

    @PostMapping("/ajouter")
    ReponseMessage ajouterStatutTache(@RequestBody StatutTache statutTache){
        return statutTacheService.enregistreStatutTache(statutTache);
    }

    @GetMapping("/recupererLesStatutTaches")
    List<StatutTache> recupererStatutTache(){
        return statutTacheService.recupererTousLesStatutTaches();
    }

    @GetMapping("RecupererStatutTacheParLibelle/{libelle}")
    StatutTache recupererStatutParLibelle(@PathVariable String libelle){
        return statutTacheService.recupererStatutTacheParLibelle(libelle);
    }
}
