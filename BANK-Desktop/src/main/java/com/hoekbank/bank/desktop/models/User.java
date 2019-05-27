package com.hoekbank.bank.desktop.models;

import com.google.gson.Gson;

public class User {

    private String fullname;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String telefoonnummer;
    private String email;
    private String password;
    private String bsn;

    public User() {

    }

    // Getter methods
    public String getFullname() {
        return fullname;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBsn() {
        return bsn;
    }


    // Setter Methods
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public String serialize() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    static public User create(String serializedData) {
        Gson gson = new Gson();
        return gson.fromJson(serializedData, User.class);
    }
}