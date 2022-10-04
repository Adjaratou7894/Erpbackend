package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Acteur {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idacteur;
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    /*
    @ManyToMany(

            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<Activite> activites = new ArrayList<>();
*/
    @ManyToOne
    private Statut statut;

    }


