/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.TransferScreenUI;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;

/**
 *
 * @author kevin
 */
public class TransferScreen extends TransferScreenUI {
    public TransferScreen(Pane root){
        
                
        overboeken.setOnAction(e ->{
            String bedragString = invoerBedrag.getText();
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');
            DecimalFormat format = new DecimalFormat("0.##");
            format.setDecimalFormatSymbols(symbols);
            try {
                float f = format.parse(bedragString).floatValue();
                System.out.println(f);
            } catch (ParseException ex) {
                Logger.getLogger(TransferScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        annuleren.setOnAction(e ->{
                        
            
        });
        
        root.getChildren().addAll(invoerReknr, overboeken, annuleren, titelLabel, reknrLabel, bedragLabel, 
                                    omschrijvingLabel, invoerBedrag, invoerOmschrijving);
    }
}
