package com.example.erpbackend.Controller;

import com.example.erpbackend.Importation.ConfigExcel;
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Service.*;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(value = "hello", description = "Importer et tirer en même temps")
@RequestMapping("/import")
@AllArgsConstructor
public class ImportTriePostulant {
    @Autowired
    private final ListePostulantService listePostulantService;
    private final PostulantService postulantService;
    final private ActiviteService activiteService;
    final private TirageService tirageService;


    @PostMapping("/import/excel/{libelle}/{libelleT}/{nbre}/{libelleAct}")//il prend en parametre le libelle de la liste
    public ReponseMessage importFormExcelT(@Param("file") MultipartFile file, Liste_postulant liste, @PathVariable String libelle, @PathVariable("libelleT") String libelleT, @PathVariable("nbre") int nbre, @PathVariable("libelleAct") String libelleAct) {

        ConfigExcel importfichier = new ConfigExcel();

        List<Postulant> postelist = importfichier.excelImport(file);

        Tirage tirage = new Tirage();
        Activite act = activiteService.trouverActiviteParLibelle(libelleAct);

        tirage.setLibelleTirage(libelleT);
        tirage.setNombrePostulantTire(nbre);


        if(postelist.size()==0){

            ReponseMessage message = new ReponseMessage("Fichier vide", false);

            return message;
        }else {
            Liste_postulant liste_postulant = new Liste_postulant();
            Activite activite = activiteService.trouverActiviteParLibelle(libelle);

            if (activite == null){

                ReponseMessage message = new ReponseMessage("Cette activité n'existe pas", false);

                return message;
            }else {
                Liste_postulant listt = listePostulantService.trouverListePostulantParLibelle(libelle);

                if(listt == null){

                    liste_postulant.setActivite(activite);

                    liste_postulant.setNombretirage(0);

                    liste_postulant.setLibelleliste(libelle);

                    Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                    tirageService.creer(tirage, lpt, act);

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
}
