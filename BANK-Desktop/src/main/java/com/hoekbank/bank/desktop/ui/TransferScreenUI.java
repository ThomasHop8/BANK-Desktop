/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kevin
 */
public abstract class TransferScreenUI extends BaseScreen {
    public Button overboeken, annuleren;
    public Label titelLabel, reknrLabel, bedragLabel, omschrijvingLabel;
    public TextField invoerReknr, invoerBedrag;
    public TextArea invoerOmschrijving;
    
    @Override
    protected void setupMainUI() {
        overboeken = new Button("Overboeken");
        annuleren = new Button("Annuleren");
        
        titelLabel = new Label("OVERBOEKEN");
        reknrLabel = new Label("REKENINGNUMMER");
        bedragLabel = new Label("BEDRAG (in euro's)");
        omschrijvingLabel = new Label("OMSCHRIJVING (optioneel)");
        
        invoerReknr = new TextField();
        invoerReknr.setPromptText("080.00.0.000");
        
        invoerBedrag = new TextField();
        invoerBedrag.setPromptText("€5000,95");
        
        invoerOmschrijving = new TextArea();
        
        
        invoerReknr.relocate(360, 303);
        overboeken.relocate(1058, 641);
        annuleren.relocate(1058, 641);
        titelLabel.relocate(548, 193);
        reknrLabel.relocate(360, 262);
        bedragLabel.relocate(822, 262);
        omschrijvingLabel.relocate(362, 402);
        invoerBedrag.relocate(822, 303);
        invoerOmschrijving.relocate(362, 435);
        
    }
}
