/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.UserOverviewUI;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author kevin
 */
public class UserOverview extends UserOverviewUI {
    public UserOverview(Pane root) {
        addRekening.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"rekening toevoegen pagina\"");
        });
        
        transactions.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"transactie pagina\"");
        });
        
        logout.setOnAction(e -> logout());
        
        root.getChildren().addAll(logout, addRekening, transactions, titleLabel, rekeningLabel, addRekeningLabel, listRekeningen, logoImageView, logoutImageView);
    }
    
    private void logout(){
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}

        

