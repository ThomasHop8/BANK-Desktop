package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.SplashScreenUI;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SplashScreen extends SplashScreenUI {

    private Timeline fade;

    public SplashScreen(Pane root) {
        setupLogic();

        System.out.println(System.getProperty("os.name") + " " + System.getProperty("os.arch"));

        fade.playFromStart();
        fade.setOnFinished(event -> {
            GridPane employeeDashboardPane = new GridPane();
            new EmployeeDashboard(employeeDashboardPane);
            ScenesController.setStage(employeeDashboardPane);
        });

        root.setStyle("-fx-background-color: #000");
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