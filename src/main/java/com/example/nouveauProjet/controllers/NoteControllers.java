package com.example.nouveauProjet.controllers;


import com.example.nouveauProjet.entities.Note;
import com.example.nouveauProjet.payload.request.NoteRequest;
import com.example.nouveauProjet.payload.response.MessageResponse;
import com.example.nouveauProjet.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sjm/note")
public class NoteControllers {

    @Autowired
    private NoteService noteService;

    /**
     * enregistrer une note
     * @param noteRequest
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveNote(@RequestBody NoteRequest noteRequest){
        try{
            Note note = noteService.saveNote(noteRequest);
            return new ResponseEntity<>(note, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateNote(@RequestBody NoteRequest noteRequest){
        try{
            Note note = noteService.updateNote(noteRequest);
            return new ResponseEntity<>(note, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
        try {
            noteService.deleNoteByID(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    /**
     * pour recuperer toutes les notes  en base de données
     * @return
     */

    @GetMapping
    public ResponseEntity<?> getAllNote(){
        try {
            List<Note> notes = noteService.noteList();
            return new ResponseEntity<>(notes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.FORBIDDEN);
        }
    }


    /**
     * recuperer une note par son identifiant
     * @param id
     * @return
     */

    @GetMapping({"/{id}"})
    public ResponseEntity<?> getNote(@PathVariable Long id) {
        try{
            Note note = noteService.getNoteById(id);
            return new ResponseEntity<>(note, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.OK);
        }
    }



}
