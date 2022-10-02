package com.example.erpbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table
public class Annee {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private int annee;

}
