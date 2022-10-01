package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String description;
    private Date   dateDebut;
    private Date   dateFin;
    private Boolean etat;
    private String nombrepersonnedemande;

    @ManyToOne
    private Type_activite typeActivite;

    @ManyToOne
    private Etat_activite etatActivite;

    /*@ManyToOne
    private Utilisateur utilisateur;*/

    @JsonIgnore
    @ManyToOne
    private Utilisateur responsable;

    /*
    @ManyToOne
    private Utilisateur animer;

     */

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
