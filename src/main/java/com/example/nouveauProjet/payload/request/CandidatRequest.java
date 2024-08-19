package com.example.nouveauProjet.payload.request;


import lombok.Data;

@Data
public class CandidatRequest {

    private Long code;

    private String nom;
    private String prenom;

    private String matricule;

    private String sexe;

    private double moyenneBacProb;

    private String observations;


    private int age;
    private Long session_id;

}
