package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EmployeeDashboard extends EmployeeDashboardUI {

    public EmployeeDashboard(Pane root) {
        setupLogin(RegisterState.EMPLOYEE, "Medewerker");

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

        dashboardPane.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister, logout,
                titleLabel, registerLabel, logoImageView, logoutImageView);

        pageContainer.getChildren().add(dashboardPane);
        root.getChildren().add(appContainer);
    }

    @Override
    protected Image getCoverImage() {
        return new Image("/images/background_covers/employee_dashboard.png");
    }

    @Override
    protected String getPageTitle() {
        return "DASHBOARD";
    }

    private void validate() {
        Pane validatePane = new Pane();
        new ValidateScreen(validatePane);
        ScenesController.setStage(validatePane);
    }

    private void setRegisterState(RegisterState registerState) {
        AppDataContainer.getInstance().setRegisterState(registerState);
    }
}
