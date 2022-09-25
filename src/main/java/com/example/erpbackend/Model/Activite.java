package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    private Type_activite typeActivite;


    @ManyToOne
    private Etat_activite etatActivite;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToOne
    private Salle salle;


}
