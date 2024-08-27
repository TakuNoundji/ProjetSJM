package com.example.nouveauProjet.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String libelle;
    private String description;
}
