package com.example.colisexam.service;


import com.example.colisexam.entity.CentrePostal;
import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Habitant;
import com.example.colisexam.repository.CentrePostalRepository;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.HabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabitantService {


    @Autowired
    ColisRepository colisRepository;
    @Autowired
    HabitantRepository habitantRepository;

    public void assignColisToEmetteur( Long id_colis , Long id_emetteur ){
        Optional<Habitant> emetteurOpt  = this.habitantRepository.findById(id_emetteur);
        if(emetteurOpt.isPresent()){
            Habitant emetteur = emetteurOpt.get();
            List<Colis> colisList = emetteur.getColis_emett();
            if(colisList==null){
                colisList = new ArrayList<>();
            }
            Colis colisEmis  = this.colisRepository.findById(id_colis).get();
            colisList.add(colisEmis);
            emetteur.setColis_emett(colisList);
            colisEmis.setEmetteur(emetteur);
            this.habitantRepository.save(emetteur);
            this.colisRepository.save(colisEmis);
        }
    }

    public void assignColisToRecepteur(Long id_Colis, Long id_recepteur ){
        Optional<Habitant> recepteurOpt = this.habitantRepository.findById(id_recepteur);
        if(recepteurOpt.isPresent()){
            Habitant recepteur = recepteurOpt.get();
            List<Colis> colisList = recepteur.getColis_rece();
            if(colisList==null){
                colisList=new ArrayList<>();
            }
            Colis colisRec = this.colisRepository.findById(id_Colis).get();
            colisList.add(colisRec);
            recepteur.setColis_rece(colisList);
            colisRec.setRecepteur(recepteur);
            this.colisRepository.save(colisRec);
            this.habitantRepository.save(recepteur);
        }
    }
}
