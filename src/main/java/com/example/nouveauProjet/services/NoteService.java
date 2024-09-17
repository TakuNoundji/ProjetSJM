package com.example.nouveauProjet.services;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Note;
import com.example.nouveauProjet.entities.Rubrique;
import com.example.nouveauProjet.payload.request.CandidatRequest;
import com.example.nouveauProjet.payload.request.NoteRequest;
import com.example.nouveauProjet.repositories.CandidatRepository;
import com.example.nouveauProjet.repositories.NoteRepository;
import com.example.nouveauProjet.repositories.RubriqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {


    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private RubriqueRepository rubriqueRepository;

    private ModelMapper mapper = new ModelMapper();



    public List<Note> noteList(){
        return noteRepository.findAll();
    }


    public Note getNoteById(Long code) throws Exception{
        if (noteRepository.existsById(code)){
            return noteRepository.findById(code).get();
        }else{
            throw new Exception("Note non trouvée");
        }
    }
/*
    public  List<Note> getNoteByCandidatId(long candidatId , Long rubriqueId) throws Exception{
        if (noteRepository.existsByCode(candidatId)){
            Candidat candidat = candidatRepository.findById(candidatId).get();
            Rubrique rubrique = rubriqueRepository.findById(rubriqueId).get();
            return (List<Note>) noteRepository.findNoteByCandidatOrRubrique(candidat, rubrique);
        }else {
            throw new Exception("Note non trouvée");
        }
    }*/
/*

    public Note saveNote(NoteRequest noteRequest) {
        Note note = mapto
        return noteRepository.save(note);
    }*/


/*
    public Candidat saveCandidat(CandidatRequest candidatRequest){
        Candidat candidat = maptoEntity(candidatRequest);
        candidat.setCode(null);
        return candidatRepository.save(candidat);
    }*/
    
    
/*
    public Note getNoteOrCreate(NoteRequest noteRequest) throws Exception{
        
        
        Candidat candidat = candidatRepository.findById(noteRequest.getCandidat_id()).get();
        Rubrique rubrique = rubriqueRepository.findById(noteRequest.getRubrique_id()).get();
        
        
        if (noteRepository.existsByCandidatAndRubrique(candidat,rubrique) ||
                noteRepository.existsByCandidatAndRubrique(candidat, rubrique)) {
            System.out.println("get note");

            if (noteRepository.existsByCandidatAndRubrique(candidat, rubrique)){
                return (Note) noteRepository.findNoteByCandidatAndRubrique(candidat, rubrique);
            }
            return (Note) noteRepository.findNoteByCandidatAndRubrique(candidat, rubrique);
        }else{
            System.out.println("create note");
            return this.saveNote(noteRequest);
        }
    }

    
    
    
    public Note saveNote(NoteRequest noteRequest) throws  Exception{
        if (noteRepository.existsByCode(noteRequest.getCandidat_id()) ||
        noteRepository.existsByCode(noteRequest.getRubrique_id())){
            
            
            Note note = maptoEntity(noteRequest);
            note.setCode(null);
            return noteRepository.save(note);
        }else {
            throw  new Exception("Note non troubée");
        }
    }*/


    public Note saveNote(NoteRequest noteRequest){
        Note note = maptoEntity(noteRequest);
        note.setCode(null);
        return  noteRepository.save(note);
    }

    public Note updateNote(NoteRequest noteRequest) throws Exception{
        if (noteRepository.existsByCode(noteRequest.getCode())){
            Note note = maptoEntity(noteRequest);
            return  noteRepository.save(note);
        }else{
            throw new Exception("Note non trouvée");
        }
    }


    @PostMapping

    public void deleNoteByID(Long id) throws  Exception {
        if (noteRepository.existsById(id)){
            noteRepository.deleteById(id);
        }else {
            throw new Exception("Note non trouvée");

        }

    }


    public Note maptoEntity(NoteRequest noteRequest){

        Note note = mapper.map(noteRequest, Note.class);
        Candidat candidat = candidatRepository.findById(noteRequest.getCandidat_id()).get();
        Rubrique rubrique = rubriqueRepository.findById(noteRequest.getRubrique_id()).get();
        note.setCandidat(candidat);
        note.setRubrique(rubrique);

        return  note;
    }


}
