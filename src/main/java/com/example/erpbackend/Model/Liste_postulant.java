package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data

public class Liste_postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlistepostulant;
    private String libelleliste;
    private Integer nombretirage;

    @JsonIgnore
       @OneToOne
    private Activite activite;
}
