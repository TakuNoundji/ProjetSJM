package com.example.nouveauProjet.payload.request;


import lombok.Data;

@Data
public class NoteRequest {

    private Long code;

    private Long candidat_id;

    private Long rubrique_id;
    
    private double valeur;

}
