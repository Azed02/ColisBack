package com.example.colisexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long numero;
    Date dateDepot;
    Date dateReception;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Habitant getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Habitant emetteur) {
        this.emetteur = emetteur;
    }

    public Habitant getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Habitant recepteur) {
        this.recepteur = recepteur;
    }

    public Colis(){}

    public Colis(Long numero, Date dateDepot, Date dateReception) {
        this.numero = numero;
        this.dateDepot = dateDepot;
        this.dateReception = dateReception;
    }


    @ManyToOne()
    @JoinColumn(name = "emetteur_id",referencedColumnName = "id")
            @JsonIgnore
    Habitant emetteur;

    @ManyToOne()
    @JoinColumn(name = "recepteur_id" ,referencedColumnName = "id")
            @JsonIgnore
    Habitant  recepteur;


    @ManyToOne()
    @JoinColumn(name = "livreur_id")
    @JsonIgnore
    private Facteur facteur;



    @ManyToMany()
    @JoinTable(
            name="Colis_Centres",
            joinColumns=
            @JoinColumn(name="centre_numero", referencedColumnName="numero"),
            inverseJoinColumns=
            @JoinColumn(name="colis_numero", referencedColumnName="numero")
    )
    private List<CentrePostal> centrePostals;
}
