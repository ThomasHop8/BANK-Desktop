package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.Pane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(Pane root) {
        logout.setOnAction(e ->{
            System.out.println("Je bent uitgelogd");
        });
        
        root.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister, logout, titleLabel, registerLabel, logoImageView, logoutImageView);
        
    }
}
