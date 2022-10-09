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
public class Etat_activite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long  idetat;
    private  String etat;

}
