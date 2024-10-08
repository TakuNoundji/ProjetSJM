package com.example.nouveauProjet.repositories;

import com.example.nouveauProjet.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {

}
