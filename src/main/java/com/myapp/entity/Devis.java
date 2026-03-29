package com.myapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "devis")
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devis")
    private int idDevis;

    @Column(name = "montant_total")
    private double montantTotal;

    @Column(nullable = false)
    private LocalDateTime dateDevis = LocalDateTime.now();

    @OneToMany(mappedBy = "devis")
    private List<DetailDevis> detailDevis;

    @ManyToOne
    @JoinColumn(name = "id_typedevis")
    private TypeDevis typeDevis;
    
    public int getIdDevis() {
        return idDevis;
    }


    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }


    public double getMontantTotal() {
        return montantTotal;
    }


    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }


    public LocalDateTime getDateDevis() {
        return dateDevis;
    }


    public void setDateDevis(LocalDateTime dateDevis) {
        this.dateDevis = dateDevis;
    }


    public List<DetailDevis> getDetailDevis() {
        return detailDevis;
    }


    public void setDetailDevis(List<DetailDevis> detailDevis) {
        this.detailDevis = detailDevis;
    }


    public TypeDevis getTypeDevis() {
        return typeDevis;
    }


    public void setTypeDevis(TypeDevis typeDevis) {
        this.typeDevis = typeDevis;
    }
}
