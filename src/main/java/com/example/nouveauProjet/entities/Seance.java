package com.example.nouveauProjet.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String hdebut;

    private String hfin;

    private int jury;

    private int nbrseance;

    @ManyToOne
    @JoinColumn(name="rubrique_id")
    private Rubrique rubrique;




    @ManyToMany(mappedBy = "likedSeances")
    Set<Candidat> likes;}
