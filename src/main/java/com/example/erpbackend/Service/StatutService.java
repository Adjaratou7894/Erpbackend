package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Statut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatutService {

    Statut ajouter(Statut statut);

    List<Statut> lister();

    Statut modifier (Statut statut);

    String supprimer (long id);
}
