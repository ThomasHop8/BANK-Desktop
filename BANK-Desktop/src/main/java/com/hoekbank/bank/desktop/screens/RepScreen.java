package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.RepScreenUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class RepScreen extends RepScreenUI {

    public RepScreen(GridPane root) {
    	
    	GridPane g = new GridPane();
    	root.getChildren().addAll(btnophaal, btnterug, btnregister, lblkies, lblemail, lblselect, cboxrol, cboxrekening, emailvulin);
    	g.setHgap(1);
    	g.setVgap(1);
    	
    	ObservableList<String> rollen = 
    		    FXCollections.observableArrayList(
    		        "Gemachtigde",
    		        "Mederekeninghouder");
    	
    	cboxrol.setItems(rollen);
    	
    	btnterug.setOnAction(event -> {
            GridPane registerPane = new GridPane();
            new RegisterScreen(registerPane);
            ScenesController.setStage(registerPane);
        });
    	
    	emailvulin.setPromptText("Vul email in");
    	
    	g.add(btnterug, 0, 8);
    	g.add(lblkies, 0, 1);
    	g.add(cboxrol, 0, 2);
    	g.add(btnophaal, 1, 4);
    	g.add(lblemail, 0, 3);
    	g.add(emailvulin, 0, 4);
    	g.add(lblselect, 5, 3);
    	g.add(cboxrekening, 5, 4);
    	g.add(btnregister, 5, 8);
    
        root.getChildren().add(g);

    
    
    }
    
}
