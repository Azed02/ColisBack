package com.example.colisexam.controller;


import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Habitant;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.HabitantRepository;
import com.example.colisexam.service.HabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitant")
public class HabitantController {

    @Autowired
    HabitantRepository habitantRepository;

    @Autowired
    HabitantService habitantService;


    @GetMapping("/")
    public List<Habitant> getAllHabitant(){
        return this.habitantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Habitant geHabitantById(@PathVariable Long id)
    {
        return this.habitantRepository.findById(id)
                .orElse(null);
    }

    @PostMapping()
    public void createHabitant(@RequestBody Habitant habitant){
        this.habitantRepository.save(habitant);
    }

    @DeleteMapping("/{id}")
    public void deleteHabitant(@PathVariable Long id){
        this.habitantRepository.deleteById(id);
    }

    @PostMapping("/{id_emetteur}/colis/{id_colis}")
    public void assignColisToEmet(@PathVariable Long id_colis ,@PathVariable Long id_emetteur){
        this.habitantService.assignColisToEmetteur(id_colis,id_emetteur);
    }


    @PostMapping("/{id_recepteur}/col/{id_colis}")
    public void assignColisToRecep(@PathVariable Long id_colis ,@PathVariable Long id_recepteur){
        this.habitantService.assignColisToRecepteur(id_colis,id_recepteur);
    }

}
