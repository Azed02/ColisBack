package com.example.colisexam.entity;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.DiscriminatorType.STRING;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_centre", discriminatorType=STRING, length=20)
@Entity
public class CentrePostal {


    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int numero;

    @Column(name = "nom")
    String nom;
    @Column(name = "rue")
    String rue;
    @Column(name = "quartier")
    String quartier;

    @Column(name = "ville")
    String ville;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public List<Habitant> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Habitant> habitants) {
        this.habitants = habitants;
    }

    public List<Facteur> getFacteurs() {
        return facteurs;
    }

    public void setFacteurs(List<Facteur> facteurs) {
        this.facteurs = facteurs;
    }

    public List<Colis> getColisList() {
        return colisList;
    }

    public void setColisList(List<Colis> colisList) {
        this.colisList = colisList;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public CentrePostal(int numero, String nom, String rue, String quartier, String ville) {
        this.numero = numero;
        this.nom = nom;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }
    public CentrePostal(){
    }

    @OneToMany(mappedBy = "centrePostal")
    private List<Habitant> habitants;

    @OneToMany(mappedBy = "centrePostal")
    private List<Facteur> facteurs;



    @ManyToMany(mappedBy = "centrePostals")
    private List<Colis> colisList;

}
