package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.ValidateScreenUI;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author Chahine
 */

public class ValidateScreen extends ValidateScreenUI {


    public ValidateScreen(GridPane root) {
        /**
         * GridPane links, Controle
         */
        GridPane gridPaneLinks = new GridPane();
        // gridpane settings
        gridPaneLinks.setMinSize(640,691);
//        gridPaneLinks.setMaxSize(640,700);
        gridPaneLinks.setAlignment(Pos.CENTER);
        gridPaneLinks.setVgap(10);
        gridPaneLinks.setHgap(10);
        gridPaneLinks.setPadding(new Insets(10));

        // Background color for testing gridpanes
//        String opmaak = "-fx-background-color: rgba(26, 159, 178, 1);";
//        gridPaneLinks.setStyle(opmaak);

        // Fonts, Colors
        lbTitle.setFont(Font.font("Arial", FontWeight.BOLD,20));
        lbTitle.setTextFill(Color.BLACK);

        gridPaneLinks.add(lbTitle,0,0);
        gridPaneLinks.add(lbBsn,0,1);
        gridPaneLinks.add(txtBsn,0,2);
        gridPaneLinks.add(lbBkrGoedkeuren,0,3);
        gridPaneLinks.add(checkBkrJa,0,4);
        gridPaneLinks.add(checkBkrNee,0,4);
        gridPaneLinks.setHalignment(checkBkrNee, HPos.CENTER);
        gridPaneLinks.add(lbZwarteLijst,0,5);
        gridPaneLinks.add(checkZwrtLstJa,0,6);
        gridPaneLinks.add(checkZwrtLstNee,0,6);
        gridPaneLinks.setHalignment(checkZwrtLstNee, HPos.CENTER);

        /**
         * GridPane rechts, knoppen
         */
        GridPane gridRechts = new GridPane();

        // gridpane settings
        gridRechts.setMinSize(640,691);
        gridRechts.setMaxSize(640,691);
        gridRechts.setAlignment(Pos.BOTTOM_RIGHT);
        gridRechts.setVgap(10);
        gridRechts.setHgap(10);
        gridRechts.setPadding(new Insets(10));

        // Background color for testing gridpanes
//        String opmaak2 = "-fx-background-color: rgb(31,153,14);";
//        gridRechts.setStyle(opmaak2);
        gridRechts.add(btnRegistreren,1,0);
        gridRechts.add(btnAfwijzen,0,0);

        /**
         * GridPane root, main gridpane.
         * add gridPaneLinks/gridRechts to root.
         */

        root.add(gridPaneLinks,0,0);
        root.add(gridRechts,1,0);

        checkBkrJa.setOnAction(event -> {

            if (checkBkrJa.isSelected()) {
                checkBkrNee.setSelected(false);
                System.out.println("check");
            }
        });

        checkBkrNee.setOnAction(event -> {

            if (checkBkrNee.isSelected()) {
                checkBkrJa.setSelected(false);
                System.out.println("check");
            }
        });

        checkZwrtLstJa.setOnAction( event ->  {
            if (checkZwrtLstJa.isSelected()) {
                checkZwrtLstNee.setSelected(false);
                System.out.println("check2");
            }
        });

        checkZwrtLstNee.setOnAction( event ->  {
            if (checkZwrtLstNee.isSelected()) {
                checkZwrtLstJa.setSelected(false);
                System.out.println("check2");
            }
        });





//        root.getChildren().addAll(gridControle);

    }
}
