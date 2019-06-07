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

/**
 * API
 * v1.0
 *
 * Created by Thomas Hopstaken on 08-05-2019
 **/
public class API {

    private static API instance;
    private Client client;
    private WebResource webResource;

    private API() {
        client = Client.create();
    }

    /**
     * Method for making a new post request
     * @param apiService API service type
     * @param formData API form data object
     * @return JsonObject with API return result
     */
    public JsonElement post(APIService apiService, MultivaluedMap<String, String> formData) {
        webResource = client.resource(Hoekbank.BASE_URL + apiService.url());

        return new JsonParser().parse(makeRestCall(formData));
    }

    /**
     * Method for returning the current API instance singleton
     * @return API singleton
     */
    public static synchronized API getInstance() {
        // Check if instance exists, else create a new instance
        if(instance == null)
            instance = new API();

        return instance;
    }


    /**
     * Private method for making the API rest call
     * @param formData API form data object
     * @return String response
     */
    private String makeRestCall(MultivaluedMap<String, String> formData) {
        // Fetching datacontainer to apply user auth token to the API request
        AppDataContainer dataContainer = AppDataContainer.getInstance();
        ClientResponse response = webResource
                .header(HttpHeaders.AUTHORIZATION, "Bearer Token " + dataContainer.getUserToken())
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(ClientResponse.class, formData);

        // Check if call was successful by checking the response status
        if(response.getStatus() != 200)
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

        // Return API response as String
        return response.getEntity(String.class);
    }
}
