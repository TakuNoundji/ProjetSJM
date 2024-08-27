package com.example.nouveauProjet.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurRequest {


    private Long code;
    private String email;
    private String telephone;
    private String motDepasse;
    private String nom;
    private String prenom;
    private String role;
}
