package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.StatutTache;
import com.example.erpbackend.Repository.StatutTacheRepository;
import com.example.erpbackend.Service.StatutTacheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StatutTacheServiceImplement implements StatutTacheService {

    final private StatutTacheRepository statutTacheRepository;

    @Override
    public ReponseMessage enregistreStatutTache(StatutTache statutTache) {
        statutTacheRepository.save(statutTache);
        ReponseMessage message = new ReponseMessage("Le statut enregistré avec succes", true);

        return message;
    }

    @Override
    public List<StatutTache> recupererTousLesStatutTaches() {
        return statutTacheRepository.findAll();
    }

    @Override
    public StatutTache recupererStatutTacheParLibelle(String libelle) {

        return statutTacheRepository.findByLibelle(libelle);
    }
}
