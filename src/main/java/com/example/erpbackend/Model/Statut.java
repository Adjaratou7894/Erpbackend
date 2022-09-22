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
<<<<<<< HEAD
    private List<Acteur> acteur = new ArrayList<>();
=======
    private List<Acteur> acteurs = new ArrayList<>();
>>>>>>> fea3055d262c50ccccc5502691815dd88eee3b99

}
