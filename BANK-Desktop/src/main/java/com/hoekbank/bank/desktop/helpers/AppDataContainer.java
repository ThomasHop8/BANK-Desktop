package com.hoekbank.bank.desktop.helpers;

import com.hoekbank.bank.desktop.enums.RegisterState;

public class AppDataContainer {

    private static AppDataContainer instance;
    private String userToken;
    private RegisterState registerState;

    private AppDataContainer() {
    }

    public static synchronized AppDataContainer getInstance( ) {
        if(instance == null)
            instance = new AppDataContainer();

        return instance;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public RegisterState getRegisterState() {
        return registerState;
    }

    public void setRegisterState(RegisterState registerState) {
        this.registerState = registerState;
    }
}
