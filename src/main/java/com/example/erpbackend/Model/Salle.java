package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Salle {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long   idsalle;
    private String nom;
    private  Boolean disponibilite;
    private String etage;
    private int nbreplace;
}
