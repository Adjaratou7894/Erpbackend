package com.example.erpbackend.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Liste_postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idliste;
    private String libelleliste;
    private Integer nombretirage;
    private Date dateliste;

    private Boolean validite;


    @OneToOne
    private Activite activite;
}
