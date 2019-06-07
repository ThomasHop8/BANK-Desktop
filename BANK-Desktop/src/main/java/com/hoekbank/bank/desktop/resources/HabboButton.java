package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.Button;

/**
 * HabboButton
 * v1.0
 *
 * Created by Thomas Hopstaken on 27-05-2019
 **/
public class HabboButton extends Button {

    public HabboButton() {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("green-button");
    }
}
