package com.hoekbank.bank.desktop.helpers;

import com.hoekbank.bank.desktop.enums.RegisterState;
import java.util.ArrayList;

/**
 * AppDataContainer
 * v1.0
 *
 * Created by Thomas Hopstaken on 08-05-2019
 **/
public class AppDataContainer {

    private static AppDataContainer instance;
    private String userToken;
    private String userID;
    private RegisterState registerState;
    private ArrayList<String> pages;

    private AppDataContainer() {
        pages = new ArrayList<>();
        pages.add("HOME");
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

    /**
     * Method for returning the user registerState
     * @return RegisterState registerState
     */
    public RegisterState getRegisterState() {
        return registerState;
    }

    /**
     * Method for setting the registerState
     * @param registerState RegisterState of current user
     */
    public void setRegisterState(RegisterState registerState) {
        this.registerState = registerState;
    }

    /**
     * Method for returning the userID
     * @return String userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Method for setting the userID
     * @param userID String id of the user
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Method for returning the application pages
     * @return ArrayList<String> application pages
     */
    public ArrayList<String> getPages() {
        return pages;
    }

    /**
     * Method for setting the application pages
     * @param pages ArrayList of all the pages
     */
    public void setPages(ArrayList<String> pages) {
        this.pages = pages;
    }
}
