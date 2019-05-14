package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(Pane root) {
        particulierRegister.setOnAction(e -> {
            setRegisterState(RegisterState.USER);
            validate();
        });

        bedrijfRegister.setOnAction(e -> {
            setRegisterState(RegisterState.COMPANY);
            validate();
        });

        gemachtigdeRegister.setOnAction(e -> {
            setRegisterState(RegisterState.REPRESENTATIVE);
            validate();
        });

        logout.setOnAction(e -> logout());

        root.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister, logout, 
                titleLabel, registerLabel, logoImageView, logoutImageView);
    }

    private void validate() {
        GridPane validatePane = new GridPane();
        new ValidateScreen(validatePane);
        ScenesController.setStage(validatePane);
    }

    private void logout() {
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }

    private void setRegisterState(RegisterState registerState) {
        AppDataContainer.getInstance().setRegisterState(registerState);
    }
}
