package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class HabboBackButton extends Button {

    public HabboBackButton() {
        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/images/back_button.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);

        this.getStylesheets().clear();
        this.setBackground(background);
        this.setMinWidth(90);
        this.setMinHeight(40);
    }
}
