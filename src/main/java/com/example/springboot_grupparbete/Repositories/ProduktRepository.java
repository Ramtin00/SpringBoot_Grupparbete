package com.example.springboot_grupparbete.Repositories;

import com.example.springboot_grupparbete.Models.Produkt;
import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository <Produkt, Long> {
}
