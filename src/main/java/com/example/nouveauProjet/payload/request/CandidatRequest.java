package com.example.nouveauProjet.payload.request;


import lombok.Data;

@Data
public class CandidatRequest {

    private Long code;

    private String nom;
    private String prenom;

    private String matricule;

    private String sexe;


    private double moyenneProbatoire;

    private String observations;


    private String mentionBaccFrancophone;

    private String gceA;
    


    private int age;
    private Long session_id;

}
