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
@Api(value = "hello", description = "Gestion des Users")
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;


    // ============================== Récuperer tous les utilisateurs dans dans la base de données ===============
    @ApiOperation(value = "Afficher la liste des users")
    @GetMapping("/afficher")
    public List<Utilisateur> afficherUtilisateur(){

        return utilisateurService.afficherUtilisateur();
    }


    // ============================== Ajouter un utilisateur dans dans la base de données =======================
    @ApiOperation(value = "Ajouter un users")
    @PostMapping("/ajouter")

    public ReponseMessage ajouterUtilisateur(@RequestBody Utilisateur utilisateur){

        return utilisateurService.ajouterUtilisateur(utilisateur);
    };


    // ============================== Modifier un utilisateur dans dans la base de données =======================

    @ApiOperation(value = "Modifier un user")
   @PutMapping("/modifier")
    public ReponseMessage modifierUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.modifierUtilisateur(utilisateur);

    }


    // ============================== Supprimer un utilisateur par son id dans dans la base de données ===========
    @ApiOperation(value = "Supprimer un user")
    @DeleteMapping("/supprimer/{iduser}")
    public ReponseMessage supprimer(@PathVariable Long iduser){
            return utilisateurService.supprimerUtilisateur(iduser);

        }

    // ============================== Ce connecter avec son email et mot de passe ================================
    @ApiOperation(value = "Se connecter")
    @GetMapping("/seconnecter")
    public Object seConnecter(@RequestBody String email, String password){

        return utilisateurService.seConnecter(email, password);
    }
}
