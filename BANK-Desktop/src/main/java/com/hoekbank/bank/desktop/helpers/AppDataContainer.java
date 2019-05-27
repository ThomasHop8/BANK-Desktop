package com.hoekbank.bank.desktop.helpers;

import com.hoekbank.bank.desktop.enums.RegisterState;

import java.util.ArrayList;

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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArrayList<String> getPages() {
        return pages;
    }

    public void setPages(ArrayList<String> pages) {
        this.pages = pages;
    }
}
