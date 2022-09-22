package com.example.erpbackend.Model;

import lombok.Data;

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
    private Long  id;
    private String nom;
    private Date   DateDebut;
    private Date   DateFin;
    private String duree;
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
