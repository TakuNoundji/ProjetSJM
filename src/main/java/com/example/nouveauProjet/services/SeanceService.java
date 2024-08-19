package com.example.nouveauProjet.services;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Rubrique;
import com.example.nouveauProjet.entities.Seance;
import com.example.nouveauProjet.entities.Session;
import com.example.nouveauProjet.payload.request.SeanceRequest;
import com.example.nouveauProjet.payload.request.SessionRequest;
import com.example.nouveauProjet.repositories.RubriqueRepository;
import com.example.nouveauProjet.repositories.SeanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;


    @Autowired
    private RubriqueRepository rubriqueRepository;


    private ModelMapper mapper = new ModelMapper();


    public List<Seance> seanceList(){
        return seanceRepository.findAll();
    }

    public Seance getSeanceById(Long id) throws Exception{
        if (seanceRepository.existsById(id)){
            return seanceRepository.findById(id).get();
        }else{
            throw new Exception("cette séance n\'existe pas");
        }
    }

    public Seance saveSeance(SeanceRequest seanceRequest){
        Seance seance = maptoEntity(seanceRequest);
        seance.setCode(null);
        return seanceRepository.save(seance);
    }


    public Seance updateSeance(SeanceRequest seanceRequest) throws Exception{
        if (seanceRepository.existsById(seanceRequest.getCode())){
            Seance seance = maptoEntity(seanceRequest);
            return seanceRepository.save(seance);
        }else{
            throw new Exception("Séance non trouvée");
        }
    }

    public void deleteSeanceById(Long id) throws Exception{
        if(seanceRepository.existsById(id)){
            seanceRepository.deleteById(id);
        }else{
            throw new Exception("Seance non trouvée");
        }
    }


    public Seance maptoEntity(SeanceRequest seanceRequest) {

        Seance seance=mapper.map(seanceRequest,Seance.class);
        Rubrique rubrique = rubriqueRepository.findById(seanceRequest.getRubrique_id()).get();

        seance.setRubrique(rubrique);
        return seance;





    }



}
