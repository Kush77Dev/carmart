/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:BrandResource [brand]<br>
 * USAGE:
 * <pre>
 *        brand client = new brand();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class brand {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public brand() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("brand");
    }

    public <T> T getBrandByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("brandsbyname/{0}", new Object[]{name}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T brandById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("brandbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllBrand(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("brands");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeBrand(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removebrand/{0}", new Object[]{id})).request().delete();
    }

    public void updateBrand(Object requestEntity, String id, String name, String image) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatebrand/{0}/{1}/{2}", new Object[]{id, name, image})).request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).put(jakarta.ws.rs.client.Entity.entity(requestEntity, jakarta.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addBrand(Object requestEntity, String name, String image) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addbrand/{0}/{1}", new Object[]{name, image})).request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).post(jakarta.ws.rs.client.Entity.entity(requestEntity, jakarta.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
    
}
