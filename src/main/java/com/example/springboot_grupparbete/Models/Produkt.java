package com.example.springboot_grupparbete.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String märke;
    private String färg;
    private String storlek;
    private int antalILager;

    public Produkt(){}

    public Produkt(String märke, String färg, String storlek, int antalILager) {
        this.märke = märke;
        this.färg = färg;
        this.storlek = storlek;
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

    public void setAntalILager(int antalILager) {
        this.antalILager = antalILager;
    }

    public Long getId() {
        return id;
    }
}
