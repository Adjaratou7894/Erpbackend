package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Annee;

import java.util.List;

public interface AnneeService {

    ReponseMessage ajouterAnnee (Annee annee);
    List<Object> afficherAnnee();
}
