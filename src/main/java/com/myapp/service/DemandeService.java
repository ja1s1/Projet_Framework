package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Demande;
import com.myapp.entity.DemandeStatut;
import com.myapp.entity.Statut;
import com.myapp.repository.DemandeRepository;
import com.myapp.repository.DemandeStatutRepository;
import com.myapp.repository.StatutRepository;

import jakarta.transaction.Transactional;

@Service
public class DemandeService {
    
    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    @Autowired
    private StatutRepository statutRepository;

    public List<Demande> getAllDemande(){
        return demandeRepository.findAll();
    }

    public Demande getDemandeById(String id){
        return demandeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Demande saveDemande(Demande demande){
        Demande savedDemande =  demandeRepository.save(demande);
        Statut StatutParDefaut = statutRepository.findById(1).orElseThrow(() -> new RuntimeException("Statut introuvable"));

        DemandeStatut ds = new DemandeStatut();
        ds.setDemande(savedDemande);
        ds.setStatut(StatutParDefaut);
        demandeStatutRepository.save(ds);

        return savedDemande;
    }

    public void deleteDemande(String id){
        demandeRepository.deleteById(id);
    }
}
