package com.example.colisexam.controller;


import com.example.colisexam.entity.CentrePostal;
import com.example.colisexam.entity.Colis;
import com.example.colisexam.repository.CentrePostalRepository;
import com.example.colisexam.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre")
public class CentrePostalController {
    @Autowired
    CentrePostalRepository centrePostalRepository;


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

    @PostMapping("")
    public CentrePostal createColis(@RequestBody CentrePostal centrePostal){
        System.out.println(centrePostal);
        return this.centrePostalRepository.save(centrePostal);
    }

    @DeleteMapping("/{id}")
    public void deleteColis(@PathVariable int id){
        this.centrePostalRepository.deleteById(id);
    }

}
