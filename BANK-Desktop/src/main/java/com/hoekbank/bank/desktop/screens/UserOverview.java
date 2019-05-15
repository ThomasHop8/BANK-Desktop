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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author kevin
 */
public class UserOverview extends UserOverviewUI {
    public UserOverview(Pane root) {
        
        
        tableRekeningen.setItems(getRekening());
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

        

