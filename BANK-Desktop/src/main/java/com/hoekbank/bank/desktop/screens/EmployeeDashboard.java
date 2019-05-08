package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(GridPane root) {
        logout.setOnAction(e ->{
            System.out.println("Je bent uitgelogd");
        });
        
        root.setPadding(new Insets(20));
        root.setVgap(5);
        root.setHgap(5);
        
        root.add(vbLogo, 0, 0);
        root.add(titleLabel, 1, 0, 5, 1);
        root.add(registerLabel, 0, 1);
        root.add(particulierRegister, 0, 2);
        root.add(bedrijfRegister, 1 ,2);
        root.add(gemachtigdeRegister, 2, 2);
        root.add(logout, 6, 0);
        
    }
}
