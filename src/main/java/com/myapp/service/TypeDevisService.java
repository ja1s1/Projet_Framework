package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.entity.TypeDevis;
import com.myapp.repository.TypeDevisRepository;

public class TypeDevisService {
    @Autowired
    private TypeDevisRepository typeDevisRepository;

    public List<TypeDevis> getAllTypeDevis(){
        return typeDevisRepository.findAll();
    }

    public TypeDevis getTypeById(Integer id){
        return typeDevisRepository.findById(id).orElse(null);
    }
    
}
