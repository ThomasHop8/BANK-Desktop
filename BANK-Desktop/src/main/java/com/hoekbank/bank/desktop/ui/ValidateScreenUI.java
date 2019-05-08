package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.*;

public abstract class ValidateScreenUI extends BaseScreen {

    public Button btnRegistreren, btnAfwijzen;
    public TextField txtBsn;
    public TextArea txtRedenAfwijzing;
    public Label lbTitle,lbBsn, lbBkrGoedkeuren, lbZwarteLijst, lbRedenAfwijzing;
    public CheckBox checkBkrJa, checkBkrNee, checkZwrtLstJa, checkZwrtLstNee;

    /**
     * @author Chahine
     */

    @Override
    protected void setupMainUI() {

        // Buttons
        btnRegistreren = new Button("Registreren >");
        btnAfwijzen = new Button("< Afwijzen");
        // TextFields
        txtBsn = new TextField();
        txtBsn.setPromptText("123456789");
        txtRedenAfwijzing = new TextArea();
        txtRedenAfwijzing.setPromptText("Reden?");
        // Labels
        lbTitle = new Label("Gebruiker Controleren");
        lbBsn = new Label("BSN / KvK");
        lbBkrGoedkeuren = new Label ("BKR Afgekeurd?");
        lbZwarteLijst = new Label("Aanwezig in zwarte lijst?");
        lbRedenAfwijzing = new Label("Reden van afwijzing?");
        // CheckBoxes
        checkBkrJa = new CheckBox("Ja");
        checkBkrNee = new CheckBox("Nee");
        checkZwrtLstJa = new CheckBox("Ja");
        checkZwrtLstNee = new CheckBox("Nee");



    }
}
