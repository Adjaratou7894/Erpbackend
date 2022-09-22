package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Repository.EtatActiviteRepository;
import com.example.erpbackend.Service.EtatActiviteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtatActiviteServiceImplement implements EtatActiviteService {

    //definition des repository
    private final EtatActiviteRepository etatActiviteRepository;


    @Override
    public ReponseMessage ajouterEtatActivite(Etat_activite etat_activite) {

        if (etatActiviteRepository.findByEtat(etat_activite.getEtat()) == null){
            etatActiviteRepository.save(etat_activite);
            ReponseMessage message = new ReponseMessage("Etat ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet état existe déjà ", false);

            return message;
        }

    }

    @Override
    public Etat_activite modifierEtatActivite(Etat_activite etat_activite) {
        return etatActiviteRepository.findById(etat_activite.getIdetat()).map(ea -> {
                        ea.setEtat(etat_activite.getEtat());
                    return etatActiviteRepository.save(ea);
                }).orElseThrow(() -> new RuntimeException("erreur"));
    }

    @Override
    public ReponseMessage supprimerEtatActivite(Long id) {

        if(etatActiviteRepository.findByIdetat(id) != null){
            ReponseMessage message = new ReponseMessage("Etat supprimé avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Etat non trouvée", false);
            return message;
        }
    }

    @Override
    public List<Etat_activite> afficherEtatActivite() {
        return etatActiviteRepository.findAll();
    }

    @Override
    public Etat_activite trouverEtatActiviteParLibelle(String etat) {
        return etatActiviteRepository.findByEtat(etat);
    }

    @Override
    public Etat_activite trouverEtatActiviteParId(Long idetat) {
        return etatActiviteRepository.findByIdetat(idetat);
    }
}
