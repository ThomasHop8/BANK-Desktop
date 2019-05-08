package com.hoekbank.bank.desktop.screens;

import com.hoekbank.bank.desktop.ui.RegisterScreenUI;
import javafx.scene.layout.GridPane;

public class RegisterScreen extends RegisterScreenUI {

    public RegisterScreen(GridPane root) {
    	GridPane g = new GridPane();
        root.getChildren().addAll(registerButton, txtnaam,txtstraatnaam,txtwoonplaats, txttelefoon,txthuisnummer, txtemail,txtpostcode, lblnaam,lblstraatnaam,lblwoonplaats,lbltelefoon,lblhuisnummer, lblemail,lblpostcode);
    
    
       
        g.add(lblnaam, 0, 0);
        g.add(txtnaam, 0, 1);
        g.add(lbltelefoon, 1, 0);
        g.add(txttelefoon, 1, 1);
        g.add(lblstraatnaam, 0, 2);
        g.add(txtstraatnaam, 0, 3);
        g.add(lblhuisnummer, 1, 2);
        g.add(txthuisnummer, 1, 3);
        g.add(lblpostcode, 0, 4);
        g.add(lblwoonplaats, 1, 4);
        g.add(txtpostcode, 0, 5);
        g.add(txtwoonplaats, 1, 5);
        g.add(lblemail, 0, 6);
        g.add(txtemail, 0, 7);
        g.add(registerButton, 0, 8);  
        
              
        
        root.getChildren().add(g);

        
    
        
    }
    
}
