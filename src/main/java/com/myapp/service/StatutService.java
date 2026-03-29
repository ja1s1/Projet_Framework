package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Statut;
import com.myapp.repository.StatutRepository;

@Service
public class StatutService {
    @Autowired
    private StatutRepository statutRepository;

    public List<Statut> getAllStatuts(){
        return statutRepository.findAll();
    }

    public Statut getStatutById(Integer id){
        return statutRepository.findById(id).orElse(null);
    }
}
