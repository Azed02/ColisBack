package com.example.colisexam.service;

import com.example.colisexam.entity.CentrePostal;
import com.example.colisexam.entity.Facteur;
import com.example.colisexam.entity.Habitant;
import com.example.colisexam.repository.CentrePostalRepository;
import com.example.colisexam.repository.FacteurRepository;
import com.example.colisexam.repository.HabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CentrePostalService {
    @Autowired
    HabitantRepository habitantRepository;

    @Autowired
    CentrePostalRepository centrePostalRepository;

    @Autowired
    FacteurRepository facteurRepository;

    public void assignHabitanToCentre(Long id_habitant,int numero_centre){
        Optional<CentrePostal> centrePostalOp =this.centrePostalRepository.findById(numero_centre);
        if(centrePostalOp.isPresent()){
            CentrePostal centrePostal = centrePostalOp.get();
            List<Habitant> habitants =centrePostal.getHabitants();
            if (habitants==null){
                habitants= new ArrayList<>();
            }
            Habitant habitant = this.habitantRepository.findById(id_habitant).get();
            habitants.add(habitant);
            centrePostal.setHabitants(habitants);
            habitant.setCentrePostal(centrePostal);
            this.centrePostalRepository.save(centrePostal);
            this.habitantRepository.save(habitant);
        }
    }


    public void assignFacteurToCenter(Long id_facteur,int numero_center){
        Optional<CentrePostal> centrePostalOp = this.centrePostalRepository.findById(numero_center);
        if(centrePostalOp.isPresent()){
            CentrePostal centrePostal = centrePostalOp.get();
            List<Facteur> facteurs = centrePostal.getFacteurs();
            if(facteurs==null){
                facteurs= new ArrayList<>();
            }
            Facteur facteur  = this.facteurRepository.findById(id_facteur).get();
            facteurs.add(facteur);
            centrePostal.setFacteurs(facteurs);
            facteur.setCentrePostal(centrePostal);
            this.centrePostalRepository.save(centrePostal);
        }
    }
}
