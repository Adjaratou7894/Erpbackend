package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class StatutTache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idST;

    private String libelle;
}
