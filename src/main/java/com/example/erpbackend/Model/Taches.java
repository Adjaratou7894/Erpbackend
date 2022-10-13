package com.example.erpbackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;

    private Date datedebut;
    private Date datefin;


    @JsonIgnore
    @ManyToOne
    private Designation designation;

    @JsonIgnore
    @ManyToOne
    private Statut statut;

    @JsonIgnore
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
