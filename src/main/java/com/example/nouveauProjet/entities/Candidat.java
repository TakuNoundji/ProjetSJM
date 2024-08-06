package com.example.nouveauProjet.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String nom;
    private String prenom;

    private String matricule;

    private String sexe;


    @ManyToOne
    @JoinColumn(name="session_id")
    private Session session;

}
