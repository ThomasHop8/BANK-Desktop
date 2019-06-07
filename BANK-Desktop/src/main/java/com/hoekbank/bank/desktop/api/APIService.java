package com.hoekbank.bank.desktop.api;

/**
 * APIService
 * v1.0
 *
 * Created by Thomas Hopstaken on 08-05-2019
 **/
public enum APIService {
    USER_CREATE("/user/create"),
    USER_REJECT("/user/reject"),
    USER_LOGIN("/user/login"),
    ACCOUNT_LIST("/account/get/all"),
    ACCOUNT_TRANSACTIONS("/account/get/transactions");

    private String url;

    APIService(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

}
