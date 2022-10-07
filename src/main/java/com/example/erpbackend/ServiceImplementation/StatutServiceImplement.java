package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Repository.StatutRepository;
import com.example.erpbackend.Service.StatutService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatutServiceImplement implements StatutService {

    @Autowired
    private final StatutRepository statutRepository;

    @Override
    public ReponseMessage ajouter(Statut statut) {

        if(statutRepository.findByNom(statut.getNom()) == null){
            statutRepository.save(statut);
            ReponseMessage message = new ReponseMessage("Statut ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet statut existe déjà ", false);

            return message;
        }
    }

    @Override
    public List<Statut> lister() {
        return statutRepository.findAll();
    }

    @Override
    public Statut modifier(Statut statut) {
        return statutRepository.findById(statut.getIdstatut())
                .map(statut1 -> {
                    statut1.setNom(statut.getNom());
                    return statutRepository.save(statut1);
                }).orElseThrow(()-> new RuntimeException("Status nom trouver"));
    }

    @Override
    public ReponseMessage supprimer(Long idstatut) {
        if(statutRepository.findByIdstatut(idstatut) != null){
            statutRepository.deleteById(idstatut);
            ReponseMessage message = new ReponseMessage("Statut supprimé avec succes", true);
            return message;
        }
        else {
            ReponseMessage message = new ReponseMessage("Statut non trouvée", false);
            return message;
        }
    }

    @Override
    public Statut trouverStatuParIdstatut(Long idstatut) {

        return statutRepository.findByIdstatut(idstatut);
    }

    @Override
    public Statut trouverparnom(String nom) {
        return statutRepository.findByNom(nom);
    }

}
