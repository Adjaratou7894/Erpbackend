package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Model.Acteur;
import com.example.erpbackend.Repository.ActeurRepository;
import com.example.erpbackend.Service.ActeurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActeurServiceImplement implements ActeurService {
    @Autowired
    ActeurRepository acteurRepository;
    @Override
    public Acteur creerActeur(Acteur acteur) {
        return acteurRepository.save(acteur)  ;
    }

    @Override
    public Acteur modifierActeur(  Long id,Acteur acteur ) {
        return acteurRepository.findById(id)
                .map(acteur1->{
                    acteur1.setNom(acteur.getNom());
                    acteur1.setPrenom(acteur.getPrenom());
                    acteur1.setNumero(acteur.getNumero());
                    return acteurRepository.save(acteur1);
                }).orElseThrow(() -> new RuntimeException("Désole, Acteur non trouvée"));
    }

    @Override
    public List<Acteur> afficherToutLesActeurs() {
        return acteurRepository.findAll();
    }

    @Override
    public String SupprimerActeur( Long id) {
        return ("Acteur supprime avec supprimée");
    }

}
