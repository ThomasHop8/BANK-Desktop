package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;

public abstract class LoginScreenUI extends BaseScreen {

    public Button loginButton;

    @Override
    protected void setupMainUI() {
        loginButton = new Button("Login");
    }
}
