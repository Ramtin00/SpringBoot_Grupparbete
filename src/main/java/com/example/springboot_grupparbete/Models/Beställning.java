package com.example.springboot_grupparbete.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Beställning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern="dd/MM/yyyy/HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime datum = LocalDateTime.now();

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

    private int antalProdukter;

    public Beställning() {
    }

    public Beställning(int totalPris, int antalProdukter) {
        this.totalPris = totalPris;
        this.antalProdukter = antalProdukter;
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

    public int getAntalProdukter() {
        return antalProdukter;
    }

    public void setAntalProdukter(int antalProdukter) {
        this.antalProdukter = antalProdukter;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public Kund getKund() {
        return kund;
    }

    public void setKund(Kund kund) {
        this.kund = kund;
    }


    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public Set<Produkt> getProdukter() {
        return produkter;
    }
}
