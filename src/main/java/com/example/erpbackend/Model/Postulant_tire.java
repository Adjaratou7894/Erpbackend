package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Postulant_tire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long      id;
    private  Long      idPostulant;

    @ManyToOne
    private Tirage tirage;


    @ManyToOne
    private Liste_postulant listePostulant;
}
