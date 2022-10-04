package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Service.ActiviteService;
import com.example.erpbackend.Service.PostulantTireService;
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

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant la Gestion des Postulants")
@RequestMapping("/postulant")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class PostulantController {

    @Autowired
    private final ListePostulantService listePostulantService;
    private final PostulantService postulantService;
    final private ActiviteService activiteService;
    final private PostulantTireService postulantTireService;


    //Le controlleur permettant d'importer un fichier et créer automatiquement une liste des postulants

    @ApiOperation(value = "ici on Importer un fichier")
    @PostMapping("/import/excel/{libelleliste}/{libelleActivite}")
    public ReponseMessage importFormExcel(@Param("file") MultipartFile file, @PathVariable String libelleliste, @PathVariable String libelleActivite) {


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
            Activite activite = activiteService.trouverActiviteParLibelle(libelleActivite);

            if (activite == null) {


                ReponseMessage message = new ReponseMessage("Cette activité n'existe pas", false);

                return message;
            }else {

            Liste_postulant listt = listePostulantService.trouverListePostulantParLibelle(libelleliste);

            if (listt == null) {

                liste_postulant.setActivite(activite);

                liste_postulant.setNombretirage(0);

                liste_postulant.setLibelleliste(libelleliste);

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

    @ApiOperation(value = "ici on Ajouter un postulant")
    @PostMapping("/ajouter/{libelleListe}")
    public Postulant ajouterPostulant(@RequestBody Postulant postulant, @PathVariable String libelleListe){

        //Liste_postulant listePostulant = postulantService.tr

       return postulantService.ajouterPostulant(postulant, libelleListe);
    }

    //debut de l'import



    @ApiOperation(value = "ici on Importer un fichier")
    @PostMapping("/posulantTires/excel/{libelleliste}/{libelleActivite}")
    public ReponseMessage importFileExcel(@Param("file") MultipartFile file, @PathVariable String libelleliste, @PathVariable String libelleActivite) {


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
            Activite activite = activiteService.trouverActiviteParLibelle(libelleActivite);

            if (activite == null) {


                ReponseMessage message = new ReponseMessage("Cette activité n'existe pas", false);

                return message;
            }else {

                Liste_postulant listt = listePostulantService.trouverListePostulantParLibelle(libelleliste);

                if (listt == null) {

                    liste_postulant.setActivite(activite);

                    liste_postulant.setNombretirage(0);

                    liste_postulant.setLibelleliste(libelleliste);

                    Liste_postulant lpt = listePostulantService.creerlistepostulant(liste_postulant);

                    for (Postulant pot : postelist) {

                        pot.setListePostulant(lpt);
                        pot.setEtat(true);
                    }
                    System.out.println(postelist);
                    List<Postulant> postulantEnregistrer = postulantService.enregistrerPostulant(postelist);

                    postulantTireService.ajouterTousLesPostulantTire(postulantEnregistrer);

                    ReponseMessage message = new ReponseMessage("liste importer avec succes", true);
                    return message;
                } else {
                    ReponseMessage message = new ReponseMessage("Cette liste existe déjà", false);
                    return message;
                }
            }

        }

    }




//fin de l'import
    @ApiOperation(value = "ici on Afficher les postulants")
    @GetMapping("/afficher")
    public List<Postulant> afficherliste(){
        return postulantService.afficherPostulant();
    }

    //filtre des postulants ou participants

    @ApiOperation(value = "ici on Affiche Le nombre de postulant ou de participant")
    @GetMapping("/afficherNombreParticipantOuApprenant/{typePostulant}")
    public int afficherNombreParticipantOuApprenant(@PathVariable String typePostulant){

        return postulantService.trouverAllApprenantOuParticipant(typePostulant).size();
    }

    //afficher le postulants par  genre
    @ApiOperation(value = "ici on Afficher Le nombre de postulant par genre")
    @GetMapping("/afficherParticipantParGenre/{genre}")
    public List <Postulant> trouverPostulantParGenre(@PathVariable String genre){
        return postulantService.trouverPostulantParGenre(genre);
    }

    //filtre des postulants par activite et genre
    @GetMapping("/filtreParGenreETActivite/{genre}/{nom}")
    public List<Object> filtreParGenreETActivite(@PathVariable String genre, @PathVariable String nom){
        return postulantService.filtreParGenreETActivite(genre, nom);
    }

    //filtre des postulants par activite
    @GetMapping("/filtreParActivite/{activite}")
    public List<Object> filtreParActivite( @PathVariable String activite){
        return postulantService.filtreParActivite(activite);
    }

}
