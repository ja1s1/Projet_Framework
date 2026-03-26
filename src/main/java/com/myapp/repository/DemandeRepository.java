package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    
}
