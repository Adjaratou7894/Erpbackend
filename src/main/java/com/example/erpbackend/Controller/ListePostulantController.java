package com.example.erpbackend.Controller;

import com.example.erpbackend.Importation.ConfigExcel;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Service.ListePostulantService;
import com.example.erpbackend.Service.PostulantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Api(value = "hello", description = "Entité Liste Postulant")
@RestController
@RequestMapping("/listepostulant")
@AllArgsConstructor
public class ListePostulantController {

    @Autowired
    private final ListePostulantService listePostulantService;

    @ApiOperation(value = "Juste pour ajouter la Liste Postulant ")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterListePostulant(@RequestBody Liste_postulant listePostulant) {

        return listePostulantService.ajouterListePostulant(listePostulant);
    }

    @ApiOperation(value = "Juste pour afficher la Liste Postulant ")
    @GetMapping("/afficher")
    public List<Liste_postulant> afficherListePostulant() {

        return listePostulantService.afficherListePostulant();
    }

    @ApiOperation(value = "Juste pour modifier la Liste Postulant ")
    @PutMapping("/modifier")
    public ReponseMessage updateListePostulant(@RequestBody Liste_postulant listePostulant) {
        if (listePostulantService.trouverStatuParIdListePostulant(listePostulant.getIdliste()) != null) {
            listePostulantService.modifierListePostulant(listePostulant);
            ReponseMessage message = new ReponseMessage("Liste Postulant modifié avec suces", true);

            return message;
        } else {
            ReponseMessage message = new ReponseMessage("Liste Postulant non trouvé", false);

            return message;
        }
    }

    @ApiOperation(value = "Juste pour supprimer le Liste Postulant ")
    @DeleteMapping("/supprimer/{idlistepostulant}")
    public ReponseMessage deleteListePostulant(@PathVariable Long idlistepostulant){

        return listePostulantService.supprimerListePostulant(idlistepostulant);
    }
}
