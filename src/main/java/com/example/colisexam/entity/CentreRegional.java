package com.example.colisexam.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("centre_regional")
public class CentreRegional extends CentrePostal{
    public CentreRegional(int numero, String nom, String rue, String quartier, String ville) {
        super(numero, nom, rue, quartier, ville);
    }

    public CentreRegional() {
    }
}
