package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Type_activite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  typeActivite;
    private String typePostulant;
}
