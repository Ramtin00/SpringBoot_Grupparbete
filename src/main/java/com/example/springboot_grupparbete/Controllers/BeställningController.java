package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/beställning")
public class BeställningController {

    private final BeställningRepository beställningRepository;
    private final KundRepository kundRepository;
    private final ProduktRepository produktRepository;

    public BeställningController(BeställningRepository beställningRepository, KundRepository kundRepository, ProduktRepository produktRepository) {
        this.beställningRepository = beställningRepository;
        this.kundRepository = kundRepository;
        this.produktRepository = produktRepository;
    }

    @GetMapping("")
    public Iterable<Beställning> getAllBeställningar() {
        return beställningRepository.findAll();
    }

    @GetMapping("/get")
    public Beställning getBeställning(@RequestParam Long id) {
        Beställning beställning = beställningRepository.findById(id).get();
        return beställning;
    }

    @PostMapping("/post")
    public Beställning postBeställning(@RequestParam Long kundId, @RequestParam int pris) {
        Kund k = kundRepository.findById(kundId).get();
        Beställning b = new Beställning();
        b.setKund(k);
        beställningRepository.save(b);
        return b;
    }
}