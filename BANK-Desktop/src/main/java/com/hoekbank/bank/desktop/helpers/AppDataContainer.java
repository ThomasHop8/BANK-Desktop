package com.hoekbank.bank.desktop.helpers;

public class AppDataContainer {

    private static AppDataContainer instance;
    private String userToken;

    private AppDataContainer() {
    }

    public static synchronized AppDataContainer getInstance( ) {
        if (instance == null)
            instance = new AppDataContainer();

        return instance;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
