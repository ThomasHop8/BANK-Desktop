package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public abstract class RegisterScreenUI extends BaseScreen {

    public Button registerButton;
    public TextField txtnaam,txtstraatnaam,txtwoonplaats, txttelefoon,txthuisnummer, txtemail,txtpostcode;
    public Label lblnaam,lblstraatnaam,lblwoonplaats,lbltelefoon,lblhuisnummer, lblemail,lblpostcode;

    @Override
    protected void setupMainUI() {
        registerButton = new Button("Registreren");
        txtnaam = new TextField ("");
        txtstraatnaam = new TextField ("");
        txtwoonplaats = new TextField ("");
        txttelefoon = new TextField ("");
        txthuisnummer = new TextField ("");
        txtemail = new TextField ("");
        txtpostcode = new TextField ("");
        lblnaam = new Label ("Naam en Achternaam");
        lblstraatnaam = new Label ("Straatnaam");
        lblwoonplaats = new Label ("Woonplaats");
        lbltelefoon = new Label ("Telefoonnummer");
        lblhuisnummer = new Label ("Huisnummer");
        lblemail = new Label ("Email adres");
        lblpostcode = new Label ("Postcode");
      
    }
}