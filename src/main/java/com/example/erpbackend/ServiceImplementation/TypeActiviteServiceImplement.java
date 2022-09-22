package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Type_activite;
import com.example.erpbackend.Repository.TypeActiviteRepository;
import com.example.erpbackend.Service.TypeActiviteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ResponseMessage;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeActiviteServiceImplement implements TypeActiviteService {

    @Autowired
    public TypeActiviteRepository typeActiviteRepository;

    @Override
    public ReponseMessage ajouterTypeActivite(Type_activite type_activite) {

        if (typeActiviteRepository.findByTypeActivite(type_activite.getTypeActivite()) == null)
        {
            typeActiviteRepository.save(type_activite);
            ReponseMessage reponse = new ReponseMessage("Type activité ajouter avec success",true);
            return reponse;
        }
        else{
            ReponseMessage reponse = new ReponseMessage("Type activité existants",false);
            return reponse;
        }



    }





    /*public Type_activite ajouterTypeActivite(Type_activite type_activite) {
        return typeActiviteRepository.save(type_activite);
    }

     */

    @Override
    public List<Type_activite> afficherTypeActivite() {
        return typeActiviteRepository.findAll();
    }

    @Override
    public ReponseMessage modifierTypeActivite(Long id, Type_activite type_activite) {

        if (typeActiviteRepository.findByIdactivite(id) != null){

        return  typeActiviteRepository.findById(id)
                    .map(type_activite1 -> {
                        type_activite1.setTypeActivite(type_activite.getTypeActivite());
                        type_activite1.setTypePostulant(type_activite.getTypePostulant());
                         typeActiviteRepository.save(type_activite1);
                        ReponseMessage rep = new ReponseMessage("Type activité modifier avec success",true);
                          return rep;
                    }).orElseThrow(() -> new RuntimeException("Type activité non trouvé 1"));
        }
        else {
            ReponseMessage reponse = new ReponseMessage("Type activité non trouvé", false);
            return reponse;
        }

    }

    @Override
    public ReponseMessage supprimerTypeActvite(Long id) {
        if (typeActiviteRepository.findByIdactivite(id) != null) {
            ReponseMessage rep;
            typeActiviteRepository.deleteById(id);

            rep = new ReponseMessage("Suppression effectuée", true);

            return rep;
        } else {
            ReponseMessage rep = new ReponseMessage("Impossible de supprimer", false);

            return rep;
        }


    }
}

