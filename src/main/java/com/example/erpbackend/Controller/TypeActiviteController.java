package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Type_activite;
import com.example.erpbackend.ServiceImplementation.TypeActiviteServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeactivite")
@Api(value = "hello", description = "controller permettent la Gestion des TypeActivité")
@CrossOrigin(origins = "http://localhost:8100")
public class TypeActiviteController {
    @Autowired
    public TypeActiviteServiceImplement typeActiviteServiceImplement;

    // ============================== ICI ON CREE LA LISTE DES TYPES DE L'ACTIVITE ==============================


    @ApiOperation(value = "Ici on ajoute les types d'activité")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterTypesActivites(@RequestBody Type_activite type_activite){
        return this.typeActiviteServiceImplement.ajouterTypeActivite(type_activite);
    }

    // =======================ICI ON AFFICHE LA LISTE DES TYPES DE L'ACTIVITE===============================


    @ApiOperation(value = "Ici on liste les types d'activité")
    @GetMapping("/afficher")
    public List<Type_activite> lesTypesActivites(){
        return this.typeActiviteServiceImplement.afficherTypeActivite();
    }


    // =======================ICI ON MODIFIE UN DES TYPES DE L'ACTIVITE===============================
    @ApiOperation(value = "Ici on modifie un types d'activité")
    @PutMapping("/modifier/{id}")
    public  ReponseMessage modifierTypeActivite(@PathVariable("id") Long id,@RequestBody Type_activite type_activite){
        return  typeActiviteServiceImplement.modifierTypeActivite(id,type_activite);
    }

    // =======================ICI ON SUPPRIME UN DES TYPES DE L'ACTIVITE===============================

    @ApiOperation(value = "Ici on supprime les types d'activité")
    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage supprimerTypeActivite(@PathVariable("id") Long id){

        return  typeActiviteServiceImplement.supprimerTypeActvite(id);
    }

}
