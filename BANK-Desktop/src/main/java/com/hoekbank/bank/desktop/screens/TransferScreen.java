/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.TransferScreenUI;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author kevin
 */
public class TransferScreen extends TransferScreenUI {
    public TransferScreen(Pane root){
        
                
        overboeken.setOnAction(e ->{
            String bedragString = invoerBedrag.getText();
            float bedrag = Float.parseFloat(bedragString);
            System.out.println(bedrag);
        });
        
        annuleren.setOnAction(e ->{
                        
            
        });
        
        root.getChildren().addAll(invoerReknr, overboeken, annuleren, titelLabel, reknrLabel, bedragLabel, 
                                    omschrijvingLabel, invoerBedrag, invoerOmschrijving);
    }
}
