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
