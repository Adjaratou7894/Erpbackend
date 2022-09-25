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
    public ReponseMessage ajouter(Entite entite) {
        if(entiteRepository.findByNom(entite.getNom())==null){
            entiteRepository.save(entite);
            ReponseMessage message = new ReponseMessage("Entité ajoutée avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cette entité existe déjà ", false);

            return message;
        }
    }
    //**********On affiche une entité avec son id et un type de retour liste********

    @Override
    public List<Entite> afficher() {

        return entiteRepository.findAll();
    }
    //**********On modifie une entité avec son id et un type de retour Entite********
    @Override
    public ReponseMessage modifier(Entite entite) {
        if (entiteRepository.findByIdEntite(entite.getIdEntite()) !=null) {
            return entiteRepository.findById(entite.getIdEntite())
                .map(entite1 -> {
                    entite1.setNom(entite.getNom());
                    entiteRepository.save(entite1);
                    ReponseMessage message = new ReponseMessage("Entité modifiée avec succes", true);
                    return  message;
                }).orElseThrow(() -> new RuntimeException("Entité  non trouvée"));
        }else {
            ReponseMessage message = new ReponseMessage("Entité non trouvée ", false);

            return message;
        }
    }
    //**********On supprime une entité avec son id********
    @Override
    public ReponseMessage supprimer(Long id) {
        if (entiteRepository.findByIdEntite(id) != null) {
            entiteRepository.deleteById(id);
            ReponseMessage message = new ReponseMessage("Entité supprimée avec succes", true);
            return message;
        } else {
            ReponseMessage message = new ReponseMessage("Entité non trouvée", false);
            return message;
        }
    }

    }






