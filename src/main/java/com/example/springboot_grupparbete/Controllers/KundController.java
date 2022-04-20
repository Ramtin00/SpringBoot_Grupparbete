package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/kund")
public class KundController {


    private final KundRepository kundRepository;
    private final BeställningRepository beställningRepository;
    private final ProduktRepository produktRepository;

    public KundController(KundRepository kundRepository, BeställningRepository beställningRepository, ProduktRepository produktRepository) {
        this.kundRepository = kundRepository;
        this.beställningRepository = beställningRepository;
        this.produktRepository = produktRepository;
    }

    @PostMapping("")
    public String createKund(@RequestBody Kund nyKund) {
        kundRepository.save(nyKund);
        return "Saved: " + nyKund;
    }

    @GetMapping("/get")
    public Kund getKund(@RequestParam Long kundId) {
        return kundRepository.findById(kundId).get();
    }

    @GetMapping("{id}")
    public Optional<Kund> getKundById(@PathVariable Long id) {
        return kundRepository.findById(id);
    }

}