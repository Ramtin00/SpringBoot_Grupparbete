package com.example.springboot_grupparbete.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

@Entity
public class Beställning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Datum
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Europe/Stockholm")
    private Date datum;

    private int totalPris;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kund_id", referencedColumnName = "id")
    private Kund kund;

    @ManyToMany
    @JoinTable(
            name = "beställning_produkt",
            joinColumns = @JoinColumn(name = "beställning_id"),
            inverseJoinColumns = @JoinColumn(name = "produkt_id")
    )
    private Set<Produkt> produkter = new HashSet<>();

    public Beställning() {}

    public Beställning(int totalPris, Set<Produkt> produkter, Kund kund){
        this.produkter = produkter;
        this.kund = kund;
    }

    public void setProdukter(Set<Produkt> produkter) {
        this.produkter = produkter;
    }

    public int getTotalPris() {
        return totalPris;
    }

    public void setTotalPris(int totalPris) {
        this.totalPris = totalPris;
    }

    public Long getId() {
        return id;
    }

    public Date getDatum() {
        return datum;
    }

    public Kund getKund() {
        return kund;
    }

    public void setKund(Kund kund) {
        this.kund = kund;
    }


    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Set<Produkt> getProdukter() {
        return produkter;
    }
}
