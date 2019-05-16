package com.hoekbank.bank.desktop.screens;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hoekbank.bank.desktop.api.API;
import com.hoekbank.bank.desktop.api.APIService;
import com.hoekbank.bank.desktop.models.Transactie;
import com.hoekbank.bank.desktop.ui.TransactionScreenUI;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.ws.rs.core.MultivaluedMap;

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
        root.setStyle("-fx-background-color: #FFFF");

        // Style, Fonts
        lbTitel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lbTitel.setTextFill(Color.BLACK);
        lbSaldo.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        lbTitel.setTextFill(Color.BLACK);

        /**
         * Setup Colunms van TableView
         */
        // Kolom Datum
        TableColumn<Transactie, String> datumColunm = new TableColumn<>("Datum");
        datumColunm.setMinWidth(100);
        datumColunm.setMaxWidth(100);
        datumColunm.setCellValueFactory(new PropertyValueFactory<>("datum"));

        // Kolom Omschrijving
        TableColumn<Transactie, String> omschrijvingColunm = new TableColumn<>("Omschrijving");
        omschrijvingColunm.setMinWidth(200);
        omschrijvingColunm.setMaxWidth(200);
        omschrijvingColunm.setSortable(false);
        omschrijvingColunm.setCellValueFactory(new PropertyValueFactory<>("omschrijving"));

        // Kolom bedragIn
        TableColumn<Transactie, Double> bedragInColunm = new TableColumn<>("IN");
        bedragInColunm.setMinWidth(100);
        bedragInColunm.setMaxWidth(100);
        bedragInColunm.setSortable(false);
        bedragInColunm.setCellValueFactory(new PropertyValueFactory<>("bedragIn"));

        // Kolom bedragUit
        TableColumn<Transactie, Double> bedragUitColunm = new TableColumn<>("UIT");
        bedragUitColunm.setMinWidth(100);
        bedragUitColunm.setMaxWidth(100);
        bedragUitColunm.setSortable(false);
        bedragUitColunm.setCellValueFactory(new PropertyValueFactory<>("bedragUit"));

        // Kolom Saldo
        TableColumn<Transactie, Double> saldoColunm = new TableColumn<>("Saldo");
        saldoColunm.setMinWidth(100);
        saldoColunm.setMaxWidth(100);
        saldoColunm.setSortable(false);
        saldoColunm.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        // Toevoegen in Table TableTransacties.
        tableTransacties.setItems(getTransactie());
        tableTransacties.getColumns().addAll(datumColunm,omschrijvingColunm,bedragInColunm,bedragUitColunm,saldoColunm);
        tableTransacties.columnResizePolicyProperty();
        tableTransacties.getStylesheets().add("styles/TableView.css");
        tableTransacties.setMinWidth(620);

        // Disabled drag en drop
        tableTransacties.widthProperty().addListener((source, oldWidth, newWidth) -> {
            TableHeaderRow header = (TableHeaderRow) tableTransacties.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue) -> header.setReordering(false));
        });

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
        // Settings
        gridCenter.setAlignment(Pos.CENTER);
        // Elementen toevoegen
        gridCenter.add(lbTitel,0,0);
        gridCenter.add(lbSaldo, 0,0);
        gridCenter.setHalignment(lbSaldo, HPos.RIGHT);
        gridCenter.add(tableTransacties,0,1);


        btnTerug.setOnAction( event -> back());

    }

    // All transactions
    private ObservableList<Transactie> getTransactie() {
        ObservableList<Transactie> transacties = FXCollections.observableArrayList();

        for (JsonElement transaction : getTransactions()) {
            JsonObject object = transaction.getAsJsonObject();
            transacties.add(new Transactie(object.get("TransTime").getAsString(), "nvt", object.get("Bedrag").getAsDouble(), object.get("Bedrag").getAsDouble(),0));
        }

        return transacties;
    }

    private JsonArray getTransactions() {
        MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
        formData.add("user", "1");
        formData.add("accountNr", "0000000001");

        return API.getInstance().post(APIService.ACCOUNT_TRANSACTIONS, formData).getAsJsonArray();
    }

    private void back() {
        System.out.println("Terug knop clicked!");
        // todo wijzigen voor terug knop
//        Pane employeePane = new Pane();
//        new EmployeeDashboard(employeePane);
//        ScenesController.setStage(employeePane);
    }
}
