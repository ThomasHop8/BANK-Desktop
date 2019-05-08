/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author kevin
 */
public abstract class EmployeeDashboardUI extends BaseScreen {
    
    public Button particulierRegister, bedrijfRegister, gemachtigdeRegister;
    public Label titleLabel, registerLabel;
    public VBox vbButtons;
    
    @Override
    protected void setupMainUI() {
        particulierRegister = new Button("Particulier registeren");
        bedrijfRegister = new Button("Bedrijf registeren");
        gemachtigdeRegister = new Button("Gemachtigde registeren");
        titleLabel = new Label("Welkom Medewerker123");
        registerLabel = new Label("Registreer acties");
        
        particulierRegister.setMaxWidth(Double.MAX_VALUE);
        bedrijfRegister.setMaxWidth(Double.MAX_VALUE);
        gemachtigdeRegister.setMaxWidth(Double.MAX_VALUE);
        particulierRegister.setPrefHeight(50);
        bedrijfRegister.setPrefHeight(50);
        gemachtigdeRegister.setPrefHeight(50);
        
        
    }
}
