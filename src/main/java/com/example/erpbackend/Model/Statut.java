package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

}
