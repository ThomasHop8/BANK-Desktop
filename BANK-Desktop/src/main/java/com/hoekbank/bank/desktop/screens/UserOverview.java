/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.Rekening;
import com.hoekbank.bank.desktop.ui.UserOverviewUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author kevin
 */
public class UserOverview extends UserOverviewUI {
    public UserOverview(Pane root) {
        TableColumn<Rekening, String>rekeningnummerColumn = new TableColumn<>("Rekeningnummer");
        rekeningnummerColumn.setMinWidth(80);
        rekeningnummerColumn.setCellValueFactory(new PropertyValueFactory<>("rekeningnummer"));
        
        TableColumn<Rekening, String>rekeninghouderColumn = new TableColumn<>("Rekeninghouder");
        rekeninghouderColumn.setMinWidth(120);
        rekeninghouderColumn.setCellValueFactory(new PropertyValueFactory<>("rekeninghouder"));
        
        TableColumn<Rekening, String>rekeningsoortColumn = new TableColumn<>("Rekeningsoort");
        rekeningsoortColumn.setMinWidth(150);
        rekeningsoortColumn.setCellValueFactory(new PropertyValueFactory<>("rekeningsoort"));
        
        TableColumn<Rekening, String>saldoColumn = new TableColumn<>("Saldo");
        saldoColumn.setMinWidth(100);
        saldoColumn.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        
        tableRekeningen.setItems(getRekening());
        tableRekeningen.getColumns().addAll(rekeningnummerColumn, rekeninghouderColumn, rekeningsoortColumn, saldoColumn);
        tableRekeningen.columnResizePolicyProperty();
        
        
        
        addRekening.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"rekening toevoegen pagina\"");
        });
        
        transactions.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"transactie pagina\"");
        });
        
        logout.setOnAction(e -> logout());
        
        root.getChildren().addAll(logout, addRekening, transactions, titleLabel, rekeningLabel, addRekeningLabel, tableRekeningen, logoImageView, logoutImageView);
    }
    
    private ObservableList<Rekening>getRekening(){
            ObservableList<Rekening> rekeningen = FXCollections.observableArrayList();
            rekeningen.add(new Rekening("013246789", "Kevin Trouw", "Betaalrekening", 320.53));
            rekeningen.add(new Rekening("9876543210", "Kevin Trouw", "Betaalrekening", 200.20));
            rekeningen.add(new Rekening("0246813579", "Kevin Trouw", "Spaarrekening", 4000.70));
            
            return rekeningen;
        }
    
    private void logout(){
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}

        

