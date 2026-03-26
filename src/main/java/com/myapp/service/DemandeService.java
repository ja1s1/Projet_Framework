package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Demande;
import com.myapp.entity.DemandeStatut;
import com.myapp.repository.DemandeRepository;
import com.myapp.repository.DemandeStatutRepository;

import jakarta.transaction.Transactional;

@Service
public class DemandeService {
    
    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    public List<Demande> getAllDemande(){
        return demandeRepository.findAll();
    }

    public Demande getDemandeById(Integer id){
        return demandeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Demande saveDemande(Demande demande){
        Demande savedDemande =  demandeRepository.save(demande);

        DemandeStatut ds = new DemandeStatut();
        ds.setDemande(savedDemande);
        ds.setIdDemandeStatut(1);
        demandeStatutRepository.save(ds);

        return savedDemande;
    }

    public void deleteDemande(Integer id){
        demandeRepository.deleteById(id);
    }
}
