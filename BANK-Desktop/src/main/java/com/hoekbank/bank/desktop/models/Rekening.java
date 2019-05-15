/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.models;

import javafx.scene.image.ImageView;

/**
 *
 * @author kevin
 */
public class Rekening {
    private String rekeningnummer, rekeninghouder, rekeningsoort;
    private double saldo;
    private ImageView icon;
    
    public Rekening(ImageView icon, String rekeningnummer, String rekeninghouder, String rekeningsoort, double saldo){
        this.rekeningnummer = converRekeningNummer(rekeningnummer);
        this.rekeninghouder = rekeninghouder;
        this.rekeningsoort = rekeningsoort;
        this.saldo = saldo;
        this.icon = icon;
    }
    public ImageView getIcon(){
        return icon;
    }
    
    public void setIcon(ImageView value){
        icon = value;
    }
    
    public String getRekeningnummer(){
        return rekeningnummer;
    }
    
    public void setRekeningnummer(String rekeningnummer){
        this.rekeningnummer = rekeningnummer;
    }
    
    public String getRekeninghouder(){
        return rekeninghouder;
    }
    
    public void setRekeninghouder(String rekeninghouder){
        this.rekeninghouder = rekeninghouder;
    }
    
    public String getRekeningsoort(){
        return rekeningsoort;
    }
    
    public void setRekeningsoort(String rekeningsoort){
        this.rekeningsoort = rekeningsoort;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }


    private String converRekeningNummer(String rekNr) {
        String newRekNr = rekNr;

        for (int i = 0; i < rekNr.length(); i++) {
            switch (i) {
                case 3:
                case 6:
                case 9:
                    newRekNr = new StringBuilder(newRekNr).insert(i, ".").toString();
            }
        }

        return newRekNr;
    }
}