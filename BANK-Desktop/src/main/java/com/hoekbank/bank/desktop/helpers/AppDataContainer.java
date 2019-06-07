package com.hoekbank.bank.desktop.helpers;

/**
 * AppDataContainer
 * v1.0
 *
 * Created by Thomas Hopstaken on 08-05-2019
 **/
public class AppDataContainer {

    private static AppDataContainer instance;
    private String userToken;

    private AppDataContainer() {
    }

    /**
     * Method for returning the current AppDataContainer instance singleton
     * @return AppDataContainer singleton
     */
    public static synchronized AppDataContainer getInstance() {
        // Check if instance exists, else create a new instance
        if (instance == null)
            instance = new AppDataContainer();

        return instance;
    }

    /**
     * Method for returning the user token
     * @return String user token
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Method for setting the user token
     * @param userToken String token to set the new user token to
     */
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
