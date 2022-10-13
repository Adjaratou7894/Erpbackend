package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private String password;


    @ManyToOne
    private Entite entite;

    @ManyToOne
    private Role role;



    @JsonIgnore

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name="ActivitesUtilisateursAnimer",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idactivite")
    )
    private List<Activite> activites = new ArrayList<>();

@JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(
            name="Taches_utilisateurs",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = " idST")
    )

    private List<Taches> taches = new ArrayList<>();

}
