package com.example.springboot_grupparbete.Controllers;


import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produkt")
public class ProduktController {

    private final ProduktRepository produktRepository;


    public ProduktController(ProduktRepository produktRepository) {

        this.produktRepository = produktRepository;
    }

    @GetMapping("")
    public Iterable<Produkt> getAllProdukter() {
        return produktRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produkt> getProduktById(@PathVariable Long id) {
        return produktRepository.findById(id);
    }

    @RequestMapping("/get")
    public Produkt getById(@RequestParam Long id){
        return produktRepository.findById(id).get();
    }
}
