package helpers;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

public class JerseyClientPost {

    public JerseyClientPost() {
        try {
            Client client = Client.create();

            WebResource webResource = client
                    .resource("https://hoekbank.tk/api/v1/user/create");

            MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
            formData.add("user", "{\"firstname\":\"test123\",\"lastname\":\"Back\"}");
            ClientResponse response = webResource
                    .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                    .post(ClientResponse.class, formData);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Output from Server ....");
            String output = response.getEntity(String.class);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
