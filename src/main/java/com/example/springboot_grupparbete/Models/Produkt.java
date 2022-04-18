package com.example.springboot_grupparbete.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String märke;
    private String färg;
    private String storlek;
    private int pris;
    private int antalILager;

    @ManyToMany(mappedBy = "produkter")
    private Set<Beställning> beställning = new HashSet<>();

    /*@ManyToOne
    @JoinTable(name = "beställning_produkt",
            joinColumns = @JoinColumn(name = "produkt_id", referencedColumnName = "id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "beställning_id", referencedColumnName = "id", nullable = true))
    private Beställning beställning;*/


    public Produkt(){}

    public Produkt(String märke, String färg, String storlek, int pris, int antalILager) {
        this.märke = märke;
        this.färg = färg;
        this.storlek = storlek;
        this.pris = pris;
        this.antalILager = antalILager;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    public String getStorlek() {
        return storlek;
    }

    public void setStorlek(String storlek) {
        this.storlek = storlek;
    }

    public int getAntalILager() {
        return antalILager;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public void setAntalILager(int antalILager) {
        this.antalILager = antalILager;
    }

    public Set<Beställning> getBeställning() {
        return beställning;
    }

    public Long getId() {
        return id;
    }
}
