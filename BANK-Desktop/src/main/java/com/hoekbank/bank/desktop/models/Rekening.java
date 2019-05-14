/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.models;

/**
 *
 * @author kevin
 */
public class Rekening {
    private String rekeningnummer, rekeninghouder, rekeningsoort;
    private double saldo;
    
    public Rekening(String rekeningnummer, String rekeninghouder, String rekeningsoort, double saldo){
        this.rekeningnummer = rekeningnummer;
        this.rekeninghouder = rekeninghouder;
        this.rekeningsoort = rekeningsoort;
        this.saldo = saldo;
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
}
