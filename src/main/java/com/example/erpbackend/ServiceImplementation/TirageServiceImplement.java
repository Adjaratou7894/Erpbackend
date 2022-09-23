package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Model.Liste_postulant;
import com.example.erpbackend.Model.Postulant;
import com.example.erpbackend.Model.Tirage;
import com.example.erpbackend.Repository.TirageRepository;
import com.example.erpbackend.Service.TirageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TirageServiceImplement implements TirageService{

    //definition du repositroy du tirage
    @Autowired
    public final TirageRepository tirageRepository;


    //================DEBUT DE LA METHODE PERMETTANT DE FAIRE LE TIRAGE=========================
    @Override
    public List<Postulant> trie(List<Postulant> listAtrier, Long nbre) {
        //création d'une variable random
        Random rand = new Random();
        //declaration de la liste qui contiendra les postulants selectionnés
        List<Postulant> list = new ArrayList<>();

        /*
         * cette boucle prend un nombre de 0 à taille-1(lindex) de la liste à trié en suite
         * on se sert de cette index pour recuperer la valeur correspondante dans la liste à trié après
         * on supprimme cette valeur dans la liste à trié pour ne pas encore tombé dessus et en fin
         * on retourne la liste trié après la boucle
         * */
        for (int i = 0; i< nbre; i++)
        {
            //cette variable va contenir les index choisi par random aleatoirement
            Integer index = rand.nextInt(listAtrier.size());

            //l'ajout de la valeur de l'index choisit aleatoirement
            list.add(listAtrier.get(index));
            //suppression de la valeur choisi dans la liste à trier
            listAtrier.remove(listAtrier.get(index));
        }

        //on retourne les postulant trié
        return list;
    }
    //================FIN DE LA METHODE PERMETTANT DE FAIRE LE TIRAGE=========================

    //================DEBUT DE LA METHODE PERMETTANT DE CREER UN TIRAGE=========================
    @Override
    public Tirage creer(Tirage tirage, Liste_postulant liste) {


        //ajout de l'id de la liste à au tirage
        tirage.setIdtirage(liste.getIdliste());

        //ajout de la date actuelle au tirage
        tirage.setDate(new Date());

        //retourne le tirage crée
        return tirageRepository.save(tirage);
    }
    //================FIN DE LA METHODE PERMETTANT DE CREER UN TIRAGE=========================

    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER LE LIBELLE DU TIRAGE=========================
    @Override
    public Tirage trouverTirageParLibelle(String libelleTirage) {
        return tirageRepository.findByLibelleTirage(libelleTirage);
    }
    //================FIN DE LA METHODE PERMETTANT DE RECUPERER LE LIBELLE DU TIRAGE=========================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LES TIRAGES=========================
    @Override
    public List<Tirage> lire() {
        return tirageRepository.findAll();
    }

    @Override
    public Long nombreTotaltirage() {
        return tirageRepository.nombretirageTotale();
    }

    @Override
    public Iterable<Object[]> AfficherTousLesTirages(Long idlistepostulant) {
        return tirageRepository.trouverParId(idlistepostulant);
    }

    @Override
    public Tirage recupererTirageIdTirage(Long idtirage) {
        return tirageRepository.findById(idtirage).get();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LES TIRAGES=========================
}
