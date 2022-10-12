package com.example.erpbackend.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActiviteRetour {

    private Long id;

    private String libelle;

    private Date dateDebut;

    private  Date datefin;

    private String createur;

    private String responsable;

    private String description;

    private String Salle;

    private String photo;

    private String etat;

    private Long ObjectifVise;

}
