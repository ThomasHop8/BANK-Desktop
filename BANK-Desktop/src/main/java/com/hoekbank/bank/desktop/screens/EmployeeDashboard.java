package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.Pane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(Pane root) {
        particulierRegister.setOnAction(e ->{
            System.out.println("Particuliere klant registeren");
        });
        bedrijfRegister.setOnAction(e ->{
            System.out.println("Bedrijf registeren");
        });
        gemachtigdeRegister.setOnAction(e ->{
            System.out.println("Gemachtigde registeren");
        });
        logout.setOnAction(e ->{
            System.out.println("Je bent uitgelogd");
        });
        
        
        root.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister, logout, 
                titleLabel, registerLabel, logoImageView, logoutImageView);
        
    }
}
