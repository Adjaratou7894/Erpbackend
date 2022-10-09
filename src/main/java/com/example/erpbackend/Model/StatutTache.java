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
public class StatutTache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idST;

    private String libelle;
}
