package com.example.colisexam.controller;


import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Habitant;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.HabitantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitant")
public class HabitantController {

    @Autowired
    HabitantRepository habitantRepository;


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

    @PostMapping("")
    public void createHabitant(@RequestBody Habitant habitant){
        this.habitantRepository.save(habitant);
    }

    @DeleteMapping("/{id}")
    public void deleteHabitant(@PathVariable Long id){
        this.habitantRepository.deleteById(id);
    }

}
