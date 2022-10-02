package com.example.erpbackend;

import com.example.erpbackend.Repository.EntiteRepository;
import com.example.erpbackend.Repository.RoleRepository;
import com.example.erpbackend.Repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErpBackendApplication implements CommandLineRunner {
    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final EntiteRepository entiteRepository;

    public ErpBackendApplication(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository, EntiteRepository entiteRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.entiteRepository = entiteRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ErpBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (utilisateurRepository.findAll().size()==0){
            roleRepository.creationrole();
            entiteRepository.creationentite();
            utilisateurRepository.creationadmin();
        }
    }
}
