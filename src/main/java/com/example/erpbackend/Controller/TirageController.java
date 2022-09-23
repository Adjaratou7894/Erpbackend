package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Service.ActiviteService;
import com.example.erpbackend.Service.ListePostulantService;
import com.example.erpbackend.Service.PostulantService;
import com.example.erpbackend.Service.TirageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "hello", description = "Gestion des tirages")
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/tirage")
public class TirageController {

    @Autowired
    private TirageService tirageService;

    @Autowired
    private PostulantService postulantService;

    @Autowired
    private ListePostulantService listePostulantService;

    @Autowired
    private ActiviteService activiteService;

    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER TIRAGE PAR IDLIST=========================

    @PostMapping("/createTirage/{libelle_liste}/{libelle_activite}")
    public ReponseMessage create(@RequestBody Tirage tirage, @PathVariable String libelle_liste, @PathVariable String libelle_activite){

        Tirage tirageConserne = tirageService.trouverTirageParLibelle(tirage.getLibelleTirage());

        if (tirageConserne == null){
            Activite activiteConserne = activiteService.trouverActiviteParLibelle(libelle_activite);

            Liste_postulant listeConserne = listePostulantService.trouverListePostulantParLibelle(libelle_liste);

            return tirageService.creer(tirage, listeConserne, activiteConserne);
        }else {
            ReponseMessage message = new ReponseMessage("Ce tirage existe dejà", false);

            return message;
        }

    }



        @ApiOperation(value = "Afficher la listes des tirages par idlist")
        @GetMapping("/recupererTirageParIdliste/{Idlistepostulant}")
        public Iterable<Object[]> getTirageParIdListe(@PathVariable Long Idlistepostulant){
            return tirageService.AfficherTousLesTirages(Idlistepostulant);
        }
    //================FIN DE LA METHODE PERMETTANT DE RECUPERER TIRAGE PAR IDTIRAGE=========================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES TIRAGES=========================
    @ApiOperation(value = "Afficher la liste des tirages")
    @GetMapping("/afficher")
    public List<Tirage> read(){
        return tirageService.lire();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LES TIRAGES=========================

    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LE NOMBRE TOTAL DU TIRAGE=========================
    @ApiOperation(value = "Afficher le nombre total du tirage")
    @GetMapping("/AfficherTirageTotal")
    public Long getNombreTotalTirage(){

        return tirageService.nombreTotaltirage();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LE NOMBRE TOTAL DU TIRAGE=========================

    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER TIRAGE PAR IDTIRAGE=========================
    @ApiOperation(value = "Recuperer Tirage par idTirage")
    @GetMapping("/recupererTirageParId/{idtirage}")
    public Tirage recupererTiragesparIdTirage(@PathVariable Long idtirage){

        return tirageService.recupererTirageIdTirage(idtirage);
    }
    //================FIN DE LA METHODE PERMETTANT DE RECUPERER TIRAGE PAR IDTIRAGE=========================

}
