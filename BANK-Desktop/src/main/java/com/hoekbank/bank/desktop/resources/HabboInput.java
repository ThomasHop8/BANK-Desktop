package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.TextField;

/**
 * HabboInput
 * v1.0
 *
 * Created by Thomas Hopstaken on 27-05-2019
 **/
public class HabboInput extends TextField {

    public HabboInput() {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("grey-input");
    }

    public HabboInput(String title) {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("grey-input");

        this.setText(title);
    }
}
