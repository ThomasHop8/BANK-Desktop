package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import com.hoekbank.bank.desktop.models.Transactie;
import com.hoekbank.bank.desktop.resources.HabboBackButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;


public abstract class TransactionScreenUI extends BaseScreen {

    public BorderPane transactionBorderPane;

    public Button btnTerug;
    public Label lbTitel, lbSaldo;
    public TableView<Transactie> tableTransacties;


    @Override
    protected void setupMainUI() {

        transactionBorderPane = new BorderPane();

        // Knoppen
        btnTerug = new HabboBackButton("< Terug");
        // Labels
        lbTitel = new Label("Transacties");
        lbSaldo = new Label("Saldo");
        // TableView
        tableTransacties = new TableView<>();


    }
}
