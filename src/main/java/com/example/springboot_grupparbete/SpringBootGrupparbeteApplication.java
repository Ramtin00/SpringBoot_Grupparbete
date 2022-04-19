package com.example.springboot_grupparbete;

import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Models.Produkt;
import com.example.springboot_grupparbete.Repositories.KundRepository;
import com.example.springboot_grupparbete.Repositories.ProduktRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootGrupparbeteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGrupparbeteApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeDB(KundRepository kundRepository) {
        if (kundRepository.count() == 0) {
            return (args) -> {
                kundRepository.save(new Kund("Stewart", "Gatan 1", "123"));
                kundRepository.save(new Kund("Randy", "Vägen 24", "321"));
                kundRepository.save(new Kund("Harry", "PotterGatan 9 3/4", "1"));
                kundRepository.save(new Kund("Homer", "SimpsonGatan 1", "12312"));
            };
        }

        return null;
    }
    @Bean
    public CommandLineRunner initializeProdukt(ProduktRepository produktRepository) {
        if (produktRepository.count() == 0) {
            return (args) -> {
                produktRepository.save(new Produkt("Adidas", "Röd", "40", 500, 20));
                produktRepository.save(new Produkt("Nike", "Blå", "38", 400, 5));
                produktRepository.save(new Produkt("New Balance", "Gul", "42", 600, 20));
                produktRepository.save(new Produkt("Asics", "Svart", "39", 700, 20));
            };
        }

        return null;
    }
}
