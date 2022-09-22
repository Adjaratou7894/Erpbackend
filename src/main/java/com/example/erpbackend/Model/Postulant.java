package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Postulant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long  id;
    private String nom;
    private String prenom;
    private String numero;
    private String email;
    private String genre;
    private Boolean etat;
}
