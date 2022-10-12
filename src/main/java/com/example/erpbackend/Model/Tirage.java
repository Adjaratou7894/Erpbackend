package com.example.erpbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long      idtirage;
    private  String    libelleTirage;
    private  Integer   nombrePostulantTire;
    private  Date      date;
    private Boolean     validite;

    @ManyToOne
    private Utilisateur utilisateur;


    @ManyToOne
    private Liste_postulant listePostulant;


    @ManyToOne
    private Activite activite;
}
