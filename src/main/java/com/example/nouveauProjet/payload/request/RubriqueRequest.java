package com.example.nouveauProjet.payload.request;


import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class RubriqueRequest {

    private Long code;

    private int nombreDeCandidatsParPassage;

    private int dureeDePassage;

    private int pause;

    private String heureDeDebut;

    private String heureDeFin;

    private String nomDeLaRubrique;

}
