package com.hoekbbank.bank.desktop.screens;

import com.hoekbbank.bank.desktop.helpers.JerseyClientPost;
import com.hoekbbank.bank.desktop.ui.LoginScreenUI;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginScreen extends LoginScreenUI {

    public void start(Stage primaryStage) {
        btn.setOnAction(event -> System.out.println("Hello World"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        JerseyClientPost post = new JerseyClientPost();
    }

}
