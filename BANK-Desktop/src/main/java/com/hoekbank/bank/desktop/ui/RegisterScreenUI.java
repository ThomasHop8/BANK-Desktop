/*
 * 
 * Auteur: Chris Gerlach & Rogier Rijsdijk
 */

package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class RegisterScreenUI extends BaseScreen {

    //In deze Class worden de UI-eenheden van RegisterScreen aangemaakt
	public GridPane registerGridPane;

    public Button registerButton, terugButton;
    public TextField txtnaam,txtstraatnaam,txtwoonplaats, txttelefoon,txthuisnummer, txtemail,txtpostcode;
    public Label lblnaam,lblstraatnaam,lblwoonplaats,lbltelefoon,lblhuisnummer, lblemail,lblpostcode;

    @Override
    protected void setupMainUI() {
        registerGridPane = new GridPane();

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
        terugButton = new Button ("Terug");
      
    }
}