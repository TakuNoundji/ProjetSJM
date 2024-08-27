package com.example.nouveauProjet.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;


    @Column(name= "email", nullable = false, unique = true)
    private String email;
    private String pseudo;
    @Column(name = "telephone", unique= true )
    private String telephone;


    @JsonIgnore
    private String motDePasse;
    private String nom;
    private String prenom;


    @Enumerated(EnumType.STRING)
    private Statut statut;

    private String codeverification;
    private String tokenVerification;

    private Boolean isEmailVerify=Boolean.FALSE;


    public enum Statut {
        ACTIVE, NONACTIVE
    }


    @JsonIgnore
    @ManyToMany(cascade={  CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(joinColumns = {@JoinColumn(name = "code_utilisateur")}, inverseJoinColumns = {@JoinColumn(name = "code_role")})
    private List<Role> roles = new ArrayList<>();



    public Utilisateur(Long code, String email, String telephone, String motDePasse, String nom, String prenom, Statut statut) {
        this.code = code;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.statut = statut;
    }
}
