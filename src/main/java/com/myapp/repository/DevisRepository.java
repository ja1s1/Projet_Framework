package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.Devis;

public interface DevisRepository extends JpaRepository<Devis, Integer> {
    
}
