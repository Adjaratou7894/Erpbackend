package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Repository.SalleRepository;
import com.example.erpbackend.Service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SalleServiceImplement implements SalleService {
    private final SalleRepository salleRepository;

    //****************Ajout d'une Salle*******************
    @Override
    public ReponseMessage AjouterSalle(Salle salle) {
        if (salleRepository.findBySalle(salle.getNom()) != null) {
            salleRepository.save(salle) ;
            ReponseMessage message = new ReponseMessage("Salle ajouté avec succes", true);
            return message;
        }else { ReponseMessage message = new ReponseMessage("Ajout Impossible", false);
            return message;
        }
        }
    //****************Liste de toutes les Salles*******************
    @Override
    public List<Salle> AffichageDesSalle() {
        return salleRepository.findAll();
    }

    //****************Modification de la Salle*******************
    @Override
    public Salle modifierSalle( Salle salle) {
        return salleRepository.findById(salle.getIdsalle())
                .map(pA-> {
                    pA.setNom(salle.getNom());
                    pA.setDisponibilite(salle.getDisponibilite());
                    return salleRepository.save(pA);
                }).orElseThrow(()-> new RuntimeException("Salle non trouvée"));
    }

    //****************Supression de la Salle*******************
    @Override
    public ReponseMessage SupprissionSalle(Long idsalle) {
        if (salleRepository.findById(idsalle) !=null){
            ReponseMessage message = new ReponseMessage("Salle Supprimer avec Succés", true);
           return message;
        } else {
            ReponseMessage message = new ReponseMessage("Impossible de Supprimer", false);
            return message;
        }

    }

    @Override
    public List<Salle> AffichageDesSalleOccupee() {
        return salleRepository.AfficherLesSallesDisponible();
    }

    @Override
    public List<Salle> AffichageDesSalleLibre() {
        return salleRepository.AfficherLesSallesOccupee();
    }

    @Override
    public Salle trouverSalleParId(Long idsalle) {
        return salleRepository.findByIdsalle(idsalle);
    }
}
