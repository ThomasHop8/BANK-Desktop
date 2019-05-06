package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import com.hoekbank.bank.desktop.MainApp;
import javafx.scene.layout.FlowPane;

public abstract class SplashScreenUI extends BaseScreen {

    protected FlowPane container;

    @Override
    protected void setupMainUI() {
        // TODO: Logo & credits

        container = new FlowPane();

        container.setOpacity(0);
        container.relocate((float) MainApp.screenWidth / 2 - 350, 210);
        container.setVgap(10);
    }
}