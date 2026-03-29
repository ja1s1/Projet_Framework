package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.entity.Devis;
import com.myapp.repository.DevisRepository;

public class DevisService {
    
    @Autowired
    private DevisRepository devisRepository;

    public List<Devis> getAllDevis(){
        return devisRepository.findAll();
    }

    public Devis getDevisById(Integer id){
        return devisRepository.findById(id).orElse(null);
    }

    
}
