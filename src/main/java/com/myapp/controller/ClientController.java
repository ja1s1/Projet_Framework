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
import com.myapp.service.ClientService;


@Controller
@RequestMapping("/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping
    public String listClient(Model model){
        model.addAttribute("clients", clientService.getAllClients());
        return "clients/list";
    }

    @GetMapping("/new")
    public String createForm(Model model){
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable Integer id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "clients/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
        return "redirect:/clients";
    }   
}
