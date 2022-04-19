package com.example.springboot_grupparbete.Controllers;

import com.example.springboot_grupparbete.Models.Beställning;
import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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

    @RequestMapping("/hej")
    public Set<Beställning> sayHello() {
        Kund k = kundRepository.findById(1L).get();
        return k.getBeställning();
    }

    @GetMapping("/get")
    public Kund getKund(@RequestParam Long kundId) {
        return kundRepository.findById(kundId).get();
    }

}