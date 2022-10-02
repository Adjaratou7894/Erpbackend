package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Taches;

import java.util.List;

public interface TacheService {

    ReponseMessage enregistrerTaches(Taches taches, String idusers);

    List<Taches> recupererTousLesTaches();

}
