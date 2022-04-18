package com.example.springboot_grupparbete.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namn;
    private String address;
    private String telNr;

    @JsonIgnore
    @OneToMany(mappedBy = "kund")
    private Set<Beställning> beställning = new HashSet<>();

    public Kund(){}

    public Kund(String namn, String address, String telNr) {
        this.namn = namn;
        this.address = address;
        this.telNr = telNr;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }

    public Set<Beställning> getBeställning() {
        return beställning;
    }

    public Long getId() {
        return id;
    }
}
