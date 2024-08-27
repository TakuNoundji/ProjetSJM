package com.example.nouveauProjet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Rubrique {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private int nombreDeCandidatsParPassage;

    private int dureeDePassage;

    private int pause;

    private String heureDeDebut;

    private String heureDeFin;

    private String nomDeLaRubrique;

    private double note;

    private int coefficient;




    private double noteEliminatoire;

    @JsonIgnore
    @OneToMany(mappedBy="rubrique",cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private List<Seance> seanceList;



    @ManyToMany(mappedBy = "likedRubriques")
    Set<Session> likesSession;


}
