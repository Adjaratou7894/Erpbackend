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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@Api(value = "hello", description = "Gestion des Postulants")
@RequestMapping("/postulant")
@AllArgsConstructor
public class PostulantController {

    @Autowired
    private final ListePostulantService listePostulantService;
    private final PostulantService postulantService;
    final private ActiviteService activiteService;


    //Le controlleur permettant d'importer un fichier et créer automatiquement une liste des postulants

    @RequestMapping("/import/excel/{libelleliste}/{libelleActivite}")
    public ReponseMessage importFormExcel(@Param("file") MultipartFile file, @PathVariable  String libelleliste, @PathVariable String libelleActivite) {


        /*
         * MultipartFile, classe java permettant d'importer un ou plusieurs fichiers
         */

        ConfigExcel importfichier = new ConfigExcel();

//stockage de la liste des postulants retournée par la classe "ConfigExcel"  dans postulantList

        List<Postulant> postelist = importfichier.excelImport(file);

                if (postelist.size() == 0) {

                    ReponseMessage message = new ReponseMessage("Fichier vide", false);

                    return message;
                } else {
                    Liste_postulant liste_postulant = new Liste_postulant();

                    if (activiteService.trouverActiviteParLibelle(libelleActivite) == null) {

                        ReponseMessage message = new ReponseMessage("Cette activité n'existe pas", false);

                        return message;
                    } else {
                        Activite activite = new Activite();

                        liste_postulant.setLibelleliste(libelleliste);
                        liste_postulant.setDateliste(new Date());

                        if (listePostulantService.trouverListePostulantParLibelle(liste_postulant.getLibelleliste()) == null) {
                            Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                            for (Postulant pot : postelist) {

                                pot.setListePostulant(lpt);
                                pot.setEtat(true);
                            }
                            System.out.println(postelist);
                            postulantService.enregistrerPostulant(postelist);
                            ReponseMessage message = new ReponseMessage("liste importer avec succes", true);
                            return message;
                        } else {
                            ReponseMessage message = new ReponseMessage("Cette liste existe déjà", false);
                            return message;
                        }
                    }

                }
            }
        }
