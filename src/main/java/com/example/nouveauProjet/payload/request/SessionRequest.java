package com.example.nouveauProjet.payload.request;

import lombok.Data;

@Data
public class SessionRequest {

    private Long code;

    private String libelle;

    private  String annee;

    private String mois;



}
