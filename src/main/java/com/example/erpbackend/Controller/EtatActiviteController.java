package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Repository.EtatActiviteRepository;
import com.example.erpbackend.Service.EtatActiviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller Gestion de l'etat des activités")
@RequestMapping("/etatactivite")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class EtatActiviteController {

    @Autowired

    private final EtatActiviteService etatActiviteService;

    private final EtatActiviteRepository etatActiviteRepository;

    @ApiOperation(value = "ici on ajoute la liste de l'état d'Activitée")

    @PostMapping("/ajouter")
    public ReponseMessage ajouterEtatActivité(@RequestBody Etat_activite etat_activite){
        return etatActiviteService.ajouterEtatActivite(etat_activite);
    }

    @ApiOperation(value = "ici on Afficher la liste de l'état d'Activitée")

    @GetMapping("/afficher")
    public List<Etat_activite> afficherEtatActivité(){
        return etatActiviteService.afficherEtatActivite();
    }

    @ApiOperation(value = "ici on Supprimer l'état une Activitée")

    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage supprimerEtatActivite(@PathVariable Long id){

        return etatActiviteService.supprimerEtatActivite(id);
    }
    @ApiOperation(value = "ici on Modifier l'état d'Activitée")

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
