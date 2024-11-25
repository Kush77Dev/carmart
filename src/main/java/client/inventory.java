/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:InventoryResource
 * [inventory]<br>
 * USAGE:
 * <pre>
 *        inventory client = new inventory();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class inventory {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public inventory() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("inventory");
    }

    public <T> T getInventoryById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeInventory(String id, String carID, String dealerID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remove/{0}/{1}/{2}", new Object[]{id, carID, dealerID})).request().delete();
    }

    public void updateInventory(String id, String carID, String dealerID, String quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("update/{0}/{1}/{2}/{3}", new Object[]{id, carID, dealerID, quantity})).request().put(null);
    }

    public void addInventory(String carID, String dealerID, String quantity) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("add/{0}/{1}/{2}", new Object[]{carID, dealerID, quantity})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
