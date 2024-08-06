package com.example.nouveauProjet.controllers;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.payload.request.CandidatRequest;
import com.example.nouveauProjet.payload.response.MessageResponse;
import com.example.nouveauProjet.repositories.CandidatRepository;
import com.example.nouveauProjet.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sjm/candidat")
public class CandidatControllers {

    @Autowired
    private CandidatService candidatService;



    @GetMapping
    public ResponseEntity<?> getAllCandidat(){
        try {
            List<Candidat> candidats = candidatService.candidatList();
            return new ResponseEntity(candidats, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<?> getCandidat(@PathVariable Long id){
        try{
            Candidat candidat = candidatService.getCandidatById(id);
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveRubrique(@RequestBody CandidatRequest candidatRequest){
        try{
            Candidat candidat = candidatService.saveCandidat(candidatRequest);
            return  new ResponseEntity<>(candidat, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK
            );
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCandidat(@RequestBody CandidatRequest candidatRequest){
        try{
            Candidat candidat = candidatService.updateCandidat(candidatRequest);
            return new ResponseEntity<>(candidat, HttpStatus.CREATED);
        }catch  (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteCandidat(@PathVariable("id") Long id){
        try {
            candidatService.deleteCandidatById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK
            );
        }
    }
}
