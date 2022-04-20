package com.example.springboot_grupparbete.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
