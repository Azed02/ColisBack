package com.example.colisexam.controller;


import com.example.colisexam.entity.Colis;
import com.example.colisexam.repository.ColisRepository;
import com.example.colisexam.service.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colis")
public class ColisController {
    @Autowired
    ColisRepository colisRepository;

    @Autowired
    ColisService colisService;
    @GetMapping("/")
    public List<Colis> getAllColis(){
        return this.colisRepository.findAll();
    }

    @GetMapping("/{id}")
    public Colis getColisById(@PathVariable Long id)
    {
        return this.colisRepository.findById(id)
                .orElse(null);
    }

    @PostMapping("/add")
    public Colis createColis(@RequestBody Colis colis){
        return this.colisRepository.save(colis);
    }

    @DeleteMapping("/{id}")
    public void deleteColis(@PathVariable Long id){
        this.colisRepository.deleteById(id);
    }


    @PostMapping("/{id_colis}/centre/{id_centre}")
    public void assignColisToCentre(@PathVariable Long id_colis,@PathVariable int id_centre){
        this.colisService.assignColisToCentre(id_colis,id_centre);

    }
}
