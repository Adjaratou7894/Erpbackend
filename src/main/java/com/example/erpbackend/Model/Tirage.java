package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long      id;
    private  String    LibelleTirage;
    private  Integer   nombrePostulantTire;
    private  Date      date;
}
