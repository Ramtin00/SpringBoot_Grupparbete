package com.example.springboot_grupparbete.Controllers;


import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.BeställningRepository;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produkt")
public class ProduktController {

    private final BeställningRepository beställningRepository;
    private final KundRepository kundRepository;
    private final ProduktRepository produktRepository;


    public ProduktController(BeställningRepository beställningRepository, KundRepository kundRepository, ProduktRepository produktRepository) {
        this.beställningRepository = beställningRepository;
        this.kundRepository = kundRepository;
        this.produktRepository = produktRepository;
    }

    @RequestMapping("/get")
    public Produkt getById(@RequestParam Long id){
        return produktRepository.findById(id).get();
    }
}
