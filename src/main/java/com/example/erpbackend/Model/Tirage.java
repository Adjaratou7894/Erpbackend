package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long      id;
    private  String    LibelleTirage;
    private  Integer   nombrePostulantTire;
    private  Date      date;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Liste_postulant listePostulant;
}