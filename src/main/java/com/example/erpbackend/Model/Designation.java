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
public class Designation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idDesignation;

   private String libelle;
   private Boolean etat;
}
