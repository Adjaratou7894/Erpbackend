package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Designation;

import java.util.List;

public interface DesignationService {

    ReponseMessage enregistrerDesignation(Designation designation);

    List<Designation> recupererTousLesDesignation();

    Designation recupererDesignationParLibelle(String libelle);

}
