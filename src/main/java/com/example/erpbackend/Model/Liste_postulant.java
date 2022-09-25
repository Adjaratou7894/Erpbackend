package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Liste_postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idliste;
    private String libelleliste;
    private Integer nombretirage;
    private Date dateliste;

    @OneToOne
    private Activite activite;
}
