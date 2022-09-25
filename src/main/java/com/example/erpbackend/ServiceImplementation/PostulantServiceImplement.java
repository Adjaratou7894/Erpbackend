package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Repository.PostulantRepository;
import com.example.erpbackend.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantServiceImplement implements PostulantService {

    private PostulantRepository postulantRepository;


    @Override
    public List<Postulant> enregistrerPostulant(List<Postulant> listPost) {

        return postulantRepository.saveAll(listPost);
    }

    @Override
    public Postulant ajouterPostulant(Postulant postulant) {

        List<Postulant> listPostulant = postulantRepository.FIND_POSTULANT_FROM_LISTE(postulant.getListePostulant().getIdliste());

        boolean existePostulant = false;

        for (Postulant p: listPostulant){

            if (p.getNumero_postulant().equals(postulant.getNumero_postulant())){
                existePostulant = true;
            }
        }

        if (existePostulant == false){


            ReponseMessage message = new ReponseMessage("Postulant ajouté avec succès", true);
            postulant.setEtat(true);
            return postulantRepository.save(postulant);
        }else {
            ReponseMessage message = new ReponseMessage("Ce postulant existe déjà", false);

            return null;
        }
    }

    @Override
    public List<Postulant> afficherPostulant() {
        return postulantRepository.findAll();
    }

    @Override
    public Postulant trouverPostulantParGenre(String genre) {
        return postulantRepository.findByGenre(genre);
    }

    @Override
    public List<Object> trouverAllApprenantOuParticipant(String typePostulant) {

        return postulantRepository.FIND_ALL_APPRENANT_OR_PARTICIPANT(typePostulant);
    }

}
