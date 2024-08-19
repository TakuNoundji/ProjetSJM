package com.example.nouveauProjet.controllers;


import com.example.nouveauProjet.entities.Rubrique;
import com.example.nouveauProjet.entities.Session;
import com.example.nouveauProjet.payload.request.RubriqueRequest;
import com.example.nouveauProjet.payload.request.SessionRequest;
import com.example.nouveauProjet.payload.response.MessageResponse;
import com.example.nouveauProjet.services.RubriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sjm/rubrique")
public class RubriqueControllers {

    @Autowired
    private RubriqueService rubriqueService;

    @GetMapping
    public ResponseEntity<?> getAllRubrique(){
        try {
            List<Rubrique> rubriques = rubriqueService.rubriqueList();
            return new ResponseEntity(rubriques, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<?> getRubrique(@PathVariable Long id){
        try {
            Rubrique rubrique = rubriqueService.getRubriqueById(id);
            return new ResponseEntity<>(rubrique, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.OK);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveRubrique(@RequestBody RubriqueRequest rubriqueRequest) {
        try {
            Rubrique rubrique = rubriqueService.saveRubrique(rubriqueRequest);
            return new ResponseEntity<>(rubrique, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateRubrique(@RequestBody RubriqueRequest rubriqueRequest){
        try {
            Rubrique rubrique = rubriqueService.updateRubrique(rubriqueRequest);
            return new ResponseEntity<>(rubrique, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteRubrique(@PathVariable("id") Long id){
        try {
            rubriqueService.deleteRubriqueById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

}
