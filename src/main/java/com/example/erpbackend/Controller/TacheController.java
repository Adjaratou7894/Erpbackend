package com.example.erpbackend.Controller;


import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Taches;
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

    @PostMapping("/ajouter/{idusers}")
    ReponseMessage ajouterTache(@RequestBody Taches taches, @PathVariable String idusers){

        return tacheService.enregistrerTaches(taches, idusers);
    }

    @GetMapping("/RecupererTout")
    List<Taches> recupererLesTaches(){
        return tacheService.recupererTousLesTaches();
    }

}
