package com.example.nouveauProjet.repositories;

import com.example.nouveauProjet.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeanceRepository  extends JpaRepository<Seance, Long> {
}

