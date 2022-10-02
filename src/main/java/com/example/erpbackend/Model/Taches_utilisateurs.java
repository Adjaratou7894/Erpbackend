package com.example.erpbackend.Model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Taches_utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
}
