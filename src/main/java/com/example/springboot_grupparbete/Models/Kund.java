package com.example.springboot_grupparbete.Models;

public class Kund {

    private Long id;
    private String namn;
    private String address;
    private String telNr;

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

    public Long getId() {
        return id;
    }
}
