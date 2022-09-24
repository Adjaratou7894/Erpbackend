package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Activite;
import com.example.erpbackend.Model.Role;
import com.example.erpbackend.Repository.ActiviteRepository;
import com.example.erpbackend.Repository.Activite_ActeurRepository;
import com.example.erpbackend.Service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiviteServiceImplement implements ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private Activite_ActeurRepository activite_acteurRepository;

    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================
    @Override
    public ReponseMessage ajouterActivite(Activite activite, String idacteurs) {
        if (activiteRepository.findByNom(activite.getNom()) == null){

            Activite activiteCree = activiteRepository.save(activite);

            // //Un tableau qui contenera l'id des acteurs par case
            String[] allIdActeurs = idacteurs.split(",");

            for (String idact : allIdActeurs) {

                long l = Long.parseLong(idact);

                activite_acteurRepository.INSERT_ACTEUR_ACTIVITES(l, activite.getIdactivite());

            }

            ReponseMessage message = new ReponseMessage("Activité ajoutée avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cette activité existe déjà ", false);

            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================
    @Override
    public ReponseMessage modifierActivite(Activite activite) {
        if (activiteRepository.findByIdactivite(activite.getIdactivite()) !=null) {
            return activiteRepository.findById(activite.getIdactivite())
                    .map(p -> {
                        p.setNom(activite.getNom());
                        p.setDateDebut(activite.getDateDebut());
                        p.setDateFin(activite.getDateFin());
                        p.setEtat(activite.getEtat());
                        p.setEtatActivite(activite.getEtatActivite());
                        p.setTypeActivite(activite.getTypeActivite());
                        p.setSalle(activite.getSalle());
                        activiteRepository.save(p);
                        ReponseMessage message = new ReponseMessage("Activité modifiée avec succes", true);
                        return  message;

                    }).orElseThrow(() -> new RuntimeException("Activité non trouvée !"));
        }else {
            ReponseMessage message = new ReponseMessage("Activité non trouvée ", false);

            return message;
        }
    }
    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES=========================
    @Override
    public List<Activite> afficherActivite() {

        return activiteRepository.findAll();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER LA LISTE DES ACTIVITES=========================


    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UNE ACTIVITE=========================
    @Override
    public ReponseMessage supprimerActivite(Long idactivite) {
        if(activiteRepository.findByIdactivite(idactivite) != null){
            activiteRepository.deleteById(idactivite);
            ReponseMessage message = new ReponseMessage("Activité supprimée avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Activité non trouvée", false);
            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UNE ACTIVITE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================
    @Override
    public Activite trouverActiviteParId(Long idactivite) {

        return activiteRepository.findByIdactivite(idactivite);
    }

    @Override
    public Activite trouverActiviteParLibelle(String libelleActivite) {

        return activiteRepository.findByNom(libelleActivite);

        }
    //================FIN DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UNE ACTIVITE=========================
}
