package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.Button;

public class HabboButton extends Button {

    public HabboButton() {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("green-button");
    }
}
