package com.example.erpbackend.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Taches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;

    private Date datedebut;
    private Date datefin;

    @ManyToOne
    private Designation designation;

    @ManyToOne
    private Statut statut;

    @ManyToOne
    private Activite activite;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name="Taches_utilisateurs",
            joinColumns = @JoinColumn(name = "idST"),
            inverseJoinColumns = @JoinColumn(name = "iduser")
    )
    private List<Utilisateur> utilisateurs = new ArrayList<>();
}
