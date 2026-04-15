package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.TypeDevis;

public interface TypeDevisRepository extends JpaRepository<TypeDevis, Integer> {
    
}
