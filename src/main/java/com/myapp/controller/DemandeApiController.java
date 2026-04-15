package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.dto.ClientDTO;
import com.myapp.dto.DemandeDTO;
import com.myapp.entity.Client;
import com.myapp.entity.Demande;
import com.myapp.repository.DemandeRepository;

@RestController
@RequestMapping("/api/demande")
public class DemandeApiController {

    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("/{id}")
    public DemandeDTO getDemande(@PathVariable String id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande introuvable"));

        DemandeDTO dto = new DemandeDTO();
        dto.setIdDemande(demande.getIdDemande());
        dto.setLieu(demande.getLieu());
        dto.setDistrict(demande.getDistrict());

        Client client = demande.getClient();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setNom(client.getNom());
        clientDTO.setContact(client.getContact());

        dto.setClient(clientDTO);

        return dto;
    }
}
