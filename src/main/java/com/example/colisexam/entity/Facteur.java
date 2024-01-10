package com.example.colisexam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;

import java.util.List;

@Entity
public class Facteur extends  Personne{

    @OneToMany(mappedBy = "facteur")
    private List<Colis> colis;

    public List<Colis> getColis() {
        return colis;
    }

    public void setColis(List<Colis> colis) {
        this.colis = colis;
    }

    public CentrePostal getCentrePostal() {
        return centrePostal;
    }

    public void setCentrePostal(CentrePostal centrePostal) {
        this.centrePostal = centrePostal;
    }

    @ManyToOne()
    @JoinColumn(name="numero")
    @JsonIgnore
    private CentrePostal centrePostal;

    public Facteur(Long id, String nom, String prenom, String rue, String quartier, String ville) {
        super(id, nom, prenom, rue, quartier, ville);
    }

    public Facteur() {
    }
}
