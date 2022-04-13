package com.example.springboot_grupparbete.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Beställning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    private int totalPris;

    @OneToMany(mappedBy = "beställning")
    private Set<Produkt> produkter = new HashSet<>();

}
