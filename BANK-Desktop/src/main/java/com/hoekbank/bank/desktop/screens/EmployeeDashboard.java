package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.GridPane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(GridPane root) {
        root.setVgap(5);
        root.setHgap(5);
        
        
        root.add(titleLabel, 0, 0);
        root.add(registerLabel, 0, 1);
        root.add(particulierRegister, 1, 2);
        root.add(bedrijfRegister, 2, 2);
        root.add(gemachtigdeRegister, 3, 2);
    }
}
