package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Service.StatutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "controller permettent la gestion Entité Statut")
@RestController
@RequestMapping("/statut")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class StatutController {

    @Autowired
    private final StatutService statutService;

    @ApiOperation(value = "ici on ajouter le statut ")
    @PostMapping("/ajouter")
    public ReponseMessage ajoute(@RequestBody Statut statut){

        return statutService.ajouter(statut);
    }
    @ApiOperation(value = "ici on  afficher le statut ")
    @GetMapping("/afficher")
    public List<Statut> read(){

        return statutService.lister();
    }
    @ApiOperation(value = "ici on modifier le statut ")
    @PutMapping("/modifier")
    public ReponseMessage update(@RequestBody Statut statut){

        if(statutService.trouverStatuParIdstatut(statut.getIdstatut()) != null ){
            statutService.modifier(statut);
            ReponseMessage message = new ReponseMessage("Statut modifié avec suces", true);

            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Statut non trouvé", false);

            return message;
        }
    }
    @ApiOperation(value = "ici on supprimer le statut ")
    @DeleteMapping("/supprimer/{idstatut}")

    public ReponseMessage delete(@PathVariable Long idstatut){

        return statutService.supprimer(idstatut);
    }
    @ApiOperation(value = "ici on trouve l'id du statut par son nom ")
    @GetMapping("/id/{nom}")
    public int trouverparid( @PathVariable String nom){
        return statutService.trouverid(nom);
    }
}
