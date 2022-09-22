package com.example.erpbackend.Controller;

import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Service.StatutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Entité Statut")
@RestController
@RequestMapping("/statut")
@AllArgsConstructor
public class StatutController {

    @Autowired
    private final StatutService statutService;

    @ApiOperation(value = "Juste pour ajouter le statut ")
    @PostMapping("/ajouter")
    public Statut ajoute(@RequestBody Statut statut){
        return statutService.ajouter(statut);
    }
    @ApiOperation(value = "Juste pour afficher le statut ")
    @GetMapping("/afficher")
    public List<Statut> read(){
        return statutService.lister();
    }
    @ApiOperation(value = "Juste pour modifier le statut ")
    @PutMapping("/modifier")
    public Statut update(@RequestBody Statut statut){
        return statutService.modifier(statut);
    }
    @ApiOperation(value = "Juste pour supprimer le statut ")
    @DeleteMapping("/supprimer/{id}")
    public String delete(@PathVariable Long id){
        return statutService.supprimer(id);
    }
}
