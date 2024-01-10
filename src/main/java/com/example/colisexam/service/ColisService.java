package com.example.colisexam.service;

import com.example.colisexam.entity.CentrePostal;
import com.example.colisexam.entity.Colis;
import com.example.colisexam.repository.CentrePostalRepository;
import com.example.colisexam.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColisService {
    @Autowired
    ColisRepository colisRepository;

    @Autowired
    CentrePostalRepository centrePostalRepository;


    public void assignColisToCentre(Long id_Colis , int id_Centre){
        Optional<Colis> colisOptional = this.colisRepository.findById(id_Colis);
        Optional<CentrePostal> centrePostalOptional = this.centrePostalRepository.findById(id_Centre);
        if (colisOptional.isPresent() && centrePostalOptional.isPresent()){
            Colis colis = colisOptional.get();
            CentrePostal centrePostal = centrePostalOptional.get();
            List<Colis> colisList = centrePostal.getColisList();
            List<CentrePostal> centrePostalList  = colis.getCentrePostals();
            if(colisList==null){
                colisList = new ArrayList<>();
            }
            if(centrePostalList==null){
                centrePostalList = new ArrayList<>();
            }
            colisList.add(colis);
            centrePostalList.add(centrePostal);
            colis.setCentrePostals(centrePostalList);
            centrePostal.setColisList(colisList);
            this.centrePostalRepository.save(centrePostal);
            this.colisRepository.save(colis);
        }
    }
}
