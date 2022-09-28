package com.example.erpbackend.Controller;


import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Designation;
import com.example.erpbackend.Model.Taches;
import com.example.erpbackend.Service.DesignationService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant d'ajouter une designation")
@AllArgsConstructor
@RequestMapping("/designation")
@CrossOrigin(origins = "http://localhost:8100")
public class DesignationController {

    final private DesignationService designationService;

    @PostMapping("/ajouter")
    ReponseMessage ajouterTache(@RequestBody Designation designation){

        return designationService.enregistrerDesignation(designation);
    }

    @GetMapping("/recupererToutDesignination")
    List<Designation> recuperationDesignation(){
        return designationService.recupererTousLesDesignation();
    }

    @GetMapping("/recupererParLibelle/{libelle}")
    Designation recupererUneDesignation(@PathVariable String libelle){
        return designationService.recupererDesignationParLibelle(libelle);
    }

}
