package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Designation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idDesignation;

   private String libelle;
   private Boolean etat;
}
