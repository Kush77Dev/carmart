/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:CarorderResource
 * [carorder]<br>
 * USAGE:
 * <pre>
 *        carorder client = new carorder();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class carorder {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public carorder() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("carorder");
    }

    public <T> T getAllCarOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallorder");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarOrderByDate(Class<T> responseType, String orderDate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getorderbydate/{0}", new Object[]{orderDate}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response removeOrder(String id, String userID) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("removeorder/{0}/{1}", new Object[]{id, userID})).request().delete(Response.class);
    }

    public <T> T getCarOrderById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getorderbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarOrderByUserId(Class<T> responseType, String userID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getorderbyuserid/{0}", new Object[]{userID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response addOrder(String userID, String shippmentAddress, String shippingPrice, String totalPrice, String isPaid, String isDelivered, String deliveredAt) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addorder/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{userID, shippmentAddress, shippingPrice, totalPrice, isPaid, isDelivered, deliveredAt})).request().post(null, Response.class);
    }

    public Response updateOrder(String id, String userID, String shippmentAddress, String shippingPrice, String totalPrice, String isPaid, String isDelivered, String deliveredAt) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateorder/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{id, userID, shippmentAddress, shippingPrice, totalPrice, isPaid, isDelivered, deliveredAt})).request().put(null, Response.class);
    }

    public void close() {
        client.close();
    }
    
}
