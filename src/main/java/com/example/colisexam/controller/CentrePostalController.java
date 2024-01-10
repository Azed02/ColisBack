package com.example.colisexam.controller;


import com.example.colisexam.entity.CentrePostal;
import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Habitant;
import com.example.colisexam.repository.CentrePostalRepository;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.HabitantRepository;
import com.example.colisexam.service.CentrePostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre")
public class CentrePostalController {
    @Autowired
    CentrePostalRepository centrePostalRepository;
    @Autowired
    CentrePostalService centrePostalService;

    @Autowired
    HabitantRepository habitantRepository;

    @GetMapping("/")
    public List<CentrePostal> getAllCentre(){
        return this.centrePostalRepository.findAll();
    }

    @GetMapping("/{id}")
    public CentrePostal getCentreById(@PathVariable int id)
    {
        return this.centrePostalRepository.findById(id)
                .orElse(null);
    }

    @PostMapping
    public CentrePostal createCentre(@RequestBody CentrePostal centrePostal){
        System.out.println(centrePostal);
        return this.centrePostalRepository.save(centrePostal);
    }

    @DeleteMapping("/{id}")
    public void deleteCentre(@PathVariable int id){
        this.centrePostalRepository.deleteById(id);
    }

    @PostMapping("/assign/{id_habi}/to/{id_centre}")
    public void assignHabitantToCentre(@PathVariable Long id_habi,@PathVariable int id_centre){
        Habitant habitant = this.habitantRepository.findById(id_habi).get();
        CentrePostal centrePostal = this.centrePostalRepository.findById(id_centre).get();

        if(habitant ==null || centrePostal==null){
            System.out.println("they re null dude ");
        }
        else {
            System.out.println("found");
            this.centrePostalService.assignHabitanToCentre(id_habi,id_centre);}

    }

    @PostMapping("/facteur/{id_fact}/to/{id_centre}")
    public void assignFactToCenter(@PathVariable Long id_fact , @PathVariable int id_centre){
        this.centrePostalService.assignFacteurToCenter(id_fact,id_centre);
    }
}
