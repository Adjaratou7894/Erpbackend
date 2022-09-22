package com.example.erpbackend.Service;

<<<<<<< HEAD
import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Salle;

import java.util.List;

public interface SalleService {
    ReponseMessage AjouterSalle(Salle salle);
    List<Salle> AffichageDesSalle();
    Salle modifierSalle(Salle salle);
    ReponseMessage SupprissionSalle(Long idsalle);
    List<Salle> AffichageDesSalleOccupee();
    List<Salle> AffichageDesSalleLibre();

    Salle trouverSalleParId(Long idsalle);

=======
public interface SalleService {
>>>>>>> fea3055d262c50ccccc5502691815dd88eee3b99
}
