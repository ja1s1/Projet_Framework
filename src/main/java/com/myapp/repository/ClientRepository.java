package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
