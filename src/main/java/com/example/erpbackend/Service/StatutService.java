package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Model.Statut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatutService {

    ReponseMessage ajouter(Statut statut);

    List<Statut> lister();

    Statut modifier (Statut statut);

    ReponseMessage supprimer (Long idstatut);

    Statut trouverStatuParIdstatut (Long idstatut);

    Statut trouverparnom (String nom);

}
