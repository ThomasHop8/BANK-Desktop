package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.LoginScreenUI;
import java.awt.event.KeyEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class LoginScreen extends LoginScreenUI {

    public LoginScreen(GridPane root) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        loginButton.setOnAction(e->{
            if (emailField.getText().isEmpty() && passwordField.getText().isEmpty()){
                errorAlert.setTitle("Geen gegevens ingevuld");
                errorAlert.setHeaderText("Alle velden zijn leeg");
                errorAlert.setContentText("Voer een e-mailadres en wachtwoord in");
                errorAlert.showAndWait();
            } 
            else if(emailField.getText().isEmpty()){
                errorAlert.setTitle("Geen e-mailadres ingevuld");
                errorAlert.setHeaderText("Er is geen e-mailadres ingevuld");
                errorAlert.setContentText("Voer een geldig e-mailadres in");
                errorAlert.showAndWait();
            }
            else if(passwordField.getText().isEmpty()){
                errorAlert.setTitle("Geen wachtwoord ingevuld");
                errorAlert.setHeaderText("Er is geen wachtwoord ingevuld");
                errorAlert.setContentText("Voer een wachtwoord in");
                errorAlert.showAndWait();
            }
            else{
                System.out.println("Je bent ingelogd");
            }
        });
               
        root.setAlignment(Pos.CENTER);       
        root.setVgap(5);
        root.setHgap(5);
        
        root.add(imageView, 0, 0);
        root.add(titleLabel, 0, 1);
        root.add(emailLabel, 0, 2);
        root.add(emailField, 0, 3);
        root.add(passwordLabel, 0, 4);
        root.add(passwordField, 0, 5);
        root.add(loginButton, 0, 6);
    }
}
