package com.example.erpbackend.Controller;
import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Service.ActeurService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "test", description = "")
@AllArgsConstructor
@RequestMapping("/acteur")
public class ActeurController {

    private final ActeurService acteurService;
    @PostMapping("/creeracteur")
    public Acteur creerActeur( @RequestBody Acteur acteur){
        return acteurService.creerActeur(acteur);
    }
    @PutMapping("/modifieracteur/{id}")
    public Acteur modifierActeur(  @PathVariable Long id,@RequestBody Acteur acteur){
        return acteurService.modifierActeur(id, acteur);
    }
    @GetMapping("/afficheracteur")
    public List<Acteur> afficheracteur(){
        return acteurService.afficherToutLesActeurs();
    }
    @DeleteMapping("/supprimer/{id}")
    public String delete (@PathVariable Long id){
        return acteurService.SupprimerActeur(id);
    }


}
