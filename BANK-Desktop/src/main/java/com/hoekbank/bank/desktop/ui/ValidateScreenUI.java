package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;

public abstract class ValidateScreenUI extends BaseScreen {

    public Button validateButton;

    @Override
    protected void setupMainUI() {
        validateButton = new Button("Controleren");
    }
}
