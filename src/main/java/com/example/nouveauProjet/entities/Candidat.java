package com.example.nouveauProjet.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

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

    private double moyenneBacProb;

    private String observations;


    private int age;






    @ManyToOne
    @JoinColumn(name="session_id")
    private Session session;


    @ManyToMany
    @JoinTable(
            name = "affectation",
            joinColumns = @JoinColumn(name = "candidat_id"),
            inverseJoinColumns = @JoinColumn(name = "seance_id"))
    Set<Seance> likedSeances;







}
