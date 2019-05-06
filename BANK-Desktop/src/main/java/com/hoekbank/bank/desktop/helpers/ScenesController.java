package com.hoekbank.bank.desktop.helpers;

import com.hoekbank.bank.desktop.MainApp;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * ScenesController
 * v1.1
 *
 * Created by Thomas Hopstaken on 23-10-2018
 **/
public class ScenesController {

    private static Stage primaryStage;
    private static HashMap<String, Scene> scenesMap = new HashMap<>();

    public ScenesController(Stage main) {
        primaryStage = main;
    }

    public void addScene(String name, Scene scene) {
        scenesMap.put(name, scene);
    }

    public void removeScreen(String name){
        scenesMap.remove(name);
    }

    public static void setStage(Pane pane) {
        Scene scene = new Scene(pane, MainApp.screenWidth, MainApp.screenHeight);
        primaryStage.setScene(scene);
    }

    static void setStage(String name) {
        primaryStage.setScene(scenesMap.get(name));
    }

    static Stage getStage() {
        return primaryStage;
    }
}