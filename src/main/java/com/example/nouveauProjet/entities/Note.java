package com.example.nouveauProjet.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Note {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @ManyToOne
    @JoinColumn(name="candidat_id")
    private Candidat candidat;


    @ManyToOne
    @JoinColumn(name="rubrique_id")
    private Rubrique rubrique;

    private double valeur;




}
