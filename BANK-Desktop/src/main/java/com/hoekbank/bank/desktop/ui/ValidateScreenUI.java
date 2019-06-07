package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import com.hoekbank.bank.desktop.resources.HabboBackButton;
import com.hoekbank.bank.desktop.resources.HabboButton;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public abstract class ValidateScreenUI extends BaseScreen {

    public GridPane validateGridPane;

    public Button btnRegistreren, btnAfwijzen, btnTerug;
    public TextField txtBsn;
    public TextArea txtRedenAfwijzing;
    public Label lbTitle,lbBsn, lbBkrGoedkeuren, lbZwarteLijst, lbRedenAfwijzing;
    public CheckBox checkBkrJa, checkBkrNee, checkZwrtLstJa, checkZwrtLstNee;
    public Alert alertAfwijsWarning, alertAfwijsBevestigen, alertBtnRegisterBevestigen, alertBtnRegisterWarning;

    /**
     * @author Chahine
     */

    @Override
    protected void setupMainUI() {
        validateGridPane = new GridPane();

        // Buttons
        btnRegistreren = new HabboButton("Registreren >");
        btnAfwijzen = new HabboButton("Afwijzen");
        btnTerug = new HabboBackButton("< Terug");
        // TextFields
        txtBsn = new TextField();
        txtBsn.setPromptText("123456789");
        txtRedenAfwijzing = new TextArea();
        txtRedenAfwijzing.setPromptText("Reden?");
        // Labels
        lbTitle = new Label("Gebruiker Controleren");
        lbBsn = new Label("BSN");
        lbBkrGoedkeuren = new Label ("BKR Afgekeurd?");
        lbZwarteLijst = new Label("Aanwezig in zwarte lijst?");
        lbRedenAfwijzing = new Label("Reden van afwijzing?");
        // CheckBoxes
        checkBkrJa = new CheckBox("Ja");
        checkBkrNee = new CheckBox("Nee");
        checkZwrtLstJa = new CheckBox("Ja");
        checkZwrtLstNee = new CheckBox("Nee");
        // Alerts, Fout afhandelingen
        // Voor knop Afwijzen
        alertAfwijsWarning = new Alert(Alert.AlertType.WARNING);
        alertAfwijsBevestigen = new Alert(Alert.AlertType.CONFIRMATION);
        // Voor knop Registreren
        alertBtnRegisterWarning = new Alert(Alert.AlertType.WARNING);
        alertBtnRegisterBevestigen = new Alert(Alert.AlertType.CONFIRMATION);



    }
}
