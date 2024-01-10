package com.example.colisexam.controller;

import com.example.colisexam.entity.Colis;
import com.example.colisexam.entity.Facteur;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.repository.FacteurRepository;
import com.example.colisexam.service.ColisService;
import com.example.colisexam.service.FacteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/facteur")
public class FacteurController {
    @Autowired
    FacteurRepository facteurRepository;
    @Autowired
    FacteurService facteurService;


    @GetMapping("/")
    public List<Facteur> getAllFacteur(){
        return this.facteurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Facteur getFacteurById(@PathVariable Long id)
    {
        return this.facteurRepository.findById(id)
                .orElse(null);
    }

    @PostMapping("")
    public void createFcateur(@RequestBody Facteur facteur){
        this.facteurRepository.save(facteur);
    }

    @DeleteMapping("/{id}")
    public void deleteFacteur(@PathVariable Long id){
        this.facteurRepository.deleteById(id);
    }


    @PostMapping("/{id_colis}/facteur/{id_facteur}")
    public void assignColisToFacteur(@PathVariable Long id_colis , @PathVariable Long id_facteur){
        this.facteurService.assignColisTofacteur(id_colis,id_facteur);
    }
}
