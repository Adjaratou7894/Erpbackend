package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.StatutTache;

import java.util.List;

public interface StatutTacheService {

    ReponseMessage enregistreStatutTache(StatutTache statutTache);

    List<StatutTache> recupererTousLesStatutTaches();

    StatutTache recupererStatutTacheParLibelle(String libelle);

}
