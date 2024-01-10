package com.example.colisexam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Habitant  extends Personne{


    String email;


    String telephone;

    @OneToMany(mappedBy = "emetteur")
   private List<Colis> colis_emett;

    @OneToMany(mappedBy = "recepteur")
    private List<Colis> colis_rece;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public List<Colis> getColis_emett() {
        return colis_emett;
    }

    public void setColis_emett(List<Colis> colis_emett) {
        this.colis_emett = colis_emett;
    }

    public List<Colis> getColis_rece() {
        return colis_rece;
    }

    public void setColis_rece(List<Colis> colis_rece) {
        this.colis_rece = colis_rece;
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public void setCentrePostal(CentrePostal centrePostal) {
        this.centrePostal = centrePostal;
    }

    @ManyToOne()
    @JoinColumn(name = "numero_centre")
    @JsonIgnore
    private  CentrePostal centrePostal;

    public Habitant(Long id, String nom, String prenom, String rue, String quartier, String ville, String email, String telephone) {
        super(id, nom, prenom, rue, quartier, ville);
        this.email = email;
        this.telephone = telephone;
    }

    public Habitant(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }
    public Habitant(){
    }
}
