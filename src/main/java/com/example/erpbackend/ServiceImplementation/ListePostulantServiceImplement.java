package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Repository.ListePostulantRepository;
import com.example.erpbackend.Service.ListePostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ListePostulantServiceImplement implements ListePostulantService {

    @Autowired
    private final ListePostulantRepository listePostulantRepository;

    @Override
    public ReponseMessage ajouterListePostulant(Liste_postulant liste_postulant) {
        if(listePostulantRepository.findByLibelleliste(liste_postulant.getLibelleliste()) == null){
            liste_postulant.setNombretirage(0);
            liste_postulant.setDateliste(new Date());
            listePostulantRepository.save(liste_postulant);

            ReponseMessage message = new ReponseMessage("Liste postulant ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cette Liste postulant existe déjà ", false);

            return message;
        }
    }

    @Override
    public List<Liste_postulant> afficherListePostulant() {

        return listePostulantRepository.findAll();
    }

    @Override
    public Liste_postulant modifierListePostulant(Liste_postulant liste_postulant) {
        return listePostulantRepository.findById(liste_postulant.getIdliste())
                .map(lp -> {
                    if(liste_postulant.getLibelleliste() != null)
                    lp.setLibelleliste(liste_postulant.getLibelleliste());
                    if (liste_postulant.getNombretirage() != null)
                    lp.setNombretirage(liste_postulant.getNombretirage());
                    if (liste_postulant.getActivite() != null)
                    lp.setActivite(liste_postulant.getActivite());

                    return listePostulantRepository.save(lp);
                }).orElseThrow(() -> new RuntimeException("Liste postulant nom trouver") );
    }

    @Override
    public ReponseMessage supprimerListePostulant(Long idlistepostulant) {
        if(listePostulantRepository.findByIdliste(idlistepostulant) != null){
            listePostulantRepository.deleteById(idlistepostulant);
            ReponseMessage message = new ReponseMessage("Liste postulant supprimé avec succes", true);
            return message;
        }
        else {
            ReponseMessage message = new ReponseMessage("Liste postulant non trouvée", false);
            return message;
        }
    }

    @Override
    public Liste_postulant trouverStatuParIdListePostulant(Long idlistepostulant) {

        return listePostulantRepository.findByIdliste(idlistepostulant);
    }

    @Override
    public Liste_postulant trouverListePostulantParLibelle(String libelleliste) {
        return listePostulantRepository.findByLibelleliste(libelleliste);
    }

    @Override
    public Liste_postulant creerlistepostulant(Liste_postulant listePostulant) {
        return listePostulantRepository.save(listePostulant);
    }
}
