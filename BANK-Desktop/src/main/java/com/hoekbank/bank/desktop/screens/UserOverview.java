package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.Rekening;
import com.hoekbank.bank.desktop.ui.UserOverviewUI;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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

        betaalrekening1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                    System.out.println("BetaalrekeningXDXD");  
            }
        });
              BorderStroke b = new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, new CornerRadii(50), new BorderWidths(10));
              VBox boot = new VBox();
              boot.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
              Border bd = new Border(b);
           boot.setBorder(bd);     
      boot.relocate(900, 210);
               root.getChildren().add(boot);
              boot.setPadding(new Insets(5));
            boot.setSpacing(5);
        

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

    private ObservableList<Rekening> getRekening() {
        ObservableList<Rekening> rekeningen = FXCollections.observableArrayList();
        rekeningen.add(new Rekening("013246789", "Kevin Trouw", "Betaalrekening", 320.53));
        rekeningen.add(new Rekening("9876543210", "Kevin Trouw", "Betaalrekening", 200.20));
        rekeningen.add(new Rekening("0246813579", "Kevin Trouw", "Spaarrekening", 4000.70));

        return rekeningen;
    }

    private void logout() {
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}