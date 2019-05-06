package com.hoekbank.bank.desktop;

/**
 * BaseScreen
 * v1.1
 *
 * Created by Thomas Hopstaken on 23-10-2018
 **/
public abstract class BaseScreen {

    public static String imageBasePath = "/application/resources/images/";
    public static String videoBasePath = "/application/resources/videos/";
    public static String audioBasePath = "/application/resources/audio/";

    protected BaseScreen() {
        setupMainUI();
    }

    protected abstract void setupMainUI();
}
