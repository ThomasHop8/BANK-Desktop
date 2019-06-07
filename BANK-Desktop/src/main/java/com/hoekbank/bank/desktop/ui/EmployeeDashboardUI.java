/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;

import com.hoekbank.bank.desktop.resources.HabboButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author kevin
 */
public abstract class EmployeeDashboardUI extends BaseScreen {

    public Pane dashboardPane;
    
    public Button particulierRegister, bedrijfRegister, gemachtigdeRegister, logout;
    public Label titleLabel, registerLabel;
    public Image logoImage, logoutImage;
    public ImageView logoImageView, logoutImageView;
    
    @Override
    protected void setupMainUI() {
        dashboardPane = new Pane();

        particulierRegister = new HabboButton("Nieuwe Particulier registeren");
        bedrijfRegister = new HabboButton("Nieuw Bedrijf registeren");
        gemachtigdeRegister = new HabboButton("Nieuwe Gemachtigde registeren");

        particulierRegister.setMinWidth(180);
        particulierRegister.setMinHeight(120);
        bedrijfRegister.setMinWidth(180);
        bedrijfRegister.setMinHeight(120);
        gemachtigdeRegister.setMinWidth(180);
        gemachtigdeRegister.setMinHeight(120);
        
        titleLabel = new Label("Welkom Medewerker123");
        titleLabel.setFont(Font.font(28));
        registerLabel = new Label("Registreer acties");
        registerLabel.setFont(Font.font(18));
        
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
        logout.setBackground(Background.EMPTY);
        
        logoImageView.relocate(20, 20);
        titleLabel.relocate(170, 40);
        logout.relocate(1104, 40);
        registerLabel.relocate(170, 128);
        particulierRegister.relocate(170, 165);
        bedrijfRegister.relocate(400, 165);
        gemachtigdeRegister.relocate(630, 165);
    }
}
