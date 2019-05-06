package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;

public abstract class RegisterScreenUI extends BaseScreen {

    public Button registerButton;

    @Override
    protected void setupMainUI() {
        registerButton = new Button("Registreren");
    }
}
