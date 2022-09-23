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

    private Long  id;
    private String nom;
    private Date   dateDebut;
    private Date   dateFin;
    private String duree;
    private Boolean etat;

    @ManyToOne
    private Type_activite typeActivite;
    @ManyToOne
    private Etat_activite etatActivite;
    @ManyToOne
    private Entite entite;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToOne
    private Salle salle;

}
