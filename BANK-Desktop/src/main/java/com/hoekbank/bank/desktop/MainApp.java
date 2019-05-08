package com.hoekbank.bank.desktop;

import com.google.gson.JsonObject;
import com.hoekbank.bank.desktop.api.API;
import com.hoekbank.bank.desktop.api.APIService;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.User;
import com.hoekbank.bank.desktop.screens.SplashScreen;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.ws.rs.core.MultivaluedMap;

public class MainApp extends Application {

    public static double appVersionCode = 1.3;
    public static Integer screenWidth = 1280;
    public static Integer screenHeight = 720;

    @Override
    public void start(Stage primaryStage) {
        Pane splashPane = new Pane();
        new SplashScreen(splashPane);

        Scene splashScene = new Scene(splashPane, screenWidth, screenHeight);

        ScenesController screenController = new ScenesController(primaryStage);
        screenController.addScene("start", splashScene);

        primaryStage.setTitle("Hoekbank Desktop");
        primaryStage.setScene(splashScene);
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
        primaryStage.setResizable(false);
        primaryStage.show();

//        registerUser();
        loginUser();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    public void registerUser() {
        User user = new User();
        user.setFullname("Java Test");
        user.setEmail("java@test.com");
        user.setBsn("123123");
        user.setHuisnummer("1B");
        user.setPassword("wachtwoord");
        user.setPostcode("1234AB");
        user.setStraatnaam("Straatnaam");
        user.setTelefoonnummer("06123456");
        user.setWoonplaats("Woonplaats");

        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("user", user.serialize());

        System.out.println(API.getInstance().post(APIService.USER_CREATE, formData));
    }

    public void loginUser() {
        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("email", "tjphopst@avans.nl");
        formData.add("password", "test12");

        JsonObject apiResponse = API.getInstance().post(APIService.USER_LOGIN, formData);

        if(apiResponse.get("success") != null) {
            AppDataContainer.getInstance().setUserToken(apiResponse.get("Token").getAsString());
        } else {
            System.out.println(apiResponse.get("message"));
        }
    }

}
