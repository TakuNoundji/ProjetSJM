package com.example.nouveauProjet.services;


import com.example.nouveauProjet.entities.Session;
import com.example.nouveauProjet.payload.request.SessionRequest;
import com.example.nouveauProjet.repositories.SessionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    private ModelMapper mapper = new ModelMapper();

    public List<Session> sessionList() {
        return sessionRepository.findAll();
    }

    public Session getSessionById(Long id) throws Exception{
        if (sessionRepository.existsById(id)){
            return sessionRepository.findById(id).get();
        }else {
            throw new Exception("cette session n\'existe pas");
        }
    }


    public Session saveSession(SessionRequest sessionRequest){
        Session session = maptoEntity(sessionRequest);
        session.setCode(null);
        return sessionRepository.save(session);
    }

    public Session updateSession(SessionRequest sessionRequest) throws Exception{
        if (sessionRepository.existsById(sessionRequest.getCode())){
            Session session = maptoEntity(sessionRequest);
            return sessionRepository.save(session);
        }else{
            throw new Exception("Session non trouvé");
        }
    }

    public void deleteSessionById(Long id) throws Exception{
        if(sessionRepository.existsById(id)){
            sessionRepository.deleteById(id);
        }else{
            throw new Exception("Session non trouvé");
        }
    }


    public Session maptoEntity(SessionRequest critereRequest) {
        return mapper.map(critereRequest,Session.class);
    }




}
