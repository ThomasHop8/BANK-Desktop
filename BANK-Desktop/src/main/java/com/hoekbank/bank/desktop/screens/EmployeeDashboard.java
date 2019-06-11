package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.EmployeeDashboardUI;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
/**
 *
 * @author Kevin
 */
public class EmployeeDashboard extends EmployeeDashboardUI {
    //Set EmployeeDashboard pane
    public EmployeeDashboard(Pane root) {
        setupLogin(RegisterState.EMPLOYEE, "Medewerker");
        //Eventhandler particulier registeren
        particulierRegister.setOnAction(e -> {
            setRegisterState(RegisterState.USER);
            validate();
        });
        //Eventhandler bedrijf registeren
        bedrijfRegister.setOnAction(e -> {
            setRegisterState(RegisterState.COMPANY);
            validate();
        });
        //Eventhandler gemachtigde registeren
        gemachtigdeRegister.setOnAction(e -> {
            setRegisterState(RegisterState.REPRESENTATIVE);
            validate();
        });

        dashboardPane.getChildren().addAll(particulierRegister, bedrijfRegister, gemachtigdeRegister,
                titleLabel, registerLabel, logoImageView);

        pageContainer.getChildren().add(dashboardPane);
        root.getChildren().add(appContainer);
    }
    //Set Hoekbank logo
    @Override
    protected Image getCoverImage() {
        return new Image("/images/background_covers/employee_dashboard.png");
    }
    //Set pagina titel
    @Override
    protected String getPageTitle() {
        return "DASHBOARD";
    }
    //Koppeling met validatePane
    private void validate() {
        Pane validatePane = new Pane();
        new ValidateScreen(validatePane);
        ScenesController.setStage(validatePane);
    }

    private void setRegisterState(RegisterState registerState) {
        AppDataContainer.getInstance().setRegisterState(registerState);
    }
}
