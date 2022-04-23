package com.example.springboot_grupparbete.Controllers;


import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/produkt")
public class ProduktController {

    private final ProduktRepository produktRepository;
    private final BeställningRepository beställningRepository;


    public ProduktController(ProduktRepository produktRepository, BeställningRepository beställningRepository) {

        this.produktRepository = produktRepository;
        this.beställningRepository = beställningRepository;
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

    @PostMapping("/post")
    public Beställning postBeställning(@RequestBody Beställning b) {
        beställningRepository.save(b);
        return b;
    }
}
