package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Designation;
import com.example.erpbackend.Repository.DesignationRepository;
import com.example.erpbackend.Service.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DesignationServiceImplement implements DesignationService {

    final private DesignationRepository designationRepository;

    @Override
    public ReponseMessage enregistrerDesignation(Designation designation) {
        if(designationRepository.findByLibelle(designation.getLibelle()) == null){
            designationRepository.save(designation);
            ReponseMessage message = new ReponseMessage("Designation enregistré avec succes", true);

            return message;
        }else{
            return null;
        }
    }

    @Override
    public List<Designation> recupererTousLesDesignation() {

        return designationRepository.findAll();
    }

    @Override
    public Designation recupererDesignationParLibelle(String libelle) {
        return designationRepository.findByLibelle(libelle);
    }
}
