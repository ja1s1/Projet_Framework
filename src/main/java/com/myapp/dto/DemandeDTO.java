package com.myapp.dto;

public class DemandeDTO {
    private String idDemande;
    private String lieu;
    private String district;
    private ClientDTO client;

    // getters et setters
    public String getIdDemande() { return idDemande; }
    public void setIdDemande(String idDemande) { this.idDemande = idDemande; }

    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public ClientDTO getClient() { return client; }
    public void setClient(ClientDTO client) { this.client = client; }
}
