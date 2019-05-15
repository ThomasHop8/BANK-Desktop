/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hoekbank.bank.desktop.screens;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hoekbank.bank.desktop.api.API;
import com.hoekbank.bank.desktop.api.APIService;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.Rekening;
import com.hoekbank.bank.desktop.ui.UserOverviewUI;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author kevin
 */
public class UserOverview extends UserOverviewUI {
    public UserOverview(Pane root) {
        
        
        tableRekeningen.setItems(getRekening());
        tableRekeningen.columnResizePolicyProperty();
        tableRekeningen.widthProperty().addListener((source, oldWidth, newWidth)->{
            TableHeaderRow header = (TableHeaderRow) tableRekeningen.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue)-> header.setReordering(false));
        });
        
        
        addRekening.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"rekening toevoegen pagina\"");
        });
        
        transactions.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"transactie pagina\"");
        });
        
        logout.setOnAction(e -> logout());
        
        root.getChildren().addAll(logout, addRekening, transactions, titleLabel, rekeningLabel, addRekeningLabel, tableRekeningen, logoImageView, logoutImageView);
    }
    
    private ObservableList<Rekening>getRekening() {
        ObservableList<Rekening> rekeningen = FXCollections.observableArrayList();

        for (JsonElement rekening : getAccounts()) {
            JsonObject object = rekening.getAsJsonObject();
            rekeningen.add(new Rekening(new ImageView(new Image("/images/iconBetaalrekening.png")), object.get("RekeningNr").getAsString(), object.get("Volledige Naam").getAsString(), object.get("TypeNaam").getAsString(), object.get("Saldo").getAsDouble()));
        }

        return rekeningen;
    }

    private JsonArray getAccounts() {
        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("user", "1");

        return API.getInstance().post(APIService.ACCOUNT_LIST, formData).getAsJsonArray();
    }

    private void logout(){
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}

        

