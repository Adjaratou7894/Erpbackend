package com.example.erpbackend.Repository;

import com.example.erpbackend.Model.Etat_activite;
import com.example.erpbackend.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByNom(String nom);

    Role findByIdrole(Long idrole);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ROLE (nom) VALUES (\"admin\");",nativeQuery = true)
    void creationrole();
}
