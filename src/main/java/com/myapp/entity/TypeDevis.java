package com.myapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "typedevis")
public class TypeDevis {
    @Id
    @Column(name = "id_typedevis")
    private int idTypeDevis;

    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "typeDevis")
    private List<Devis> devis;

    public List<Devis> getDevis() {
        return devis;
    }

    public void setDevis(List<Devis> devis) {
        this.devis = devis;
    }

    public int getIdTypeDevis() {
        return idTypeDevis;
    }

    public void setIdTypeDevis(int idTypeDevis) {
        this.idTypeDevis = idTypeDevis;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
