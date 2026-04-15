package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.entity.Client;
import com.myapp.entity.Demande;
import com.myapp.service.ClientService;
import com.myapp.service.DemandeService;

@Controller
@RequestMapping("/demandes")
public class DemandeController {
    
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public String listDemande(Model model){
        model.addAttribute("demandes", demandeService.getAllDemande());
        return "demandes/list";
    }


    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("demande", new Demande());
        model.addAttribute("clients", clientService.getAllClients());
        return "demandes/form";
    }

    @PostMapping("/save")
    public String createDemande(@ModelAttribute Demande demande){
        Client client = clientService.getClientById(demande.getClient().getIdClient());
        demande.setClient(client);
        demandeService.saveDemande(demande);
        return "redirect:/demandes";
    }

    @GetMapping("/edit/{id}")
    public String editDemande(@PathVariable String id, Model model){
        model.addAttribute("demande", demandeService.getDemandeById(id));
        return "demandes/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDemande(@PathVariable String id){
        demandeService.deleteDemande(id);
        return "redirect:/demandes";
    }
}
