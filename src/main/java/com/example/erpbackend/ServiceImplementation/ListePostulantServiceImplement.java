package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Repository.ListePostulantRepository;
import com.example.erpbackend.Service.ListePostulantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListePostulantServiceImplement implements ListePostulantService {

    @Autowired
    private final ListePostulantRepository listePostulantRepository;

    @Override
    public ReponseMessage ajouterListePostulant(Liste_postulant liste_postulant) {
        if(listePostulantRepository.findByLibelleliste(liste_postulant.getLibelleliste()) == null){
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
        return listePostulantRepository.findById(liste_postulant.getIdlistepostulant())
                .map(lp -> {
                    lp.setLibelleliste(liste_postulant.getLibelleliste());
                    lp.setNombretirage(liste_postulant.getNombretirage());
                    lp.setActivite(liste_postulant.getActivite());
                    return listePostulantRepository.save(lp);
                }).orElseThrow(() -> new RuntimeException("Liste postulant nom trouver") );
    }

    @Override
    public ReponseMessage supprimerListePostulant(Long idlistepostulant) {
        if(listePostulantRepository.findByIdlistepostulant(idlistepostulant) != null){
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

        return listePostulantRepository.findByIdlistepostulant(idlistepostulant);
    }
}
