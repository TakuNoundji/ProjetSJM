package com.example.nouveauProjet.payload.request;

import lombok.Data;

@Data
public class SeanceRequest {

    private Long code;

    private String hdebut;

    private String hfin;

    private int jury;

    private int nbrseance;
    private Long rubrique_id;

}
