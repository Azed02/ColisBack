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
