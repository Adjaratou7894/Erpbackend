package com.example.erpbackend.Controller;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.ServiceImplementation.EntiteServiceImplement;
import com.example.erpbackend.img.ConfigImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.poi.util.StringUtil;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "hello", description = "controller permettant la Gestion des Entités")
@RequestMapping("/entite")
public class EntiteController {
    private final EntiteServiceImplement entiteServiceImplement;
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
    public byte[] ajouterEntit(@Param("test") Entite entite, @Param("file") MultipartFile file) throws IOException {

        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());
         entite.setPhotoentite(nomfile);
        String uploaDir = "C:\\Users\\ADIAWIAKOYE\\Desktop\\Erpbackend\\src\\main\\resources\\files";
        ConfigImage.saveimg(uploaDir, nomfile, file);
          return entiteServiceImplement.getBytes(entite.getIdEntite());

      //  ReponseMessage message = new ReponseMessage("Entité ajouté avec succes", true);
        //return message;
    }
}
