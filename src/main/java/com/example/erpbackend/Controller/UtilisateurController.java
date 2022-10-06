package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Utilisateur;
import com.example.erpbackend.Service.UtilisateurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "Controller permettant la Gestion des Users")
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:8100")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // ============================== Récuperer tous les utilisateurs dans dans la base de données ===============
    @ApiOperation(value = "ici on Afficher la liste des users")
    @GetMapping("/afficher")
    public List<Utilisateur> afficherUtilisateur(){

        return utilisateurService.afficherUtilisateur();
    }
    // ============================== Récuperer le nombre de tous les utilisateurs dans dans la base de données ===============
    @ApiOperation(value = "ici on Afficher le nombre des users")
    @GetMapping("/afficherNbreUser")
    public int afficherNobreUtilisateur(){

        return utilisateurService.afficherUtilisateur().size();
    }

    // ============================== Ajouter un utilisateur dans dans la base de données =======================
    @ApiOperation(value = "ici on fait l'Ajouter un users")
    @PostMapping("/ajouter")

    public ReponseMessage ajouterUtilisateur(@RequestBody Utilisateur utilisateur){

        return utilisateurService.ajouterUtilisateur(utilisateur);
    };


    // ============================== Modifier un utilisateur dans dans la base de données =======================

    @ApiOperation(value = "ici on Modifier un user")
    @PutMapping("/modifier")
    public ReponseMessage modifierUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.modifierUtilisateur(utilisateur);

    }


    // ============================== Supprimer un utilisateur par son id dans dans la base de données ===========
    @ApiOperation(value = "ici on Supprimer un user")
    @DeleteMapping("/supprimer/{iduser}")
    public ReponseMessage supprimer(@PathVariable Long iduser){
            return utilisateurService.supprimerUtilisateur(iduser);
    }

    // ============================== Ce connecter avec son email et mot de passe ================================
    @ApiOperation(value = "Methode permettant de Se connecter")

    @GetMapping("/seconnecter/{email}/{pass}")
    public Object seConnecter(@PathVariable String email, @PathVariable String pass){


        return utilisateurService.seConnecter(email, pass);
    }
    @ApiOperation(value = "Methode permettant de filtrer par entité")
    @GetMapping("/afficher/{entite}")
    List<Object> afficherParEntite(@PathVariable String entite){
        return utilisateurService.afficherUtilisateurParEntite(entite);
    }

    @ApiOperation(value = "Methode permettant d'afficher par entité et rôle")
    @GetMapping("/afficherToute")
    List<Object> afficherParEntiteToute(){
        return utilisateurService.findUtilisateurParEntiteToute();
    }
}
