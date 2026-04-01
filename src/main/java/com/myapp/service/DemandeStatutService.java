package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.DemandeStatut;
import com.myapp.repository.DemandeStatutRepository;

@Service
public class DemandeStatutService {
    @Autowired
    private DemandeStatutRepository demandeStatutRepository;

    public List<DemandeStatut> getAllDemandeStatut(){
        return demandeStatutRepository.findAll();
    }

    public DemandeStatut getDemandeStatutById(Integer id){
        return demandeStatutRepository.findById(id).orElse(null);
    }
}
