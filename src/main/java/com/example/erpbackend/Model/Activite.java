package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idactivite;
    private String nom;
    private String description;
    private String photoactivite;
    private Date   dateDebut;
    private Date   dateFin;
    private int mois;
    private Boolean etat;
    private String nombrepersonnedemande;

    @ManyToOne
    private Type_activite typeActivite;

    @ManyToOne
    private Etat_activite etatActivite;



    @JsonIgnore
    @ManyToOne
    private Utilisateur responsable;


    @JsonIgnore
    @ManyToOne
    private Annee annee;

    @ManyToOne
    private Entite entite;

    @JsonIgnore
    @OneToOne
    private Salle salle;


    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name="ActivitesUtilisateursAnimer",
            joinColumns = @JoinColumn(name = "idactivite"),
            inverseJoinColumns = @JoinColumn(name = "iduser")
    )
    private List<Utilisateur> utilisateurs = new ArrayList<>();





}
