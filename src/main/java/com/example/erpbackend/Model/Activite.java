package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String nom;
    private Date   DateDebut;
    private Date   DateFin;
    private String duree;
}
