package com.hoekbank.bank.desktop.resources;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * HabboBackButton
 * v1.0
 *
 * Created by Thomas Hopstaken on 27-05-2019
 **/
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
