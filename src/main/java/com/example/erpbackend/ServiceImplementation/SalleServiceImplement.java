package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Salle;
import com.example.erpbackend.Repository.SalleRepository;
import com.example.erpbackend.Service.SalleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SalleServiceImplement implements SalleService {

    @Autowired
    private final SalleRepository salleRepository;

    //****************Ajout d'une Salle*******************

 /*   @Override
    public ReponseMessage AjouterSalle(Salle salle) {
        if (salleRepository.findByNom(salle.getNom()) == null) {

            salle.setDisponibilite(true);

            salleRepository.save(salle);
            ReponseMessage message = new ReponseMessage("Salle ajouté avec succes", true);
            return message;
        }else { ReponseMessage message = new ReponseMessage("Cette salle existe déjà", false);
            return message;
           }
        }
*/

    @Override
    public ReponseMessage AjouterSalle(Salle salle) {
        if (salleRepository.findByNom(salle.getNom()) == null) {

            salle.setDisponibilite(true);

            salleRepository.save(salle);
            ReponseMessage message = new ReponseMessage("Salle ajouté avec succes", true);
            return message;
        }else { ReponseMessage message = new ReponseMessage("Cette salle existe déjà", false);
            return message;
        }
    }







        //****************Liste de toutes les Salles*******************
        @Override
        public List<Salle> AffichageDesSalle () {
            return salleRepository.findAll();
        }

    //****************Modification de la Salle*******************
    @Override
    public ReponseMessage modifierSalle( Salle salle) {
        if (salleRepository.findByIdsalle(salle.getIdsalle()) !=null) {
            return salleRepository.findById(salle.getIdsalle())
                    .map(pA-> {
                        pA.setIdsalle(salle.getIdsalle());
                        pA.setNom(salle.getNom());
                        pA.setDisponibilite(salle.getDisponibilite());
                        salleRepository.save(pA);
                        ReponseMessage message = new ReponseMessage("Salle modifiée avec succes", true);
                        return  message;
                    }).orElseThrow(()-> new RuntimeException("Salle non trouvée"));
        }else {
            ReponseMessage message = new ReponseMessage("Salle non trouvée ", false);

            return message;
        }

    }

    //****************Supression de la Salle*******************
    @Override
    public ReponseMessage SupprissionSalle(Long idsalle) {
        if(salleRepository.findByIdsalle(idsalle) != null){
            salleRepository.deleteById(idsalle);
            ReponseMessage message = new ReponseMessage("Salle Supprimée avec Succés", true);
           return message;
        } else {
            ReponseMessage message = new ReponseMessage("Impossible de Supprimer", false);
            return message;
        }

    }

    @Override
    public List<Salle> AffichageDesSalleOccupee() {

        return salleRepository.AfficherLesSallesOccupee();
    }

    @Override
    public List<Salle> AffichageDesSalleLibre() {

        return salleRepository.AfficherLesSallesDisponible();
    }

    @Override
    public Salle trouverSalleParId(Long idsalle) {

        return salleRepository.findByIdsalle(idsalle);
    }

    @Override
    public List<Salle> AfficherLesSallesParDisponibilite( boolean disponibilite) {
        return salleRepository.AfficherLesSallesParDisponibilite(disponibilite);
    }


}
