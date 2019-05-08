package com.hoekbank.bank.desktop.api;

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
