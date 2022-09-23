package com.example.erpbackend.Service;

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

}
