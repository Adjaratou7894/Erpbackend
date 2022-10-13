package com.example.erpbackend.ServiceImplementation;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Annee;
import com.example.erpbackend.Repository.AnneeRepository;
import com.example.erpbackend.Service.AnneeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ResponseMessage;

import java.util.List;

@Service
@AllArgsConstructor
public class AnneeSerciceImplement implements AnneeService {

    @Autowired
    private AnneeRepository anneeRepository;

    //@Override
    //public Annee ajouterAnnee(Annee annee) {
    //if(anneeRepository.findByAnnee(annee.getAnnee()) == null){
    //return anneeRepository.save(annee);
//          ReponseMessage message = new ReponseMessage("Année ajouté avec succes", true);
//        return  message;
//    }else {
//        ReponseMessage message = new ReponseMessage("Cet Année existe déjà ", false);
//
//        return message;


    @Override
    public ReponseMessage ajouterAnnee (Annee annee) {
        if (anneeRepository.findByAnnee(annee.getAnnee()) == null) {
            anneeRepository.save(annee);
            ReponseMessage message = new ReponseMessage("Année ajouté avec succes", true);
            return message;
        } else {
            ReponseMessage message = new ReponseMessage("Cet Année existe déjà ", false);

            return message;
        }
    }

    @Override
    public Annee recupererAnneeParLibelle(int annee) {
        return anneeRepository.findByAnnee(annee);
    }

    @Override
    public List<Annee> recupererLesAnnee() {
        return anneeRepository.findAll();
    }


    public List<Annee> afficherAnnee() {
        return anneeRepository.findAll();
    }


}
