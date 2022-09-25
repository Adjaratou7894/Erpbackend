package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Postulant_tire;
import com.example.erpbackend.Model.Statut;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Repository.PostulantRepository;
import com.example.erpbackend.Repository.PostulantTireRepository;
import com.example.erpbackend.Service.PostulantService;
import com.example.erpbackend.Service.PostulantTireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostulantTireServiceImplement implements PostulantTireService {

    private PostulantTireRepository postulantTireRepository;
    private PostulantService postulantService;
    private PostulantRepository postulantRepository;

    @Override
    public ReponseMessage ajouterPostulantTrie(Postulant postulant, Tirage tirage) {

            Postulant_tire postulantTire = new Postulant_tire();

        Postulant postulantAjoute = postulantService.ajouterPostulant(postulant);

            if(postulantAjoute != null){

                postulantTire.setIdPostulant(postulantAjoute.getId());

                postulantTire.setTirage(tirage);

                postulantTireRepository.save(postulantTire);

                ReponseMessage message = new ReponseMessage("Participant ajouté avec succes", true);

                return  message;
            } else {
            ReponseMessage message = new ReponseMessage("Cet Participant existe déjà sur une liste veuillez l'ajouter depuis cette liste", false);

            return message;
        }
    }

    @Override
    public List<Postulant_tire> listerPostulantTrie() {

        return postulantTireRepository.findAll();
    }

    @Override
    public ReponseMessage supprimerPostulantTrie(Long id) {
        if(postulantTireRepository.findById(id) != null){
            postulantTireRepository.deleteById(id);
            ReponseMessage message = new ReponseMessage("Postulant tiré supprimé avec succes", true);
            return message;
        }
        else {
            ReponseMessage message = new ReponseMessage("Postulant tiré non trouvée", false);
            return message;
        }
    }

    @Override
    public Postulant_tire trouverPostulantTrieParidPostulant(Long idPostulant) {

        return postulantTireRepository.findByIdPostulant(idPostulant);
    }

    @Override
    public List<Postulant> recupererTousLesPostulantTire() {

        List<Long> idPostTire = postulantTireRepository.FIND_ALL_POSTULANT_TIRE();

        Postulant postulant = new Postulant();
        List<Postulant> postulantList = new ArrayList<>();

        for (Long idPost : idPostTire){
            postulant = postulantRepository.FIND_POSTULANT_PAR_ID(idPost);
            postulantList.add(postulant);
        }

        return postulantList;
    }

    @Override
    public List<Postulant> recupererTousLesPostulantTireFilter(String genre) {
        List<Long> idPostTire = postulantTireRepository.FIND_ALL_POSTULANT_TIRE();
       // List<String> gpt = postulantTireRepository.FIND_POSTULANT_PAR_GENRE(genre);
        Postulant postulant = new Postulant();
        List<Postulant> postulantList = new ArrayList<>();
        List<Postulant> postulantsGenre = new ArrayList<>();



        for (Long idPost : idPostTire){

                postulant = postulantRepository.FIND_POSTULANT_PAR_ID(idPost);
                    postulantList.add(postulant);
        }
        for (Postulant p: postulantList){
            if ( p != null){
                if(p.getGenre().equals(genre)){
                    postulantsGenre.add(p);
                }
            }
        }
        return postulantsGenre;
    }
}
