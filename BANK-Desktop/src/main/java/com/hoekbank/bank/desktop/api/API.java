package com.hoekbank.bank.desktop.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hoekbank.bank.desktop.Hoekbank;
import com.hoekbank.bank.desktop.helpers.AppDataContainer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

public class API {

    private static API instance;
    private Client client;
    private WebResource webResource;

    private API() {
        client = Client.create();
    }

    public JsonElement post(APIService apiService, MultivaluedMap<String, String> formData) {
        webResource = client.resource(Hoekbank.BASE_URL + apiService.url());

        return new JsonParser().parse(makeRestCall(formData));
    }

    public static synchronized API getInstance( ) {
        if (instance == null)
            instance = new API();

        return instance;
    }

    private String makeRestCall(MultivaluedMap<String, String> formData) {
        AppDataContainer dataContainer = AppDataContainer.getInstance();
        ClientResponse response = webResource
                .header(HttpHeaders.AUTHORIZATION, "Bearer Token " + dataContainer.getUserToken())
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(ClientResponse.class, formData);

        if(response.getStatus() != 200)
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

        return response.getEntity(String.class);
    }
}
