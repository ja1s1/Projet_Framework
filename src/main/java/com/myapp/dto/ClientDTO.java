package com.myapp.dto;

public class ClientDTO {
    private int idClient;
    private String nom;
    private String contact;

    // getters et setters
    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
