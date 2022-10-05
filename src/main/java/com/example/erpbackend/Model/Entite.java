package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idEntite;
    private String nom;
    private String description;
    @Column(nullable = true, length = 64)
    private String photoentite;
    private String slogant;

}
