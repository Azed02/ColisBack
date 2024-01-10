package com.example.colisexam.service;


import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Facteur;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.FacteurRepository;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacteurService {
    @Autowired
    FacteurRepository facteurRepository;
    @Autowired
    ColisRepository colisRepository;


    public void assignColisTofacteur( Long id_colis , Long id_facteur ){
        Optional<Facteur> facteurOptional = this.facteurRepository.findById(id_facteur);
        if(facteurOptional.isPresent()){
            Facteur facteur = facteurOptional.get();
            List<Colis> colisList = facteur.getColis();
            if(colisList ==null){
                colisList = new ArrayList<>();
            }
            Colis colis  = this.colisRepository.findById(id_colis).get();
            colisList.add(colis);
            facteur.setColis(colisList);
            colis.setFacteur(facteur);
            this.colisRepository.save(colis);
            this.facteurRepository.save(facteur);
        }
    }
}
