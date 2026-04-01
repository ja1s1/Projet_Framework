package com.myapp.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.entity.Demande;
import com.myapp.entity.DemandeStatut;
import com.myapp.entity.DetailDevis;
import com.myapp.entity.Devis;
import com.myapp.entity.Statut;
import com.myapp.entity.TypeDevis;
import com.myapp.repository.DemandeRepository;
import com.myapp.repository.DemandeStatutRepository;
import com.myapp.repository.DetailDevisRepository;
import com.myapp.repository.DevisRepository;
import com.myapp.repository.StatutRepository;
import com.myapp.repository.TypeDevisRepository;
import com.myapp.service.DemandeStatutService;
import com.myapp.service.StatutService;



@Controller
@RequestMapping("/devis")
public class DevisController {

    @Autowired private DemandeRepository demandeRepo;
    @Autowired private DevisRepository devisRepo;
    @Autowired private DetailDevisRepository detailRepo;
    @Autowired private TypeDevisRepository typeRepo;
    @Autowired protected DemandeStatutService demandeStatutService;
    @Autowired protected StatutRepository statutRepository;
    @Autowired protected DemandeStatutRepository demandeStatutRepository;

    @GetMapping
    public String showForm(Model model) {
    model.addAttribute("devis", new Devis());
    model.addAttribute("demandes", demandeRepo.findAll());
    model.addAttribute("type", typeRepo.findAll());
    return "devis/form"; // form.html
}

@PostMapping("/create")
public String createDevis(
        @RequestParam String idDemande,
        @RequestParam Integer typeDevis,
        @RequestParam("details[].libelle") List<String> libelles,
        @RequestParam("details[].pu") List<Double> puList,
        @RequestParam("details[].qte") List<Integer> qteList
) {
    Demande demande = demandeRepo.findById(idDemande)
            .orElseThrow(() -> new RuntimeException("Demande introuvable"));

    Devis devis = new Devis();
    TypeDevis type = typeRepo.findById(typeDevis).orElseThrow();
    devis.setTypeDevis(type);

    List<DetailDevis> details = new ArrayList<>();
    double total = 0;

    for (int i = 0; i < libelles.size(); i++) {
        DetailDevis d = new DetailDevis();
        d.setLibelle(libelles.get(i));
        d.setPu(puList.get(i));
        d.setQte(qteList.get(i));
        d.setDevis(devis);
        total += d.getPu() * d.getQte();
        details.add(d);
    }

    devis.setDetailDevis(details);
    devis.setMontantTotal(total);
    devisRepo.save(devis);

    demande.setDevis(devis);
    demandeRepo.save(demande);

    // Statut
    DemandeStatut statut = new DemandeStatut();
    Statut statutEtude = statutRepository.findById(2).orElseThrow();
    Statut statutForrage = statutRepository.findById(3).orElseThrow();
    statut.setDemande(demande);

    if (typeDevis == 1) {
        statut.setStatut(statutEtude);
    } else {
        statut.setStatut(statutForrage);
    }

    statut.setDateDemande(LocalDateTime.now());
    demandeStatutRepository.save(statut);

    return "redirect:/devis";
}
}
