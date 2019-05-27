package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.SplashScreenUI;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SplashScreen extends SplashScreenUI {

    private Timeline fade;

    public SplashScreen(Pane root) {
        setupMainUI();
        setupLogic();


        Button button = new Button("Test123");
        button.getStylesheets().add(getClass().getResource("/styles/Styles.css").toString());
        button.getStyleClass().addAll("green-button");
        button.setMinWidth(220);
        button.setMaxWidth(220);

        System.out.println(System.getProperty("os.name") + " " + System.getProperty("os.arch"));

        fade.playFromStart();
        fade.setOnFinished(event -> {
            Pane loginPane = new Pane();
            new LoginScreen(loginPane);
            ScenesController.setStage(loginPane);
        });

        root.getChildren().addAll(container);
    }

    private void setupLogic() {
        fade = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(container.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(container.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(3), new KeyValue(container.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(4), new KeyValue(container.opacityProperty(), 0))
        );
    }
}