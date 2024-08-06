package com.example.nouveauProjet.services;


import com.example.nouveauProjet.entities.Candidat;
import com.example.nouveauProjet.entities.Session;
import com.example.nouveauProjet.payload.request.CandidatRequest;
import com.example.nouveauProjet.payload.request.SessionRequest;
import com.example.nouveauProjet.repositories.CandidatRepository;
import com.example.nouveauProjet.repositories.SessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {


    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private SessionRepository sessionRepository;

    private ModelMapper mapper = new ModelMapper();

    public List<Candidat> candidatList() {
        return candidatRepository.findAll();
    }

    public Candidat getCandidatById(Long id) throws Exception{
        if (candidatRepository.existsById(id)){
            return candidatRepository.findById(id).get();
        }else {
            throw new Exception("ce candidat n\'existe pas");
        }
    }


    public Candidat saveCandidat(CandidatRequest candidatRequest){
        Candidat candidat = maptoEntity(candidatRequest);
        candidat.setCode(null);
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(CandidatRequest candidatRequest) throws Exception{
        if (candidatRepository.existsById(candidatRequest.getCode())){
            Candidat candidat = maptoEntity(candidatRequest);
            return candidatRepository.save(candidat);
        }else{
            throw new Exception("Candidat non trouvé");
        }
    }

    public void deleteCandidatById(Long id) throws Exception{
        if(candidatRepository.existsById(id)){
            candidatRepository.deleteById(id);
        }else{
            throw new Exception("Candidat non trouvé");
        }
    }


    public Candidat maptoEntity(CandidatRequest candidatRequest) {

        Candidat candidat=mapper.map(candidatRequest,Candidat.class);
        Session session = sessionRepository.findById(candidatRequest.getSession_id()).get();

        candidat.setSession(session);
        return candidat;
    }

}
