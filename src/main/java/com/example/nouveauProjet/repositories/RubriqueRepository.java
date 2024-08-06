package com.example.nouveauProjet.repositories;

import com.example.nouveauProjet.entities.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {
}
