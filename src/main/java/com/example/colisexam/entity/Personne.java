package com.example.colisexam.entity;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    Long id;

    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;

    @Column(name = "rue")
    String rue;

    @Column(name = "quartier")
    String quartier;
    @Column(name = "ville")
    String ville;

    public Personne(Long id, String nom, String prenom, String rue, String quartier, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.quartier = quartier;
        this.ville = ville;
    }
    public Personne(){}
}

