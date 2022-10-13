package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.*;
import com.example.erpbackend.Service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "controller permettant de Gestion les postulants tirés ")
@RequestMapping("/postulanttire")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8100")
public class PostulantTireController {

    @Autowired
    private final PostulantTireService postulantTireService;

    private final TirageService tirageService;

    private final PostulantService postulantService;

    private final ListePostulantService listePostulantService;

    private final ActiviteService activiteService;

    @ApiOperation(value = "ici on ajouter un postulant tiré ")
    @PostMapping("/ajouter/{listeLibelle}/{tirageLibelle}")
    public ReponseMessage ajouterPostulantTire(@RequestBody Postulant postulant, @PathVariable String tirageLibelle, @PathVariable String listeLibelle){

        Liste_postulant liste = listePostulantService.trouverListePostulantParLibelle(listeLibelle);

        Tirage tirage = tirageService.trouverTirageParLibelle(tirageLibelle);

        postulant.setListePostulant(liste);

        return postulantTireService.ajouterPostulantTrie(postulant, tirage, listeLibelle);
    }


    @ApiOperation(value = "ici on afficher tout les postulant tiré ")
    @GetMapping("/afficher")
    public List<Postulant> readPostulantTire(){

        return postulantTireService.recupererTousLesPostulantTire();
    }
    @ApiOperation(value = "ici on ajouter un participant ")
    @PostMapping("/ajouter/{libelleactivite}")
    public ReponseMessage ajouterParticipant(@RequestBody Postulant postulant,@PathVariable String libelleactivite) {
        Activite activite = activiteService.trouverActiviteParLibelle(libelleactivite);

        Liste_postulant liste = activite.getListe();

        postulant.setListePostulant(liste);

        return postulantTireService.ajouterParticipant(postulant, liste.getLibelleliste());

    }

    @GetMapping("/afficher/{genre}")
    public List<Postulant> afficherPostulantFiltre(@PathVariable String genre){
        //Postulant pgenre = postulantService.trouverPostulantParGenre(genre);

            return postulantTireService.recupererTousLesPostulantTireFilter(genre);

    }

    @ApiOperation(value = "ici on supprimer un postulant tiré ")
    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage deletePostulantTire(@PathVariable Long id){

        return postulantTireService.supprimerPostulantTrie(id);
    }

    @ApiOperation(value = "ici affiche les postulants tirés par id du tirage ")
    @GetMapping("/PostulantTireParTirage/{idTirage}")
    public List<Postulant> recupererLesPostulantTireParTirage(@PathVariable Long idTirage){

        return postulantTireService.recupererIdPostulantTireParTirage(idTirage);
    }

    @ApiOperation(value = "ici affiche le nombre de  participants ")
    @GetMapping("/compteParticipant")
    public int compteNombreParticipant(){

        return postulantTireService.nombreParticipant();
    }

    @ApiOperation(value = "ici affiche le nombre de  apprenant ")
    @GetMapping("/compteApprenant")
    public int compteNombreApprenant(){

        return postulantTireService.nombreApprenant();
    }

    @GetMapping("/parGenre/{postulant}")
    List<Object> parGenre(@PathVariable String postulant){
        return  postulantTireService.parGenre(postulant);
    }

    @GetMapping("/afficheGenre")
    List<Object> afficheGenre(){

        return postulantTireService.afficheGenre();
    }

}
