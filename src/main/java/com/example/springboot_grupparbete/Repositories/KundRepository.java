package com.example.springboot_grupparbete.Repositories;

import com.example.springboot_grupparbete.Models.Kund;
import org.springframework.data.repository.CrudRepository;

public interface KundRepository extends CrudRepository<Kund, Long> {
}
