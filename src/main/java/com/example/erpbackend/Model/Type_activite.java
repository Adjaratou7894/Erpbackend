package com.example.erpbackend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Type_activite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long    idActivite;
    private String  typeActivite;
    private String typePostulant;
}
