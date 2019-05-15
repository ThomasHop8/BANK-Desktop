package com.hoekbank.bank.desktop.ui;

import com.hoekbank.bank.desktop.BaseScreen;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public abstract class RepScreenUI extends BaseScreen {

	
	public Button btnophaal, btnterug, btnregister;
	public Label lblkies, lblemail, lblselect;
	public ComboBox cboxrol, cboxrekening;
	public TextField emailvulin;
	
	
    @Override
    protected void setupMainUI() {
    	btnophaal = new Button("Ophalen");
    	btnterug = new Button("Terug");
    	btnregister = new Button("Registreren");
    	lblkies = new Label("Kies een rol");
    	lblemail = new Label("Email rekeninghouder");
    	lblselect = new Label ("Selecteer een rekening");
    	cboxrol = new ComboBox();
    	cboxrekening = new ComboBox();
    	emailvulin = new TextField("");
    	
    	

    }
}