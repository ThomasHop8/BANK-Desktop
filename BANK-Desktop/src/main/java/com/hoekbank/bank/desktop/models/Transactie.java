package com.hoekbank.bank.desktop.models;

public class Transactie {
    private String datum, omschrijving;
    private double bedragIn, bedragUit, saldo;

    public Transactie(String datum, String omschrijving, double bedragIn, double bedragUit, double saldo) {
        this.datum = datum;
        this.omschrijving = omschrijving;
        this.bedragIn = bedragIn;
        this.bedragUit = bedragUit;
        this.saldo = saldo;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public double getBedragIn() {
        return bedragIn;
    }

    public void setBedragIn(double bedragIn) {
        this.bedragIn = bedragIn;
    }

    public double getBedragUit() {
        return bedragUit;
    }

    public void setBedragUit(double bedragUit) {
        this.bedragUit = bedragUit;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
