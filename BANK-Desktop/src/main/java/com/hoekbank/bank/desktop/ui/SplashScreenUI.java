package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.MainApp;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

/**
 * SplashScreenUI
 * v2.1
 *
 * Created by Thomas Hopstaken on 04-01-2019
 **/
public abstract class SplashScreenUI {

    protected FlowPane container;

    private Image image;
    private ImageView imageView;

    protected void setupMainUI() {
        container = new FlowPane();
        image = new Image("/images/logo.png");
        imageView = new ImageView();

        imageView.setImage(image);

        container.setOpacity(0);
        container.relocate((float) MainApp.screenWidth / 2 - 150, 210);
        container.getChildren().add(imageView);
    }

}