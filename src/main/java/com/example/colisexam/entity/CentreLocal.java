package com.example.colisexam.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("centre_local")
public class CentreLocal extends CentrePostal{
    public CentreLocal() {
    }

    public CentreLocal(int numero, String nom, String rue, String quartier, String ville) {
        super(numero, nom, rue, quartier, ville);
    }
}
