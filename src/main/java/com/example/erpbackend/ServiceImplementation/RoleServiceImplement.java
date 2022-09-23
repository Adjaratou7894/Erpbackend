package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Role;
import com.example.erpbackend.Repository.RoleRepository;
import com.example.erpbackend.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements RoleService {


    @Autowired
    private RoleRepository roleRepository;


    //================DEBUT DE LA METHODE PERMETTANT D'AJOUTER UN ROLE=========================
    @Override
    public ReponseMessage ajouterRole(Role role) {
        if (roleRepository.findByNom(role.getNom()) == null){
            roleRepository.save(role);
            ReponseMessage message = new ReponseMessage("Rôle ajouté avec succes", true);
            return  message;
        }else {
            ReponseMessage message = new ReponseMessage("Cet rôle existe déjà ", false);

            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ROLE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE=========================
    @Override
    public ReponseMessage modifierRole(Role role) {
        if (roleRepository.findByIdrole(role.getIdrole()) !=null) {
            return roleRepository.findById(role.getIdrole())
                    .map(p->{
                        //p.setIdrole(role.getIdrole());
                        p.setNom(role.getNom());
                        roleRepository.save(p);
                        ReponseMessage message = new ReponseMessage("Role modifié avec succes", true);
                        return  message;
                    }).orElseThrow(() -> new RuntimeException("Rôle non trouvé !"));
        }else {
            ReponseMessage message = new ReponseMessage("Role non trouvée ", false);

            return message;
        }

    }
    //================FIN DE LA METHODE PERMETTANT DE MODIFIER UN ROLE=========================


    //================DEBUT DE LA METHODE PERMETTANT D'AFFICHER UN ROLE=========================
    @Override
    public List<Role> afficherRole() {
        return roleRepository.findAll();
    }
    //================FIN DE LA METHODE PERMETTANT D'AFFICHER UN ROLE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================
    @Override
    public ReponseMessage supprimerRole(Long idrole) {

        if(roleRepository.findByIdrole(idrole) != null){
            roleRepository.deleteById(idrole);
            ReponseMessage message = new ReponseMessage("Rôle supprimé avec succes", true);
            return message;
        }else {
            ReponseMessage message = new ReponseMessage("Etat non trouvée", false);
            return message;
        }
    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UN ROLE=========================
    @Override
    public Role trouverRoleParId(Long idrole) {
        return roleRepository.findByIdrole(idrole);
    }

    //================FIN DE LA METHODE PERMETTANT DE RECUPERER L'IDENTIFIANT D'UN ROLE=========================

}
