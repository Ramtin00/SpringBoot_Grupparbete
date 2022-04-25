package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Beställning postBeställning(@RequestParam Long kundId, @RequestParam Long produktId) {
        Kund k = kundRepository.findById(kundId).get();
        Produkt p = produktRepository.findById(produktId).get();
        if (p.getAntalILager() <= 0){
                throw new IllegalStateException("Slut i lager!");
        }
        else {
            p.setAntalILager(p.getAntalILager() - 1);
            Beställning b = new Beställning();
            //Datum läggs automatiskt
            b.setTotalPris(p.getPris());
            b.setKund(k);
            b.getProdukter().add(p);
            produktRepository.save(p);
            beställningRepository.save(b);
            return b;
        }
    }

    @GetMapping("{kundid}")
    public Optional<Beställning> getBeställningById(@PathVariable Long kundid) {
        Kund k = kundRepository.findById(kundid).get();
        return beställningRepository.findById(k.getId());
    }
}