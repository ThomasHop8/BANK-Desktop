/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import com.hoekbank.bank.desktop.models.Rekening;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 *
 * @author kevin
 */
public abstract class UserOverviewUI extends BaseScreen {

    public Pane userOverviewPane;

    public Button logout, addRekening, transactions;
    public Label titleLabel, rekeningLabel, addRekeningLabel;
    public TableView<Rekening> tableRekeningen;
    public Image logoImage, logoutImage;
    public ImageView logoImageView, logoutImageView;
    
    @Override
    protected void setupMainUI() {
        userOverviewPane = new Pane();
        
        titleLabel = new Label("Welkom Klant123");
        titleLabel.setFont(Font.font(28));
        rekeningLabel = new Label("Rekeningoverzicht");
        rekeningLabel.setFont(Font.font(18));
        addRekeningLabel = new Label("Rekening toevoegen");
        addRekeningLabel.setFont(Font.font(18));
        
        addRekening = new Button("+");
        addRekening.setFont(Font.font(18));
        
        transactions = new Button("Bekijk transacties");
        transactions.setFont(Font.font(16));
        
        tableRekeningen = new TableView<>();
        
        TableColumn<Rekening, String>rekeningnummerColumn = new TableColumn<>("Rekeningnummer");
        rekeningnummerColumn.setMinWidth(150);
        rekeningnummerColumn.setMaxWidth(150);
        rekeningnummerColumn.setSortable(false);
        rekeningnummerColumn.setCellValueFactory(new PropertyValueFactory<>("rekeningnummer"));
        
        TableColumn<Rekening, String>rekeninghouderColumn = new TableColumn<>("Rekeninghouder");
        rekeninghouderColumn.setMinWidth(150);
        rekeninghouderColumn.setMaxWidth(150);
        rekeninghouderColumn.setSortable(false);
        rekeninghouderColumn.setCellValueFactory(new PropertyValueFactory<>("rekeninghouder"));
        
        TableColumn<Rekening, String>rekeningsoortColumn = new TableColumn<>("Rekeningsoort");
        rekeningsoortColumn.setMinWidth(150);
        rekeningsoortColumn.setMaxWidth(150);
        rekeningsoortColumn.setSortable(false);
        rekeningsoortColumn.setCellValueFactory(new PropertyValueFactory<>("rekeningsoort"));
        
        TableColumn<Rekening, String>saldoColumn = new TableColumn<>("Saldo");
        saldoColumn.setMinWidth(100);
        saldoColumn.setMaxWidth(100);
        saldoColumn.setSortable(false);
        saldoColumn.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        
        TableColumn<Rekening, ImageView>iconColumn = new TableColumn<>("");
        iconColumn.setCellValueFactory(new PropertyValueFactory<Rekening, ImageView>("icon"));
        //iconColumn.setStyle("-fx-alignment: CENTER;");
        
        
        tableRekeningen.getColumns().addAll(iconColumn, rekeningnummerColumn, rekeninghouderColumn, rekeningsoortColumn, saldoColumn);
        tableRekeningen.getStylesheets().add("styles/TableView.css");
        tableRekeningen.setPrefHeight(200);
        
        logoutImage = new Image("/images/logout.png");
        logout = new Button();
        logoutImageView = new ImageView();
        logoutImageView.setImage(logoutImage);
        logoutImageView.setFitHeight(50);
        logoutImageView.setFitWidth(136);
        logout.setGraphic(logoutImageView);
        logout.setBackground(Background.EMPTY);
        
        logoImage = new Image("/images/logo.png");
        logoImageView = new ImageView();
        logoImageView.setImage(logoImage);
        logoImageView.setFitHeight(80);
        logoImageView.setFitWidth(80);
        
        tableRekeningen.relocate(290, 213);
        titleLabel.relocate(290, 40);
        rekeningLabel.relocate(290, 180);
        addRekeningLabel.relocate(750, 175);
        logout.relocate(1104, 40);
        addRekening.relocate(705, 170);
        transactions.relocate(780, 423);
        logoImageView.relocate(20, 20);
    }
    
}
