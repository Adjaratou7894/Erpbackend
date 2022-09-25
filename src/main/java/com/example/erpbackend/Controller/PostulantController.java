package com.example.erpbackend.Controller;


import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Service.ActiviteService;
import io.swagger.annotations.Api;
import com.example.erpbackend.Importation.ConfigExcel;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Service.ListePostulantService;
import com.example.erpbackend.Service.PostulantService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant la Gestion des Postulants")
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {

    @Autowired
    private final ListePostulantService listePostulantService;
    private final PostulantService postulantService;
    final private ActiviteService activiteService;

    @ApiOperation(value = "ici on Importer un fichier")
    @RequestMapping("/import/excel/{libelleliste}/{libelleActivite}")
    public ReponseMessage importFormExcel(@Param("file") MultipartFile file, @PathVariable  String libelleliste, @PathVariable String libelleActivite) {

        ConfigExcel importfichier = new ConfigExcel();

        List<Postulant> postelist = importfichier.excelImport(file);

        if(postelist.size()==0){

            ReponseMessage message = new ReponseMessage("Fichier vide", false);

            return message;
        }else {
            Liste_postulant liste_postulant = new Liste_postulant();
            Activite activite = activiteService.trouverActiviteParLibelle(libelleActivite);

            if (activite == null){

                ReponseMessage message = new ReponseMessage("Cette activité n'existe pas", false);

                return message;
            }else {
                Liste_postulant listt = listePostulantService.trouverListePostulantParLibelle(libelleliste);

                if(listt == null){

                    liste_postulant.setActivite(activite);

                    liste_postulant.setNombretirage(0);

                    liste_postulant.setLibelleliste(libelleliste);

                    Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                    for(Postulant pot:postelist){

                        pot.setListePostulant(lpt);
                        pot.setEtat(true);
                    }
                    System.out.println(postelist);
                    postulantService.enregistrerPostulant(postelist);
                    ReponseMessage message = new ReponseMessage("liste importer avec succes", true);
                    return message;
                }else {
                    ReponseMessage message = new ReponseMessage("Cette liste existe déjà", false);
                    return message;
                }
            }
            }
    }

    @ApiOperation(value = "ici on Ajouter un postulant")
    @RequestMapping("/ajouter")
    public Object ajouterPostulant(@RequestBody Postulant postulant){

       return postulantService.ajouterPostulant(postulant);
    }

    @ApiOperation(value = "ici on Afficher les postulants")
    @GetMapping("/afficher")
    public List<Postulant> afficherliste(){
        return postulantService.afficherPostulant();
    }
}
