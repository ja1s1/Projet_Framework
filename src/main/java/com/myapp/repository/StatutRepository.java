package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.Statut;

public interface StatutRepository extends JpaRepository<Statut, Integer> {
    
}
