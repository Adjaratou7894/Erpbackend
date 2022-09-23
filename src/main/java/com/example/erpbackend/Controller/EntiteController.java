package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.ServiceImplementation.EntiteServiceImplement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "hello", description = "Gestion des Entités")
@RequestMapping("/entite")
public class EntiteController {
    private final EntiteServiceImplement entiteServiceImplement;
    //**********On ajoute un entité avec un type de retour entite********
    @ApiOperation(value = "Créer un Entité")
    @PostMapping("/ajouter")
    public Entite ajouterEntite(Entite entite){
      return   entiteServiceImplement.ajouter(entite);
    }


    //**********On affiche un entité avec un type de retour liste********
    @ApiOperation(value = "Afficher la liste des Entités")
    @GetMapping("/afficher")
    public List<Entite> afficherListeEntite(){
       return entiteServiceImplement.afficher();
    }


    //**********On modifie une entité avec son id dans path variable et un type de retour String********
    @ApiOperation(value = "Modifier un entité")
    @PutMapping("/modifier")
    public Entite modifierEntite(@RequestBody Entite entite){
       return entiteServiceImplement.modifier(entite);

    }



    //**********On supprime une entité avec son id dans path variable et un type de retour String********
  /*  @DeleteMapping("/supprimer/{id}")
    public String supprimerEntite(@PathVariable Long id){
        return entiteServiceImplement.supprimer(id);
    }*/
}
