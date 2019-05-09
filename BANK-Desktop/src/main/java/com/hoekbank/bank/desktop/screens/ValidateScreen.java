package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.ui.ValidateScreenUI;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.SQLOutput;
import java.util.Optional;


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
        gridPaneLinks.setMinSize(640, 691);
//        gridPaneLinks.setMaxSize(640,700);
        gridPaneLinks.setAlignment(Pos.CENTER);
        gridPaneLinks.setVgap(10);
        gridPaneLinks.setHgap(10);
        gridPaneLinks.setPadding(new Insets(10));

        // Background color for testing gridpanes
//        String opmaak = "-fx-background-color: rgba(26, 159, 178, 1);";
//        gridPaneLinks.setStyle(opmaak);

        // Fonts, Colors
        lbTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lbTitle.setTextFill(Color.BLACK);

        /**
         * Add UI on GridPane links
         */
        gridPaneLinks.add(lbTitle, 0, 0);
        gridPaneLinks.add(lbBsn, 0, 1);
        gridPaneLinks.add(txtBsn, 0, 2);
        gridPaneLinks.add(lbBkrGoedkeuren, 0, 3);
        gridPaneLinks.add(checkBkrJa, 0, 4);
        gridPaneLinks.add(checkBkrNee, 0, 4);
        gridPaneLinks.setHalignment(checkBkrNee, HPos.CENTER);
        gridPaneLinks.add(lbZwarteLijst, 0, 5);
        gridPaneLinks.add(checkZwrtLstJa, 0, 6);
        gridPaneLinks.add(checkZwrtLstNee, 0, 6);
        gridPaneLinks.setHalignment(checkZwrtLstNee, HPos.CENTER);
        gridPaneLinks.add(lbRedenAfwijzing, 0, 7);
        gridPaneLinks.add(txtRedenAfwijzing, 0, 8);

        // Notitie afwijzing settings
        lbRedenAfwijzing.setVisible(false);
        txtRedenAfwijzing.setPrefHeight(100);
        txtRedenAfwijzing.setPrefWidth(10);
        txtRedenAfwijzing.setVisible(false);

        // Knoppen Default zichtbaarheid false
        btnAfwijzen.setVisible(false);
        btnRegistreren.setVisible(false);

        /**
         * GridPane rechts, knoppen
         */
        GridPane gridRechts = new GridPane();

        // gridpane settings
        gridRechts.setMinSize(640, 691);
        gridRechts.setMaxSize(640, 691);
        gridRechts.setAlignment(Pos.BOTTOM_RIGHT);
        gridRechts.setVgap(10);
        gridRechts.setHgap(10);
        gridRechts.setPadding(new Insets(10));

        // Background color for testing gridpanes
//        String opmaak2 = "-fx-background-color: rgb(31,153,14);";
//        gridRechts.setStyle(opmaak2);
        gridRechts.add(btnRegistreren, 2, 0);
        gridRechts.add(btnAfwijzen, 1, 0);
        gridRechts.add(btnTerug, 0, 0);

        /**
         * GridPane root, main gridpane.
         * add gridPaneLinks/gridRechts to root.
         */

        root.add(gridPaneLinks, 0, 0);
        root.add(gridRechts, 1, 0);

        /**
         * Events
         */

        checkBkrJa.setOnAction(event -> {

            if (checkBkrJa.isSelected()) {
                checkBkrNee.setSelected(false);
                txtRedenAfwijzing.setVisible(true);
                lbRedenAfwijzing.setVisible(true);
                btnAfwijzen.setVisible(true);
                btnRegistreren.setVisible(false);
                //System.out.println("check");
            }

        });

        checkBkrNee.setOnAction(event -> {

            if (checkBkrNee.isSelected()) {
                checkBkrJa.setSelected(false);
                txtRedenAfwijzing.setVisible(false);
                lbRedenAfwijzing.setVisible(false);
                //System.out.println("check");
            }
            if (checkBkrJa.isSelected() && checkZwrtLstNee.isSelected()) {
                txtRedenAfwijzing.setVisible(true);
                lbRedenAfwijzing.setVisible(true);
            }

            if (checkZwrtLstNee.isSelected() && checkBkrNee.isSelected()) {
                btnRegistreren.setVisible(true);
                btnAfwijzen.setVisible(false);
            }

        });


        checkZwrtLstJa.setOnAction(event -> {
            if (checkZwrtLstJa.isSelected()) {
                checkZwrtLstNee.setSelected(false);
                // zet zichtbaar
                txtRedenAfwijzing.setVisible(true);
                lbRedenAfwijzing.setVisible(true);
                btnAfwijzen.setVisible(true);
                btnRegistreren.setVisible(false);
                //System.out.println("check2");
            }
            if (!checkZwrtLstJa.isSelected() && checkBkrJa.isSelected()) {
                btnAfwijzen.setVisible(true);
            }

        });

        checkZwrtLstNee.setOnAction(event -> {
            if (checkZwrtLstNee.isSelected()) {
                checkZwrtLstJa.setSelected(false);
                txtRedenAfwijzing.setVisible(false);
                lbRedenAfwijzing.setVisible(false);

                //System.out.println("check2");
            }

            if (checkZwrtLstNee.isSelected() && checkBkrJa.isSelected()) {
                txtRedenAfwijzing.setVisible(true);
                lbRedenAfwijzing.setVisible(true);
            }
            if (checkZwrtLstNee.isSelected() && checkBkrNee.isSelected()) {
                btnRegistreren.setVisible(true);
                btnAfwijzen.setVisible(false);
            }


        });

        btnTerug.setOnAction(event -> back());

        btnAfwijzen.setOnAction(event -> {
            try {
                if (txtBsn.getText().isEmpty()) {
                    alertAfwijsWarning.setTitle("Oops!?");
                    alertAfwijsWarning.setContentText("BSN veld is leeg!");
                    alertAfwijsWarning.showAndWait();
                    return;
                }
                if (!checkZwrtLstJa.isSelected() && !checkBkrJa.isSelected()) {
                    alertAfwijsWarning.setTitle("Oops!?");
                    alertAfwijsWarning.setContentText("Één van de checkbox 'Ja' is niet aangevinkt!");
                    alertAfwijsWarning.showAndWait();
                    return;
                }
                if (txtRedenAfwijzing.getText().isEmpty()) {
                    alertAfwijsWarning.setTitle("Oops!?");
                    alertAfwijsWarning.setContentText("Reden voor afwijzing is niet ingevuld!");
                    alertAfwijsWarning.showAndWait();
                    return;
                }
                // Bevestigen of annuleren
                alertAfwijsBevestigen.setTitle("Afwijzing bevestigen");
                alertAfwijsBevestigen.setContentText("Weet u het zeker?");
                Optional<ButtonType> alertResultAfwijzen = alertAfwijsBevestigen.showAndWait();

                if (alertResultAfwijzen.isPresent() && alertResultAfwijzen.get() == ButtonType.OK) {
                    denyUser();
                }

            } catch (Exception e) {
                e.getMessage();
            }
        });

        btnRegistreren.setOnAction(event -> {
            try {
                if (txtBsn.getText().isEmpty()) {
                    alertBtnRegisterWarning.setTitle("Oops!?");
                    alertBtnRegisterWarning.setContentText("BSN veld is leeg!");
                    alertBtnRegisterWarning.showAndWait();
                    return;
                }
                if (!checkBkrNee.isSelected() || !checkZwrtLstNee.isSelected()) {
                    alertBtnRegisterWarning.setTitle("Oops!?");
                    alertBtnRegisterWarning.setContentText("Checkboxes 'Nee' niet aangevinkt!");
                    alertBtnRegisterWarning.showAndWait();
                    return;
                }
                // Bevestigen of annuleren
                alertBtnRegisterBevestigen.setTitle("Controle bevestigen");
                alertBtnRegisterBevestigen.setContentText("Weet u het zeker?");
                Optional<ButtonType> alertResultRegistreren = alertBtnRegisterBevestigen.showAndWait();

                if (alertResultRegistreren.isPresent() && alertResultRegistreren.get() == ButtonType.OK) {
                    userValidated();
                }
            } catch (Exception e) {
                e.getMessage();
            }


        });


//        root.getChildren().addAll(gridControle);

    }

    private void userValidated() {
//        Pane registerPane = new Pane();
//        new EmployeeDashboard(registerPane);
//        ScenesController.setStage(registerPane);
    }

    private void denyUser() {

    }

    private void back() {
        Pane employeePane = new Pane();
        new EmployeeDashboard(employeePane);
        ScenesController.setStage(employeePane);
    }
}
