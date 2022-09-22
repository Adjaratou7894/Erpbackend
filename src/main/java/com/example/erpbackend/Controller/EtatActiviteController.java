package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Repository.EtatActiviteRepository;
import com.example.erpbackend.Service.EtatActiviteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etatactivite")
@AllArgsConstructor
public class EtatActiviteController {

    private final EtatActiviteService etatActiviteService;

    private final EtatActiviteRepository etatActiviteRepository;


    @PostMapping("/ajouter")
    public ReponseMessage ajouterEtatActivité(@RequestBody Etat_activite etat_activite){
        return etatActiviteService.ajouterEtatActivite(etat_activite);
    }

    @GetMapping("/afficher")
    public List<Etat_activite> afficherEtatActivité(){
        return etatActiviteService.afficherEtatActivite();
    }

    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage supprimerEtatActivite(@PathVariable Long id){

        return etatActiviteService.supprimerEtatActivite(id);
    }

    @PutMapping("/modifier")
    public ReponseMessage modifierEtatActivite(@RequestBody Etat_activite etat_activite){

        if (etatActiviteService.trouverEtatActiviteParId(etat_activite.getIdetat()) !=  null){

            etatActiviteService.modifierEtatActivite(etat_activite);
            ReponseMessage message = new ReponseMessage("Etat modifié avec suces", true);

            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Etat non trouvé", false);

            return message;
        }


    }
}
