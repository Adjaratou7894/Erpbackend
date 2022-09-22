package com.example.erpbackend.ServiceImplementation;

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
    public Role ajouterRole(Role role) {
        return roleRepository.save(role);
    }
    //================FIN DE LA METHODE PERMETTANT D'AJOUTER UN ROLE=========================


    //================DEBUT DE LA METHODE PERMETTANT DE MODIFIER UN ROLE=========================
    @Override
    public Role modifierRole(Role role) {
        return roleRepository.findById(role.getId())
        .map(p->{
            p.setId(role.getId());
            p.setNom(role.getNom());
            return roleRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Rôle non trouvé !"));
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
    public String supprimerRole(Long id) {

        if (roleRepository.findById(id).get()!=null){
            roleRepository.deleteById(id);
            return "Rôle supprimé avec succès";
        }else {
            return "Ce rôle n'existe pas ";
        }

    }
    //================FIN DE LA METHODE PERMETTANT DE SUPPRIMER UN ROLE=========================
}
