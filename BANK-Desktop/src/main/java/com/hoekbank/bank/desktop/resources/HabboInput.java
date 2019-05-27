package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.TextField;

public class HabboInput extends TextField {

    public HabboInput() {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("grey-input");
    }
}
