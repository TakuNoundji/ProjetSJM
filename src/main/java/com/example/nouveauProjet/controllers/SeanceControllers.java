package com.example.nouveauProjet.controllers;


import com.example.nouveauProjet.entities.Seance;
import com.example.nouveauProjet.payload.request.SeanceRequest;
import com.example.nouveauProjet.payload.response.MessageResponse;
import com.example.nouveauProjet.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/sjm/seance")
public class SeanceControllers {


    @Autowired
    private SeanceService seanceService;

    @GetMapping
    public ResponseEntity<?> getAllSeance(){
        try{
            List<Seance> seances = seanceService.seanceList();
            return new ResponseEntity(seances, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> getSeance(@PathVariable Long id){
        try {
            Seance seance= seanceService.getSeanceById(id);
            return new ResponseEntity<>(seance, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<?> saveSeance(@RequestBody SeanceRequest seanceRequest){
        try {
            Seance seance = seanceService.saveSeance(seanceRequest);
            return  new ResponseEntity<>(seance, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateSeance(@RequestBody SeanceRequest seanceRequest) {
        try{
            Seance seance = seanceService.updateSeance(seanceRequest);
            return new ResponseEntity<>(seance,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteSeance(@PathVariable("id") Long id){
        try {
            seanceService.deleteSeanceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.OK);
        }
    }

}
