package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByNom(String nom);

    Role findByIdrole(Long idrole);
}
