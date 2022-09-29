package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Taches;
import com.example.erpbackend.Repository.TachesRepository;
import com.example.erpbackend.Service.TacheService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TacheServiceImplement implements TacheService {

    final private TachesRepository tachesRepository;

    @Override
    public ReponseMessage enregistrerTaches(Taches taches, String idusers) {
        tachesRepository.save(taches);


        String[] allIdidusers = idusers.split(",");

        System.out.println("les id : " + allIdidusers);

        for (String idact : allIdidusers) {

            long l = Long.parseLong(idact);

            tachesRepository.insert_taches_utilisateurs(l, taches.getIdTache());

        }


        ReponseMessage message = new ReponseMessage("Tache enregistré avec succès", true);
        return message;
    }

    @Override
    public List<Taches> recupererTousLesTaches() {

        return tachesRepository.findAll();
    }
}
