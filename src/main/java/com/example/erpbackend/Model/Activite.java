package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idactivite;
    private String nom;
    private Date   dateDebut;
    private Date   dateFin;
    private Boolean etat;
    private String nombrepersonnedemande;

    @ManyToOne
    private Type_activite typeActivite;


    @ManyToOne
    private Etat_activite etatActivite;

    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Utilisateur responsable;

    @ManyToOne
    private Annee annee;
    @ManyToOne
    private Entite entite;

    @OneToOne
    private Salle salle;


}
