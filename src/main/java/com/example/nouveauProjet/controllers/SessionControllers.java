package com.example.nouveauProjet.controllers;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Seance;
import com.example.nouveauProjet.entities.Session;
import com.example.nouveauProjet.payload.request.CandidatRequest;
import com.example.nouveauProjet.payload.request.SessionRequest;
import com.example.nouveauProjet.payload.response.MessageResponse;
import com.example.nouveauProjet.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sjm/session")
public class SessionControllers {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public ResponseEntity<?> getAllSession(){

        try {
            List<Session> sessions = sessionService.sessionList();
            return new ResponseEntity(sessions, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<?> getSession(@PathVariable Long id){
        try {
            Session session = sessionService.getSessionById(id);
            return new ResponseEntity<>(session, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


    @PostMapping("/update")
    public ResponseEntity<?> updateSession(@RequestBody SessionRequest sessionRequest){
        try {
            Session session = sessionService.updateSession(sessionRequest);
            return new ResponseEntity<>(session, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSession(@RequestBody SessionRequest sessionRequest){
        try{
            Session session = sessionService.saveSession(sessionRequest);
            return  new ResponseEntity<>(session, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK
            );
        }
    }


    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteSession(@PathVariable("id") Long id){
        try {
            sessionService.deleteSessionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch  (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


}
