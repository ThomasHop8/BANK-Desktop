package com.hoekbank.bank.desktop.screens;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hoekbank.bank.desktop.api.API;
import com.hoekbank.bank.desktop.api.APIService;
import com.hoekbank.bank.desktop.enums.RegisterState;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.hoekbank.bank.desktop.helpers.ScenesController;
import com.hoekbank.bank.desktop.models.Rekening;
import com.hoekbank.bank.desktop.ui.UserOverviewUI;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.ws.rs.core.MultivaluedMap;
/**
 *
 * @author kevin en rogier
 */
public class UserOverview extends UserOverviewUI {

    public GridPane grid = new GridPane();

    public UserOverview(Pane root) {
        setupLogin(RegisterState.USER, "Gebruiker");

        tableRekeningen.setItems(getRekening());
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setPrefSize(300, 300);
        grid.setVgap(5);
        grid.setHgap(5);
        spaarrekening.setText("Spaarrekening");
        grid.add(spaarrekening, 80, 95);
        grid.add(betaalrekening, 81, 95);
        grid.add(bankpas, 82, 95);

        tableRekeningen.columnResizePolicyProperty();

        tableRekeningen.widthProperty().addListener((source, oldWidth, newWidth) -> {
            TableHeaderRow header = (TableHeaderRow) tableRekeningen.lookup("TableHeaderRow");
            header.reorderingProperty().addListener((observable, oldValue, newValue) -> header.setReordering(false));
        });

        addRekening.setOnAction(e -> {

            root.getChildren().add(grid);

        });

        transactions.setOnAction(e -> {
            String selectedRekNr = tableRekeningen.getSelectionModel().getSelectedItem().getRekeningnummer();
            selectedRekNr = selectedRekNr.replace(".", "");

            Pane transPane = new Pane();
            new TransactionScreen(transPane, selectedRekNr);
            ScenesController.setStage(transPane);
        });

        userOverviewPane.getChildren().addAll(addRekening, transactions, titleLabel, rekeningLabel, addRekeningLabel, tableRekeningen, logoImageView);

        pageContainer.getChildren().add(userOverviewPane);
        root.getChildren().add(appContainer);
    }

    @Override
    protected Image getCoverImage() {
        return new Image("/images/background_covers/accounts.png");
    }

    @Override
    protected String getPageTitle() {
        return "REKENINGEN";
    }

    private ObservableList<Rekening> getRekening() {
        ObservableList<Rekening> rekeningen = FXCollections.observableArrayList();

        for (JsonElement rekening : getAccounts()) {
            JsonObject object = rekening.getAsJsonObject();
            String rekHouder;

            if (!object.get("Volledige Naam").isJsonNull()) {
                rekHouder = object.get("Volledige Naam").getAsString();
            } else if (!object.get("Bedrijfsnaam").isJsonNull()) {
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
        formData.add("user", AppDataContainer.getInstance().getUserID());

        return API.getInstance().post(APIService.ACCOUNT_LIST, formData).getAsJsonArray();
    }

    private void logout() {
        GridPane loginPane = new GridPane();
        new LoginScreen(loginPane);
        ScenesController.setStage(loginPane);
    }
}
