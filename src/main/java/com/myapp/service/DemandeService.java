package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Demande;
import com.myapp.repository.DemandeRepository;

@Service
public class DemandeService {
    
    @Autowired
    private DemandeRepository demandeRepository;

    public List<Demande> getAllDemande(){
        return demandeRepository.findAll();
    }

    public Demande getDemandeById(Integer id){
        return demandeRepository.findById(id).orElse(null);
    }

    public Demande saveDemande(Demande demande){
        return demandeRepository.save(demande);
    }

    public void deleteDemande(Integer id){
        demandeRepository.deleteById(id);
    }
}
