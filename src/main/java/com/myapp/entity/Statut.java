package com.myapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Statut {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatut;

    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "statut")
    private List<DemandeStatut> demandeStatuts;

    public List<DemandeStatut> getDemandeStatuts() {
        return demandeStatuts;
    }

    public void setDemandeStatuts(List<DemandeStatut> demandeStatuts) {
        this.demandeStatuts = demandeStatuts;
    }

    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
