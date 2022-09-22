package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.Utilisateur;
import com.example.erpbackend.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;


    // ============================== Récuperer tous les utilisateurs dans dans la base de données ===============
    @GetMapping("/afficher")
    public List<Utilisateur> afficherUtilisateur(){
        return utilisateurService.afficherUtilisateur();
    }


    // ============================== Ajouter un utilisateur dans dans la base de données =======================
    @PostMapping("/ajouter")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouterUtilisateur(utilisateur);
    };


    // ============================== Modifier un utilisateur dans dans la base de données =======================
    @PutMapping("/modifier/{id}")
    public Utilisateur modifierUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable Long id){
        return utilisateurService.modifierUtilisateur(utilisateur, id);
    }


    // ============================== Supprimer un utilisateur par son id dans dans la base de données ===========
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return utilisateurService.supprimerUtilisateur(id);
    }


    // ============================== Ce connecter avec son email et mot de passe ================================
    @GetMapping("/seconnecter")
    public Object seConnecter(@RequestBody String email, String password){
        return utilisateurService.seConnecter(email, password);
    }
}
