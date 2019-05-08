package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public abstract class LoginScreenUI extends BaseScreen {

    public Button loginButton;
    public TextField emailField;
    public PasswordField passwordField;
    public Label emailLabel, passwordLabel, titleLabel;
    public Image image;
    public ImageView imageView;
    
    @Override
    protected void setupMainUI() {
        loginButton = new Button("Login");
        emailField = new TextField();
        emailField.setPromptText("Voer uw e-mailadres in");
        passwordField = new PasswordField();
        passwordField.setPromptText("Voer uw wachtwoord in");
        emailLabel = new Label("E-mailadres");
        passwordLabel = new Label("Wachtwoord");
        titleLabel = new Label("INLOGGEN");
        titleLabel.setFont(Font.font(28));
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        image = new Image("/images/logo.png");
        imageView = new ImageView();
        imageView.setImage(image);
    }
}
