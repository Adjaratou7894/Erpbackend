package com.example.erpbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
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
