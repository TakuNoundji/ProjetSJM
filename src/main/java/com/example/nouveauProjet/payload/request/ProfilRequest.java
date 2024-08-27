package com.example.nouveauProjet.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilRequest {

    private Long code;
    private  String email;
    private String telephone;
    private String nom;
    private String prenom;
    private String pseudo;
}
