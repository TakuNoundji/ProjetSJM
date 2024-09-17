package com.example.nouveauProjet.repositories;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Note;
import com.example.nouveauProjet.entities.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findNoteByCandidatAndRubrique(Candidat candidat, Rubrique rubrique);

    Boolean existsByCode(Long code);

    Boolean existsByCandidatAndRubrique(Candidat candidat, Rubrique rubrique);
    Note findNoteByCandidatOrRubrique(Candidat candidat, Rubrique rubrique);


}
