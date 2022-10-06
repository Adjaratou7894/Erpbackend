package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Acteur_activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    @ManyToOne
    @JoinColumn(name = "activite_id")
    private Activite activite;

}
