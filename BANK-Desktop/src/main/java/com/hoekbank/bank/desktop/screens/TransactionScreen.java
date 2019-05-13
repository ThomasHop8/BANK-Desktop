package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.models.Transactie;
import com.hoekbank.bank.desktop.ui.TransactionScreenUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * @author Chahine
 */

public class TransactionScreen extends TransactionScreenUI {
    /**
     * Main pane van TransactieScreen
     * @param root
     */
    public TransactionScreen(BorderPane root) {
        // GridPanes
        GridPane gridTop = new GridPane();
        GridPane gridCenter = new GridPane();

        // Borderpane settings, aangeven waar de panes komen te staan.
        root.setTop(gridTop);
        root.setCenter(gridCenter);

        /**
         * GridTop
         */
        // Settings
        gridTop.setAlignment(Pos.TOP_LEFT);
        gridTop.setVgap(10);
        gridTop.setHgap(10);
        gridTop.setPadding(new Insets(10));
        // Elementen toevoegen
        gridTop.add(btnTerug,0,0);

        /**
         * GridCenter
         */
    }

    // All transactions
    public ObservableList<Transactie> getTransactie() {
        ObservableList<Transactie> transacties = FXCollections.observableArrayList();
        transacties.add(new Transactie("13-5-2019", "Lening", 50.00, 0,5000) );

    }
}
