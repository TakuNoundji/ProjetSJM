package com.example.nouveauProjet.services;

import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Rubrique;
import com.example.nouveauProjet.payload.request.CandidatRequest;
import com.example.nouveauProjet.payload.request.RubriqueRequest;
import com.example.nouveauProjet.repositories.CandidatRepository;
import com.example.nouveauProjet.repositories.RubriqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RubriqueService {



    @Autowired
    private RubriqueRepository rubriqueRepository;


    private ModelMapper mapper = new ModelMapper();

    public List<Rubrique> rubriqueList() {
        return rubriqueRepository.findAll();
    }

    public Rubrique getRubriqueById(Long id) throws Exception{
        if (rubriqueRepository.existsById(id)){
            return rubriqueRepository.findById(id).get();
        }else {
            throw new Exception("Cette rubrique n\'existe pas");
        }
    }


    public Rubrique saveRubrique(RubriqueRequest rubriqueRequest){
        Rubrique rubrique = maptoEntity(rubriqueRequest);
        rubrique.setCode(null);
        return rubriqueRepository.save(rubrique);
    }

    public Rubrique updateRubrique(RubriqueRequest rubriqueRequest) throws Exception{
        if (rubriqueRepository.existsById(rubriqueRequest.getCode())){
            Rubrique rubrique = maptoEntity(rubriqueRequest);
            return rubriqueRepository.save(rubrique);
        }else{
            throw new Exception("Rubrique non trouvée");
        }
    }

    public void deleteRubriqueById(Long id) throws Exception{
        if(rubriqueRepository.existsById(id)){
            rubriqueRepository.deleteById(id);
        }else{
            throw new Exception("Rubrique non trouvée");
        }
    }


    public Rubrique maptoEntity(RubriqueRequest rubriqueRequest) {
        return mapper.map(rubriqueRequest,Rubrique.class);
    }
}
