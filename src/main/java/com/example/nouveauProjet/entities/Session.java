package com.example.nouveauProjet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    private String libelle;

    private  String annee;

    private String mois;

    @JsonIgnore
    @OneToMany(mappedBy="session",cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
    private List<Candidat> candidatList;

}
