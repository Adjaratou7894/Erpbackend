package com.example.erpbackend.ServiceImplementation;

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
    public Salle AjouterSalle(Salle salle) {
        return salleRepository.save(salle);
    }
    //****************Liste de toutes les Salles*******************
    @Override
    public List<Salle> AffichageDesSalle() {
        return salleRepository.findAll();
    }

    //****************Modification de la Salle*******************
    @Override
    public Salle modifierSalle(Long id, Salle salle) {
        return salleRepository.findById(id)
                .map(pA-> {
                    pA.setDisponibilite(salle.getDisponibilite());
                    return salleRepository.save(pA);
                }).orElseThrow(()-> new RuntimeException("Salle non trouvée"));
    }

    //****************Supression de la Salle*******************
    @Override
    public String SupprissionSalle(Long id) {
        salleRepository.deleteById(id);
        return "Salle Supprimer avec Succés";
    }

    @Override
    public List<Salle> AffichageDesSalleOccupee() {
        return salleRepository.AfficherLesSallesDisponible();
    }

    @Override
    public List<Salle> AffichageDesSalleLibre() {
        return salleRepository.AfficherLesSallesOccupee();
    }
}
