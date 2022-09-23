package com.example.erpbackend.ServiceImplementation;

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
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }


    // ================= Modifier un utilisateur   =============================================================
    @Override
    public Utilisateur modifierUtilisateur(Utilisateur utilisateur, Long id) {
        return utilisateurRepository.findById(id)
                .map(u -> {
                    u.setNom(utilisateur.getNom());
                    u.setPrenom(utilisateur.getPrenom());
                    u.setNumero(utilisateur.getNumero());
                    u.setEmail(utilisateur.getEmail());
                    u.setPassword(utilisateur.getPassword());
                    return utilisateurRepository.save(u);
                }).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas"));
    }


    // ================= lister tous les utilisateurs ===================================================
    @Override
    public List<Utilisateur> afficherUtilisateur() {
        return utilisateurRepository.findAll();
    }


    // ================= Supprimer un utilisateur par son Id ===================================================
    @Override
    public String supprimerUtilisateur(Long id) {
        utilisateurRepository.findById(id);
        return "Utilisateur supprimer avec succé !";
    }


    // ================= Connexion d'un utilisateur avec email et mot de passe ==================================
    @Override
    public Object seConnecter(String email, String motDePasse) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailAndPassword(email, motDePasse);
        if (utilisateur.isEmpty()){
            return "Mot de passe ou identifiant incorrect !";
        }else {
        return utilisateur.get();
        }
    }
}
