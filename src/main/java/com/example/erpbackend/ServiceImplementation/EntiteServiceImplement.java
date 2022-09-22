package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Entite;
import com.example.erpbackend.Repository.EntiteRepository;
import com.example.erpbackend.Service.EntiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntiteServiceImplement implements EntiteService {


    @Autowired
    private final EntiteRepository entiteRepository;
    //**********On ajout une entité avec son id et un type de retour Entite********
    @Override
    public Entite ajouter(Entite entite) {
        return entiteRepository.save(entite);
    }
    //**********On affiche une entité avec son id et un type de retour liste********

    @Override
    public List<Entite> afficher() {

        return entiteRepository.findAll();
    }
    //**********On modifie une entité avec son id et un type de retour Entite********
    @Override
    public Entite modifier(Entite entite) {
        return entiteRepository.findById(entite.getIdEntite())
                .map(entite1 -> {
                    entite1.setNom(entite.getNom());
                    return entiteRepository.save(entite1);
                }).orElseThrow(() -> new RuntimeException("Entité  non trouvé"));

    }
    //**********On supprime une entité avec son id********
    @Override
    public ReponseMessage supprimer(Long id) {
        if(entiteRepository.findById(id).get() != null) {
            ReponseMessage reponseMessage;
            entiteRepository.deleteById(id);
          reponseMessage = new  ReponseMessage("supprimé avec succés",true);
        return  reponseMessage;}
        else {
            ReponseMessage reponseMessage = new ReponseMessage("Suppression impossible", false);
            return  reponseMessage;}
    }

    }






