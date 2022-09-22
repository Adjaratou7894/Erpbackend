package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Etat_activite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long  idetat;
    private  String etat;

}
