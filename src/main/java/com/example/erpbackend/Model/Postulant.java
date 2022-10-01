package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_postulant;
    private String prenom_postulant;
    private String numero_postulant;
    private String email;
    private String genre;
    private Boolean etat;

    @JsonIgnore
    @ManyToOne
    private Liste_postulant listePostulant;

    //constructeur avec argument
    public Postulant(String nom_postulant, String prenom_postulant, String numero_postulant, String email_postulant, String genre) {
        this.nom_postulant = nom_postulant;

        this.prenom_postulant = prenom_postulant;

        this.numero_postulant = numero_postulant;

        this.email = email_postulant;
        this.genre = genre;
    }
}
