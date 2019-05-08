/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author kevin
 */
public abstract class EmployeeDashboardUI extends BaseScreen {
    
    public Button particulierRegister, bedrijfRegister, gemachtigdeRegister, logout;
    public Label titleLabel, registerLabel;
    public VBox vbLogo;
    public Image logoImage, logoutImage;
    public ImageView logoImageView, logoutImageView;
    
    @Override
    protected void setupMainUI() {
        particulierRegister = new Button("Particulier registeren");
        bedrijfRegister = new Button("Bedrijf registeren");
        gemachtigdeRegister = new Button("Gemachtigde registeren");
        
        titleLabel = new Label("Welkom Medewerker123");
        registerLabel = new Label("Registreer acties");
        titleLabel.setFont(Font.font(28));
        
        particulierRegister.setPrefSize(150, 50);
        bedrijfRegister.setPrefSize(150, 50);
        gemachtigdeRegister.setPrefSize(150, 50);
                
        logoImage = new Image("/images/logo.png");
        logoImageView = new ImageView();
        logoImageView.setImage(logoImage);
        logoImageView.setFitHeight(80);
        logoImageView.setFitWidth(80);
        
        logoutImage = new Image("/images/logout.png");
        logout = new Button();
        logoutImageView = new ImageView();
        logoutImageView.setImage(logoutImage);
        logoutImageView.setFitHeight(50);
        logoutImageView.setFitWidth(136);
        logout.setGraphic(logoutImageView);
        
        
        vbLogo = new VBox();
        vbLogo.setPadding(new Insets(0, 20, 10, 0));
        vbLogo.getChildren().add(logoImageView);
        
        
    }
}
