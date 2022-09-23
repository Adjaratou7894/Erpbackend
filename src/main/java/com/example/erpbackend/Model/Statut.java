package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data

public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstatut;
    private String nom;
    @ManyToMany
    private List<Acteur> acteurs = new ArrayList<>();

}
