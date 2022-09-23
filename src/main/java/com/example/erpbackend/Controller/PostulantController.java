package com.example.erpbackend.Controller;

import com.example.erpbackend.Importation.ConfigExcel;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Service.ListePostulantService;
import com.example.erpbackend.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.annotations.Api;
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

    //Le controlleur permettant d'importer un fichier et créer automatiquement une liste des postulants
    @RequestMapping("/import/excel/{libelleliste}")//il prend en parametre le libelle de la liste des postulant
    public String importFormExcel(@Param("file") MultipartFile file, @PathVariable  String libelleliste) {

        /*
         * MultipartFile, classe java permettant d'importer un ou plusieurs fichiers
         */

        ConfigExcel importfichier = new ConfigExcel();

//stockage de la liste des postulants retournée par la classe "ConfigExcel"  dans postulantList

        List<Postulant> postelist = importfichier.excelImport(file);

        if(postelist.size()==0){//verifie si la liste est vide

            return "Fichier vide";
        }else {//si la liste n'est pas vide

            //itialisation de la classe postulant liste
            Liste_postulant liste_postulant = new Liste_postulant();

            //Recuperation du libelle de la liste
            liste_postulant.setLibelleliste(libelleliste);

            //on modifie la date de la liste en lui donnant la date actuelle
            liste_postulant.setDateliste(new Date());

            //verifie si la liste existe déjà ou pas
            if(listePostulantService.trouverListePostulantParLibelle(liste_postulant.getLibelleliste()) == null){
                //on crée la liste et garder cette listepostulant dans lpt
                Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                /*
                 * Dans la boucle for suivant on parcours la liste des postulants en lui ajoutant l'id de la liste
                 * sur la quelle la liste a été tiré
                 */

                for(Postulant pot:postelist){

                    //ajout de l'id de la liste à tous les  postulants
                    pot.setListePostulant(lpt);
                    //attribuer l'etat true par defeaut au postulant tirer
                    pot.setEtat(true);
                }
                System.out.println(postelist);
                //enregistrement de la liste des postulants importés dans la base
                postulantService.enregistrerPostulant(postelist);
                return "liste importer avec succes";
            }else {
                return "Cette liste existe déjà";
            }
        }
    }
}
