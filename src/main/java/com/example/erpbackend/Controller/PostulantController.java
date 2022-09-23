package com.example.erpbackend.Controller;


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

    @RequestMapping("/import/excel/{libelleliste}")
    public String importFormExcel(@Param("file") MultipartFile file, @PathVariable  String libelleliste) {

        ConfigExcel importfichier = new ConfigExcel();

        List<Postulant> postelist = importfichier.excelImport(file);



        if(postelist.size()==0){

            return "Fichier vide";
        }else {
            Liste_postulant liste_postulant = new Liste_postulant();

            liste_postulant.setLibelleliste(libelleliste);
            liste_postulant.setDateliste(new Date());

            if(listePostulantService.trouverListePostulantParLibelle(liste_postulant.getLibelleliste()) == null){
                Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                for(Postulant pot:postelist){

                    pot.setListePostulant(lpt);
                    pot.setEtat(true);
                }
                System.out.println(postelist);
                postulantService.enregistrerPostulant(postelist);
                return "liste importer avec succes";
            }else {
                return "Cette liste existe déjà";
            }
        }
    }
}
