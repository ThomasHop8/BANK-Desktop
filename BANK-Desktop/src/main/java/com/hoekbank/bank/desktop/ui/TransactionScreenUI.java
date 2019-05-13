package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import com.hoekbank.bank.desktop.models.Transactie;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;


public abstract class TransactionScreenUI extends BaseScreen {

    public Button btnTerug;
    public Label lbTitel;
    public TableView<Transactie> tableTransacties;


    @Override
    protected void setupMainUI() {

        // Knoppen
        btnTerug = new Button("< Terug");
        // Labels
        lbTitel = new Label("Transacties");
        // TableView
        tableTransacties = new TableView<>();

    }
}
