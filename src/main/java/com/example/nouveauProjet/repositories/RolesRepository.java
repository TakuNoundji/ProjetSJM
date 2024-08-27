package com.example.nouveauProjet.repositories;

import com.example.nouveauProjet.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {


    Role findByLibelle(String libelle);
}
