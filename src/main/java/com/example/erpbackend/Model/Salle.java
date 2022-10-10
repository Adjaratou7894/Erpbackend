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
public class Salle {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long   idsalle;
    private String nom;
    private  Boolean disponibilite;
    private String etage;
    private int nbreplace;
}
