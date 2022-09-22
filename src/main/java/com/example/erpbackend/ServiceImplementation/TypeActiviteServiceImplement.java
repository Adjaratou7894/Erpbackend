package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Model.Type_activite;
import com.example.erpbackend.Repository.TypeActiviteRepository;
import com.example.erpbackend.Service.TypeActiviteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeActiviteServiceImplement implements TypeActiviteService {

    @Autowired
    public  TypeActiviteRepository typeActiviteRepository;
    @Override
    public Type_activite ajouterTypeActivite(Type_activite type_activite) {
        return typeActiviteRepository.save(type_activite);
    }

    @Override
    public List<Type_activite> afficherTypeActivite() {
        return typeActiviteRepository.findAll();
    }

    @Override
    public Type_activite modifierTypeActivite(Long id, Type_activite type_activite) {
        return typeActiviteRepository.findById(id)
                .map(type_activite1 -> {
                    type_activite1.setTypeActivite(type_activite.getTypeActivite());
                    type_activite1.setTypePostulant(type_activite.getTypePostulant());
                    return  typeActiviteRepository.save(type_activite1);
                }).orElseThrow(() -> new RuntimeException("Type activité non trouvé"));
    }

    @Override
    public String supprimerTypeActvite(Long id) {
         typeActiviteRepository.deleteById(id);
        return "Type d'activité supprimer avec success";
    }
}
