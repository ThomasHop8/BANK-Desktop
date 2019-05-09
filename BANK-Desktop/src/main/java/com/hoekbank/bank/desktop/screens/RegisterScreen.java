package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.RegisterScreenUI;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegisterScreen extends RegisterScreenUI {

    public RegisterScreen(GridPane root) {
        GridPane g = new GridPane();
        root.getChildren().addAll(registerButton, txtnaam, txtstraatnaam, txtwoonplaats, txttelefoon, txthuisnummer, txtemail, txtpostcode, lblnaam, lblstraatnaam, lblwoonplaats, lbltelefoon, lblhuisnummer, lblemail, lblpostcode);
        g.setHgap(1);
        g.setVgap(1);

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
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Goed gedaan");
                alert.setHeaderText("Lekker bezig pik!");
                alert.setContentText("Registratie is voltooid!");
                alert.showAndWait();
            }

        });

        terugButton.setOnAction(event -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Rogier heeft een kleine piemel");
            alert.setHeaderText("Ah oh!");
            alert.setContentText("Er is nog helemaal geen ander scherm, waar de fuck wil je naar terug?");

            alert.showAndWait();
        });

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

        root.getChildren().add(g);

    }
}
