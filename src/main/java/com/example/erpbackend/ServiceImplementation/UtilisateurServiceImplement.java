package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Utilisateur;
import com.example.erpbackend.Repository.UtilisateurRepository;
import com.example.erpbackend.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImplement implements UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;


    // ================= ajouter un utilisateur   ===============================================================
    @Override
    public ReponseMessage ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()) == null){
            utilisateurRepository.save(utilisateur);
            ReponseMessage message = new ReponseMessage("Utilisateur ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet utilisateur existe déjà ", false);

            return message;
        }
    }


    // ================= Modifier un utilisateur   =============================================================
    @Override
    public ReponseMessage modifierUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.findByIduser(utilisateur.getIduser()) !=null) {
            return utilisateurRepository.findById(utilisateur.getIduser())
                    .map(u -> {
                        u.setNom(utilisateur.getNom());
                        u.setPrenom(utilisateur.getPrenom());
                        u.setNumero(utilisateur.getNumero());
                        u.setEmail(utilisateur.getEmail());
                        u.setPassword(utilisateur.getPassword());
                        utilisateurRepository.save(u);
                        ReponseMessage message = new ReponseMessage("User modifié avec succes", true);
                        return  message;
                    }).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas"));
        }else {
            ReponseMessage message = new ReponseMessage("User non trouvée ", false);

            return message;
        }

    }


    // ================= lister tous les utilisateurs ===================================================
    @Override
    public List<Utilisateur> afficherUtilisateur() {
        return utilisateurRepository.tousLesUtilisateurs();
    }


    // ================= Supprimer un utilisateur par son Id ===================================================
    @Override
    public ReponseMessage supprimerUtilisateur(Long iduser) {
        if(utilisateurRepository.findByIduser(iduser) != null){
            utilisateurRepository.deleteById(iduser);
            ReponseMessage message = new ReponseMessage("User supprimé avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("User non trouvée", false);
            return message;
        }
    }


    // ================= Connexion d'un utilisateur avec email et mot de passe ==================================
    @Override
    public Object seConnecter(String email, String motDePasse) {


        Utilisateur utilisateur = utilisateurRepository.findByEmailAndPassword(email, motDePasse);

        if (utilisateur != null){
            return utilisateur;

        }else{

            ReponseMessage message = new ReponseMessage("Mot de passe ou identifiant incorrect", false);
            return message;

        }
    }

    @Override
    public List<Object> afficherUtilisateurParEntite(String entite) {
        return utilisateurRepository.findUtilisateurParEntite(entite);
    }

    @Override
    public List<Object> findUtilisateurParEntiteToute() {
        return utilisateurRepository.findUtilisateurParEntiteToute();
    }


}
