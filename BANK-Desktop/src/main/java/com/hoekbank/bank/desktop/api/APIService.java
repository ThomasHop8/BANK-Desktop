package com.hoekbank.bank.desktop.api;

/**
 * APIService
 * v1.0
 *
 * Created by Thomas Hopstaken on 08-05-2019
 **/
public enum APIService {
    USER_CREATE("/user/create"),
    USER_LOGIN("/user/login");

    private String url;

    APIService(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
