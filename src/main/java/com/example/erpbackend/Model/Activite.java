package com.example.erpbackend.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idactivite;
    private String nom;
    private String description;
    @Column(nullable = true, length = 64)
    private String photoactivite;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateDebut;

    private Date datecreation;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date   dateFin;

    private int mois;
    private Boolean etat;

    private String nombrepersonnedemande;
    @JsonIgnore
    @ManyToOne
    private Type_activite typeActivite;


    @ManyToOne
    private Etat_activite etatActivite;
    @JsonIgnore
    @ManyToOne
    private Utilisateur responsable;


   @JsonIgnore
    @ManyToOne
    private Utilisateur createur;

    @JsonIgnore
    @ManyToOne
    private Annee annee;

    @JsonIgnore
    @ManyToOne
    private Entite entite;

    @JsonIgnore
    @OneToOne
    private Salle salle;

    @JsonIgnore
    @OneToOne
    private Liste_postulant liste;


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
