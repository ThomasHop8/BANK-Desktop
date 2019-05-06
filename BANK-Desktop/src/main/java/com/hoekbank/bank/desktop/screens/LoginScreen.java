package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.LoginScreenUI;
import javafx.scene.layout.Pane;

public class LoginScreen extends LoginScreenUI {

    public LoginScreen(Pane root) {
        root.getChildren().addAll(loginButton);
    }
}
