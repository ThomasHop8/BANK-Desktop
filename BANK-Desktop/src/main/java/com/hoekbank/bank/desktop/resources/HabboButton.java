package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

/**
 * HabboButton
 * v1.1
 *
 * Created by Thomas Hopstaken on 27-05-2019
 **/
public class HabboButton extends Button {

    public HabboButton() {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("green-button");
    }

    public HabboButton(String title) {
        this.getStylesheets().add("/styles/Styles.css");
        this.getStyleClass().add("green-button");

        this.setText(title);
        this.wrapTextProperty().setValue(true);
        this.textAlignmentProperty().set(TextAlignment.CENTER);
    }
}
