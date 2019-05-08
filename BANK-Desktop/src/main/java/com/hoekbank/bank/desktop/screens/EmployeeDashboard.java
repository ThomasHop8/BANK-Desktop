package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.GridPane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(GridPane root) {
        root.add(vbButtons, 0, 0);
    }
}
