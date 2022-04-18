package com.example.springboot_grupparbete;

import com.example.springboot_grupparbete.Models.Kund;
import com.example.springboot_grupparbete.Repositories.KundRepository;
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
}
