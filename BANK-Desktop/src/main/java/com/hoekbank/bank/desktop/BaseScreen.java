package com.hoekbank.bank.desktop;

import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.screens.LoginScreen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * BaseScreen
 * v2.0
 *
 * Created by Thomas Hopstaken on 23-10-2018
 **/
public abstract class BaseScreen {

    public static Pane appContainer;
    public static Pane pageContainer;

    private Pane topBar = new Pane();
    private Pane routeBar = new Pane();

    protected BaseScreen() {
        appContainer = new Pane();
        appContainer.setMinWidth(MainApp.screenWidth);
        appContainer.setMinHeight(MainApp.screenHeight);

        appContainer.setStyle("-fx-background-color: " + Hoekbank.Colours.HABBBO_LIGHT_BLUE);

        setupTopBar();

        routeBar.setMinWidth(MainApp.screenWidth);
        routeBar.setMinHeight(50);
        routeBar.setStyle("-fx-background-color: " + Hoekbank.Colours.DARK_BLUE);
        routeBar.relocate(0, 120);

        setupRoutes();

        pageContainer = new Pane();
        pageContainer.setMinWidth(MainApp.screenWidth);
        pageContainer.setMinHeight(MainApp.screenHeight - routeBar.getMinHeight() - topBar.getMinHeight() - 60);
        pageContainer.setStyle("-fx-background-color: " + Hoekbank.Colours.MAIN_BLUE);
        pageContainer.relocate(0, 165);

        setupBackgroundCoverImage();

        appContainer.getChildren().addAll(topBar, routeBar, pageContainer);

        setupMainUI();
    }

    /**
     * Method for setting the main UI
     */
    protected abstract void setupMainUI();

    /**
     * Method for setting right cover image
     * @return Image right cover image
     */
    protected abstract Image getCoverImage();

    /**
     * Method for setting the current page title
     * @return String current page title
     */
    protected abstract String getPageTitle();

    /**
     * Method for setting the login badge in the top right corner
     * @param state RegisterState of the current user
     * @param user String name of the current user
     */
    protected void setupLogin(RegisterState state, String user) {
        ImageView loginImageView = new ImageView();
        Text userText = new Text(user);

        if(state == RegisterState.EMPLOYEE) {
            loginImageView.setImage(new Image("/images/login_badge_employee.png"));
        } else {
            loginImageView.setImage(new Image("/images/login_badge_user.png"));
        }

        userText.setFont(Font.loadFont(getClass().getResourceAsStream( Hoekbank.Fonts.UBUNTU), 15));
        userText.relocate(MainApp.screenWidth - 270, -40);
        userText.setTextAlignment(TextAlignment.CENTER);
        userText.setFill(Color.WHITE);

        loginImageView.setPreserveRatio(true);
        loginImageView.setFitHeight(45);
        loginImageView.relocate(MainApp.screenWidth - 300, -55);

        topBar.getChildren().addAll(loginImageView, userText);
    }

    /**
     * Method for overriding the back procedure
     */
    protected void back() {
        ArrayList<String> pages = AppDataContainer.getInstance().getPages();
        pages.remove(pages.get(pages.size() - 1));
        pages.remove(pages.get(pages.size() - 1));
        AppDataContainer.getInstance().setPages(pages);
    }


    /**
     * Private method for setting up the page routes
     */
    private void setupRoutes() {
        Text routeText = new Text();
        ArrayList<String> pages = AppDataContainer.getInstance().getPages();

        routeText.setFont(Font.loadFont(getClass().getResourceAsStream(Hoekbank.Fonts.UBUNTU), 16));
        routeText.setFill(Color.valueOf(Hoekbank.Colours.BABY_BLUE));
        routeText.relocate(110, 14);

        pages.add(pages.get(pages.size() - 1) + "    |    " + getPageTitle());

        AppDataContainer.getInstance().setPages(pages);
        routeText.setText(pages.get(pages.size() - 1));

        routeBar.getChildren().add(routeText);
    }

    /**
     * Private method for setting up the right cover image
     */
    private void setupBackgroundCoverImage() {
        ImageView rightBackgroundImage = new ImageView();
        rightBackgroundImage.setImage(getCoverImage());

        rightBackgroundImage.setPreserveRatio(true);
        rightBackgroundImage.setFitHeight(pageContainer.getMinHeight());
        rightBackgroundImage.relocate(MainApp.screenWidth - rightBackgroundImage.getBoundsInParent().getWidth(), 0);

        pageContainer.getChildren().add(rightBackgroundImage);
    }

    /**
     * Private method for setting up the main toolbar
     */
    private void setupTopBar() {
        FlowPane logoutPane = new FlowPane();
        Text title = new Text("Hoekbank");
        Text logout = new Text("UITLOGGEN");
        ImageView logoImageView = new ImageView();
        ImageView logoutImageView = new ImageView();
        logoImageView.setImage(new Image("/images/logo.png"));
        logoutImageView.setImage(new Image("/images/icons/ic_logout.png"));

        logoImageView.setPreserveRatio(true);
        logoImageView.setFitWidth(105);
        logoImageView.relocate(100, -50);

        logoutImageView.setPreserveRatio(true);
        logoutImageView.setFitHeight(20);

        logout.setFont(Font.loadFont(getClass().getResourceAsStream(Hoekbank.Fonts.UBUNTU), 17));
        logout.setFill(Color.valueOf(Hoekbank.Colours.HABBBO_DARK_BLUE));

        title.setFont(Font.loadFont(getClass().getResourceAsStream(Hoekbank.Fonts.HABBO), 40));
        title.relocate(220, 15);

        logoutPane.setOnMouseClicked(t -> logout());
        logoutPane.relocate(MainApp.screenWidth - 250, 20);
        logoutPane.setHgap(6);
        logoutPane.getChildren().addAll(logoutImageView, logout);

        topBar.setMinWidth(MainApp.screenWidth);
        topBar.setMinHeight(60);
        topBar.setStyle("-fx-background-color: " + Hoekbank.Colours.LIGHT_BLUE);
        topBar.relocate(0, 60);
        topBar.getChildren().addAll(logoImageView, title, logoutPane);
    }

    /**
     * Private method to handle the application wide logout function
     */
    private void logout() {
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);

        ArrayList<String> pages = new ArrayList<>();
        pages.add("HOME");
        AppDataContainer.getInstance().setPages(pages);
    }
}
