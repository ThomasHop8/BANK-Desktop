package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(Pane root) {
        particulierRegister.setOnAction(e ->{
            GridPane validatePane = new GridPane();
            new ValidateScreen(validatePane);
            ScenesController.setStage(validatePane);
        });
        bedrijfRegister.setOnAction(e ->{
            System.out.println("Bedrijf registeren");
        });
        gemachtigdeRegister.setOnAction(e ->{
            System.out.println("Gemachtigde registeren");
        });
        logout.setOnAction(e -> logout());

        root.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister, logout, 
                titleLabel, registerLabel, logoImageView, logoutImageView);
        
    }

    private void logout() {
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}
