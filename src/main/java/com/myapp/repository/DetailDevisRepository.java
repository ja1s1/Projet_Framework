package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.DetailDevis;

public interface DetailDevisRepository extends JpaRepository<DetailDevis, Integer> {
    
}
