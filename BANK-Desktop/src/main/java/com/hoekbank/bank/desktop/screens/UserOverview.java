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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author kevin
 */

public class UserOverview extends UserOverviewUI {

    public UserOverview(Pane root) {
        tableRekeningen.setItems(getRekening());
        tableRekeningen.columnResizePolicyProperty();

        ContextMenu contextMenu = new ContextMenu();
        MenuItem spaarrekening1 = new MenuItem("Spaarrekening");
        MenuItem betaalrekening1 = new MenuItem("Betaalrekening");

        spaarrekening1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("SpaarrekeningXDXD");
            }
        });
            
        tableRekeningen.widthProperty().addListener((source, oldWidth, newWidth)->{
            TableHeaderRow header = (TableHeaderRow) tableRekeningen.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue)-> header.setReordering(false));
        });
        
        
        addRekening.setOnAction(e ->{
            System.out.println("Je wordt doorverwezen naar de \"rekening toevoegen pagina\"");
        });

        betaalrekening1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                    System.out.println("BetaalrekeningXDXD");  
            }
        });
           //   BorderStroke b = new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(10));
           //   VBox boot = new VBox();
          //    boot.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
          //    Border bd = new Border(b);
        //   boot.setBorder(bd);     
   //   boot.relocate(900, 210);
      //         root.getChildren().add(boot);
      //        boot.setPadding(new Insets(5));
      //      boot.setSpacing(5);
        

        contextMenu.getItems().addAll(spaarrekening1, betaalrekening1);
     
        addRekening.setOnAction(e -> {
            contextMenu.show(addRekening, 1100, 400);
        });

        addRekening.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {

                contextMenu.show(betaalrekening, event.getScreenX(), event.getScreenY());
                contextMenu.show(spaarrekening, event.getScreenX(), event.getScreenY());

            }
        });

        transactions.setOnAction(e -> {
            System.out.println("Je wordt doorverwezen naar de \"transactie pagina\"");
        });

        logout.setOnAction(e -> logout());
        root.getChildren().addAll(logout, addRekening, transactions, titleLabel, rekeningLabel, addRekeningLabel, tableRekeningen, logoImageView, logoutImageView);

    }

    private ObservableList<Rekening>getRekening() {
        ObservableList<Rekening> rekeningen = FXCollections.observableArrayList();

        for (JsonElement rekening : getAccounts()) {
            JsonObject object = rekening.getAsJsonObject();
            String rekHouder;

            if(!object.get("Volledige Naam").isJsonNull()) {
                rekHouder = object.get("Volledige Naam").getAsString();
            } else if(!object.get("Bedrijfsnaam").isJsonNull()) {
                rekHouder = object.get("Bedrijfsnaam").getAsString();
            } else {
                continue;
            }

            rekeningen.add(new Rekening(new ImageView(new Image("/images/iconBetaalrekening.png")), object.get("RekeningNr").getAsString(), rekHouder, object.get("TypeNaam").getAsString(), object.get("Saldo").getAsDouble()));
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