package com.hoekbank.bank.desktop.screens;

import com.google.gson.JsonObject;
import com.hoekbank.bank.desktop.api.API;
import com.hoekbank.bank.desktop.api.APIService;
import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.Randompasswordgenerator;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.User;
import com.hoekbank.bank.desktop.ui.RegisterScreenUI;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

import javax.ws.rs.core.MultivaluedMap;
import java.util.Optional;

public class RegisterScreen extends RegisterScreenUI {

    private RegisterState registerState;
    public String userBSN;

    //Hier word het scherm aangemaakt
    public RegisterScreen(Pane root) {
        setupLogin(RegisterState.EMPLOYEE, "Medewerker");
        registerState = AppDataContainer.getInstance().getRegisterState();

        GridPane g = new GridPane();
        root.getChildren().addAll(registerButton, txtnaam, txtstraatnaam, txtwoonplaats, txttelefoon, txthuisnummer, txtemail, txtpostcode, lblnaam, lblstraatnaam, lblwoonplaats, lbltelefoon, lblhuisnummer, lblemail, lblpostcode);
        g.setHgap(1);
        g.setVgap(1);
        
        if (registerState == RegisterState.COMPANY)
        	lblnaam.setText("Bedrijfsnaam");

        //Met deze knop worden de volgende items toegevoegd
        registerButton.setOnAction(event -> {

            if (txtnaam.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }
            else if (txtnaam.getText().contains("1") || txtnaam.getText().contains("2") || txtnaam.getText().contains("3") || txtnaam.getText().contains("4") || txtnaam.getText().contains("5") || txtnaam.getText().contains("6") || txtnaam.getText().contains("7") || txtnaam.getText().contains("8") || txtnaam.getText().contains("9") || txtnaam.getText().contains("0")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldige naam in");
                alert.showAndWait();
            } else if (txttelefoon.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }

          else  if (!txttelefoon.getText().matches("\\d+")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldig telefoonnummer in");
                alert.showAndWait();
            } else if (txtstraatnaam.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }

           else if (txtstraatnaam.getText().contains("1") || txtstraatnaam.getText().contains("2") || txtstraatnaam.getText().contains("3") || txtstraatnaam.getText().contains("4") || txtstraatnaam.getText().contains("5") || txtstraatnaam.getText().contains("6") || txtstraatnaam.getText().contains("7") || txtstraatnaam.getText().contains("8") || txtstraatnaam.getText().contains("9") || txtstraatnaam.getText().contains("0")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldige straatnaam in");
                alert.showAndWait();
            } else if (txthuisnummer.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }

            else if (!txthuisnummer.getText().matches("\\w+")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldig huisnummer in!");
                alert.showAndWait();
            } else if (txtwoonplaats.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }

            else if (!txtwoonplaats.getText().matches("\\D+")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldige woonplaats in in");
                alert.showAndWait();
            } else if (txtpostcode.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }

          else  if (!txtpostcode.getText().matches("\\w+")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldige postcode in in");
                alert.showAndWait();
            }

          else  if (!txtemail.getText().contains("@") || !txtemail.getText().contains(".")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Vul aub een geldig emailadres in");
                alert.showAndWait();
            } else if (txtemail.getText().equals("")) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Foutmelding");
                alert.setHeaderText("LET OP!");
                alert.setContentText("Gelieve alle tekstvakken in te vullen!");
                alert.showAndWait();
            }
            
            else {
                registerUser();
            }

        });

        //Met deze knop gaat men terug naar het vorige scherm
        terugButton.setOnAction(event -> back());

        //Hier worden de items aan het scherm toegevoegd
        g.add(lblnaam, 450, 200);
        g.add(txtnaam, 450, 201);
        g.add(lbltelefoon, 451, 200);
        g.add(txttelefoon, 451, 201);
        g.add(lblstraatnaam, 450, 202);
        g.add(txtstraatnaam, 450, 203);
        g.add(lblhuisnummer, 451, 202);
        g.add(txthuisnummer, 451, 203);
        g.add(lblpostcode, 450, 204);
        g.add(lblwoonplaats, 451, 204);
        g.add(txtpostcode, 450, 205);
        g.add(txtwoonplaats, 451, 205);
        g.add(lblemail, 450, 206);
        g.add(txtemail, 450, 207);
        g.add(terugButton, 0, 8);
        g.add(registerButton, 451, 207);

        registerGridPane.getChildren().add(g);

        pageContainer.getChildren().add(registerGridPane);
        root.getChildren().add(appContainer);
    }

    //Hier word de inhoud omgezet naar het gebruikte design
    @Override
    protected Image getCoverImage() {
        return new Image("/images/background_covers/registration.png");
    }

    @Override
    protected String getPageTitle() {
        return "REGISTREREN";
    }

    @Override
    protected void back() {
        super.back();

        GridPane validatePane = new GridPane();
        new ValidateScreen(validatePane);
        ScenesController.setStage(validatePane);
    }

    public void registerUser() {
        User user = new User();
        user.setFullname(txtnaam.getText());
        user.setEmail(txtemail.getText());
        user.setBsn(userBSN);
        user.setHuisnummer(txthuisnummer.getText());
        user.setPassword(Randompasswordgenerator.generatePassword(10));
        user.setPostcode(txtpostcode.getText());
        user.setStraatnaam(txtstraatnaam.getText());
        user.setTelefoonnummer(txttelefoon.getText());
        user.setWoonplaats(txtwoonplaats.getText());

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("user", user.serialize());

        JsonObject apiResponse = API.getInstance().post(APIService.USER_CREATE, formData).getAsJsonObject();

        if(apiResponse.get("success") != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Registratie Voltooid!");
            alert.setContentText("De gebruiker " + user.getFullname() + " is succesvol aangemaakt. Een mail met het wachtwoord is naar " + user.getEmail() + " gestuurd.");

            Optional<ButtonType> result = alert.showAndWait();
            ButtonType button = result.orElse(ButtonType.CANCEL);
            if (button == ButtonType.OK) {
                Pane dashboardPane = new Pane();
                new EmployeeDashboard(dashboardPane);
                ScenesController.setStage(dashboardPane);
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Registratie Mislukt");
            alert.setContentText(apiResponse.get("message").getAsString());
            alert.showAndWait();
        }
    }
}
