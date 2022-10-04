package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.Repository.EntiteRepository;
import com.example.erpbackend.ServiceImplementation.EntiteServiceImplement;
import com.example.erpbackend.img.ConfigImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.poi.util.StringUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "hello", description = "controller permettant la Gestion des Entités")
@RequestMapping("/entite")
@CrossOrigin(origins = "http://localhost:8100")
public class EntiteController {
    private final EntiteServiceImplement entiteServiceImplement;

    private final EntiteRepository entiteRepository;
    //**********On ajoute un entité avec un type de retour entite********
    @ApiOperation(value = "ici on ajoute un Entité")
    @PostMapping("/ajouter")
    public ReponseMessage ajouterEntite(@RequestBody Entite entite){

        return   entiteServiceImplement.ajouter(entite);
    }


    //**********On affiche un entité avec un type de retour liste********
    @ApiOperation(value = "ici on Afficher la liste des Entités")
    @GetMapping("/afficher")
    public List<Entite> afficherListeEntite(){

        return entiteServiceImplement.afficher();
    }


    //**********On modifie une entité avec son id dans path variable et un type de retour String********
    @ApiOperation(value = "ici on Modifier un entité")
    @PutMapping("/modifier")
    public ReponseMessage modifierEntite(@RequestBody Entite entite){
       return entiteServiceImplement.modifier(entite);

    }



    //**********On supprime une entité avec son id dans path variable et un type de retour String********
    @ApiOperation(value = "ici on Supprimer un entité")
    @DeleteMapping("/supprimer/{id}")
    public ReponseMessage supprimerEntite(@PathVariable Long id){

        return entiteServiceImplement.supprimer(id);
    }

    @PostMapping("/ajouterE")
    public ReponseMessage ajouterEntit(@Param("nom") String nom, @Param("slogant") String slogant, @Param("description") String description, @Param("file") MultipartFile file) throws IOException {
        Entite entite = new Entite();
        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(nom);
         entite.setNom(nom);
         System.out.println(description);
         entite.setDescription(description);
         System.out.println(slogant);
         entite.setSlogant(slogant);
        System.out.println(nomfile);
         entite.setPhotoentite(nomfile);
        System.out.println(entite.getIdEntite());
        System.out.println(entite.getNom());
        if(entiteRepository.findByNom(nom) == null) {
            String uploaDir = "src/main/resources/files/";
            //String uploaDir = new ClassPathResource("files/").getFile().getAbsolutePath();
            ConfigImage.saveimg(uploaDir, nomfile, file);
            //  entiteServiceImplement.ajouter(entite);
            return entiteServiceImplement.ajouter(entite);
        }else {
            return null;
        }

    }

}
