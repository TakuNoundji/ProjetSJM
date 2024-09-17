package com.example.nouveauProjet.payload.request;


import com.example.nouveauProjet.entities.Seance;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
public class RubriqueRequest {

    private Long code;

    private int nombreDeCandidatsParPassage;

    private int dureeDePassage;

    private int pause;

    private String heureDeDebut;

    private String heureDeFin;

    private String nomDeLaRubrique;
//    private double note;
    private int coefficient;




    private double noteEliminatoire;



}
