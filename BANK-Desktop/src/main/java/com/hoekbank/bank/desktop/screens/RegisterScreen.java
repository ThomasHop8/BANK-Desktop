package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.RegisterScreenUI;
import javafx.scene.layout.Pane;

public class RegisterScreen extends RegisterScreenUI {

    public RegisterScreen(Pane root) {
        root.getChildren().addAll(registerButton);
    }
}
