package com.example.nouveauProjet.payload.response;


import com.example.nouveauProjet.entities.Role;
import com.example.nouveauProjet.entities.Utilisateur;
import com.example.nouveauProjet.entities.enumeration.ERole;
import com.example.nouveauProjet.payload.request.ProfilRequest;
import com.example.nouveauProjet.payload.request.UtilisateurRequest;
import com.example.nouveauProjet.repositories.RolesRepository;
import com.example.nouveauProjet.repositories.UtilisateurRepository;
import jdk.jshell.execution.Util;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
@Service
public class JwtResponse {



    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RolesRepository rolesRepository;


    private ModelMapper mapper = new ModelMapper();

    public List<Utilisateur> listUser(){
        return utilisateurRepository.findAll();
    }


    public List<Utilisateur> ListeUser(){
        List<Role> roles = new ArrayList<>();
        Role userRole = rolesRepository.findByLibelle((ERole.USER.toString()));

        return utilisateurRepository.findAllByRolesIn(roles);
    }


    public Utilisateur saveUser(UtilisateurRequest utilisateurRequest) {
        System.out.println(utilisateurRequest);

        Utilisateur utilisateur = mapper.map(utilisateurRequest, Utilisateur.class);

        utilisateur.setPseudo(utilisateur.getPrenom());

        String role = utilisateurRequest.getRole();
        List<Role> roles = new ArrayList<>();


        if (role == null){
            Role userRole = rolesRepository.findByLibelle(ERole.USER.toString());
            roles.add(userRole);


        }else {
            switch (role) {
                case "user":
                    Role userRole = rolesRepository.findByLibelle(ERole.USER.toString());
                    roles.add(userRole);
                    break;
                case "admin":
                    Role adminRole = rolesRepository.findByLibelle(ERole.ADMIN.toString());
                    roles.add(adminRole);

                    break;
            }
        }


        utilisateur.setRoles(roles);
        utilisateur.setStatut(Utilisateur.Statut.ACTIVE);
        System.out.println(utilisateur);
        return utilisateurRepository.save(utilisateur);
    }



    public Utilisateur updateProfil(ProfilRequest profilRequest)throws Exception{
        if (utilisateurRepository.existsByCode(profilRequest.getCode())){
            Utilisateur utilisateur = utilisateurRepository.findById(profilRequest.getCode()).get();
            utilisateur.setEmail(profilRequest.getEmail());
            utilisateur.setNom(profilRequest.getNom());
            utilisateur.setPrenom(profilRequest.getPrenom());
            utilisateur.setTelephone(profilRequest.getTelephone());
            utilisateur.setPseudo(profilRequest.getPseudo());
            return utilisateurRepository.save(utilisateur);
        }else{
            throw new Exception("utilisateur non trouvé");
        }
    }

    public boolean verfierEmail(String email){
        if (email != "") {
            return utilisateurRepository.existsByEmail(email);
        }

        return utilisateurRepository.existsByEmail(email);
    }

    public boolean verifierTelephone(String email) {
        return utilisateurRepository.existsUtilisateurByTelephone(email);
    }

    public boolean verifierEmailByToken(String token, String email) throws Exception {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur.getTokenVerification() ==token){
            utilisateur.setIsEmailVerify(Boolean.TRUE);
            return true;
        }else {
            throw new Exception("problème de vérification");
        }
    }
}*/
