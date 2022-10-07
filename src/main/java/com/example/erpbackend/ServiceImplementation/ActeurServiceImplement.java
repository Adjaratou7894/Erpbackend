package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
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
    public ReponseMessage creerActeur(Acteur acteur) {
        if (acteurRepository.findByNumero(acteur.getNumero()) == null){
            acteurRepository.save(acteur);
            ReponseMessage message = new ReponseMessage("Acteur ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet acteur existe déjà ", false);

            return message;
        }
    }

    @Override
    public Acteur modifierActeur(Acteur acteur, Long idacteur) {
        Acteur acteurUpdate = acteurRepository.findById(idacteur).get();
        acteurUpdate.setNom(acteur.getNom());
        acteurUpdate.setPrenom(acteur.getPrenom());
        acteurUpdate.setEmail(acteur.getEmail());
        acteurUpdate.setNumero(acteur.getNumero());
        return acteurRepository.saveAndFlush(acteurUpdate);


    }


  /*  @Override
    public ReponseMessage modifierActeur(Acteur acteur) {
        if (acteurRepository.findByIdacteur(acteur.getIdacteur()) !=null) {
            return acteurRepository.findById(acteur.getIdacteur())
                    .map(acteur1->{
                        acteur1.setNom(acteur.getNom());
                        acteur1.setPrenom(acteur.getPrenom());
                        acteur1.setNumero(acteur.getNumero());
                        acteurRepository.save(acteur1);
                        ReponseMessage message = new ReponseMessage("Acteur modifié avec succes", true);
                        return  message;
                    }).orElseThrow(() -> new RuntimeException("Désole, Acteur non trouvée"));
        }else {
            ReponseMessage message = new ReponseMessage("Désole, Acteur non trouvée", false);

            return message;
        }

    }*/

    @Override
    public List<Acteur> afficherToutLesActeurs() {
        return acteurRepository.findAll();
    }

    @Override
    public ReponseMessage SupprimerActeur( Long idacteur) {
        if(acteurRepository.findByIdacteur(idacteur) != null){
            acteurRepository.deleteById(idacteur);
            ReponseMessage message = new ReponseMessage("Acteur supprimé avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Acteur non trouvé", false);
            return message;
        }

    }

    @Override
    public List<Object> AfficherActeurRoleTout() {
        return acteurRepository.AfficherActeurRoleTout();
    }

}
