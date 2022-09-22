package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data

public class Acteur {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String numero;
    @ManyToMany
    private List<Activite> activites = new ArrayList<>();


}
