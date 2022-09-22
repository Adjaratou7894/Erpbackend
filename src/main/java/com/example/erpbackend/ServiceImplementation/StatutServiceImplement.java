package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Repository.StatutRepository;
import com.example.erpbackend.Service.StatutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatutServiceImplement implements StatutService {

    private final StatutRepository statutRepository;

    @Override
    public Statut ajouter(Statut statut) {

        return statutRepository.save(statut);
    }

    @Override
    public List<Statut> lister() {
        return statutRepository.findAll();
    }

    @Override
    public Statut modifier(Statut statut) {
        return statutRepository.findById(statut.getId())
                .map(statut1 -> {
                    statut1.setNom(statut.getNom());
                    return statutRepository.save(statut1);
                }).orElseThrow(()-> new RuntimeException("Status nom trouver"));
    }

    @Override
    public String supprimer(long id) {
        statutRepository.deleteById(id);
        return "Statut "+id+" suprimer !";
    }
}
