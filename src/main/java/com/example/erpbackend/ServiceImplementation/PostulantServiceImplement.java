package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Repository.PostulantRepository;
import com.example.erpbackend.Service.ListePostulantService;
import com.example.erpbackend.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class PostulantServiceImplement implements PostulantService {

    final private PostulantRepository postulantRepository;
    final private ListePostulantService listePostulantService;


    @Override
    public List<Postulant> enregistrerPostulant(List<Postulant> listPost) {

        return postulantRepository.saveAll(listPost);
    }

    @Override
    public Postulant ajouterPostulant(Postulant postulant, String libelleListe) {

       Liste_postulant liste  = listePostulantService.trouverListePostulantParLibelle(libelleListe);

       System.out.println("liste bbbbbb: " + liste.getLibelleliste());


       Long idListe = liste.getIdliste();

        List<Postulant> listPostulant = postulantRepository.FIND_POSTULANT_FROM_LISTE(idListe);

        boolean notexistePostulant = true;


        for (Postulant p: listPostulant){

            if (p.getNumero_postulant().equals(postulant.getNumero_postulant())){
                notexistePostulant = false;
                System.out.println("1111111111111111111111111"+ notexistePostulant);
            }else {
                notexistePostulant = true;
            }
        }

        if (notexistePostulant == true){

            ReponseMessage message = new ReponseMessage("Postulant ajouté avec succès", true);
            postulant.setEtat(true);
            postulant.setListePostulant(liste);
            System.out.println("my bool" + notexistePostulant);

            return postulantRepository.save(postulant);

        }else {
            ReponseMessage message = new ReponseMessage("Ce postulant existe déjà", false);
            System.out.println("my bool" + notexistePostulant);
            return null;
        }
    }

    @Override
    public List<Postulant> afficherPostulant() {
        return postulantRepository.findAll();
    }

    @Override
    public List <Postulant> trouverPostulantParGenre(String genre) {
        return postulantRepository.findByGenre(genre);
    }

    @Override
    public List<Object> trouverAllApprenantOuParticipant(String typePostulant) {

        return postulantRepository.FIND_ALL_APPRENANT_OR_PARTICIPANT(typePostulant);
    }

    @Override
    public List<Object> filtreParGenreETActivite(String genre, String nom) {
        List<Object> postulants = postulantRepository.findByGenreAndActivite(genre, nom);
        if (postulants.size() != 0){
            return postulants;
        }
        return Collections.singletonList("aucun postulant n'est trouvé avec cette activité!");
    }

    @Override
    public List<Object> filtreParActivite(String activite) {
        List<Object> postulants = postulantRepository.findByActivite(activite);
        if (postulants.size() != 0){
            return postulants;
        }
        return Collections.singletonList("aucun postulant n'est trouvé avec cette activité !");
    }



}
