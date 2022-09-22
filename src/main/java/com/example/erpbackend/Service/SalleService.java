package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Salle;

import java.util.List;

public interface SalleService {
    Salle AjouterSalle(Salle salle);
    List<Salle> AffichageDesSalle();
    Salle modifierSalle(Long idsalle, Salle salle);
    String SupprissionSalle(Long idsalle);
    List<Salle> AffichageDesSalleOccupee();
    List<Salle> AffichageDesSalleLibre();

}
