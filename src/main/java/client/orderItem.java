/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:OrderitemResource
 * [orderitem]<br>
 * USAGE:
 * <pre>
 *        orderItem client = new orderItem();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class orderItem {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public orderItem() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("orderitem");
    }

    public <T> T getItemByCarId(Class<T> responseType, String carID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("itembycarid/{0}", new Object[]{carID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addItem(String carId, String orderId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addorderitem/{0}/{1}", new Object[]{carId, orderId})).request().post(null);
    }

    public void removeItem(String item_id, String carId, String orderId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeorderitem/{0}/{1}/{2}", new Object[]{item_id, carId, orderId})).request().delete();
    }

    public String sayHello() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(jakarta.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public <T> T getOrderItemById(Class<T> responseType, String item_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("itembyid/{0}", new Object[]{item_id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateItem(String item_id, String carId, String orderId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateorderitem/{0}/{1}/{2}", new Object[]{item_id, carId, orderId})).request().put(null);
    }

    public <T> T getItemByOrderId(Class<T> responseType, String orderID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("itembyorderid/{0}", new Object[]{orderID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
