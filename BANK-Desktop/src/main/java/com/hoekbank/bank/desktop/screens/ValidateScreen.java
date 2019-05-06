package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.ValidateScreenUI;
import javafx.scene.layout.Pane;

public class ValidateScreen extends ValidateScreenUI {

    public ValidateScreen(Pane root) {
        root.getChildren().addAll(validateButton);
    }
}
