/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:DealerResource [dealer]<br>
 * USAGE:
 * <pre>
 *        dealer client = new dealer();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class dealer {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public dealer() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("dealer");
    }

    public <T> T getallDealersbyEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealersbyemail/{0}", new Object[]{email}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addDealer(String name, String adress, String phonenumber, String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adddealer/{0}/{1}/{2}/{3}", new Object[]{name, adress, phonenumber, email})).request().post(null);
    }

    public void updateDealer(String id, String name, String adress, String phonenumber, String email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatedealer/{0}/{1}/{2}/{3}/{4}", new Object[]{id, name, adress, phonenumber, email})).request().put(null);
    }

    public void removeDealer(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removedealer/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getallDealers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("dealers");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallDealersbyId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealersbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallDealersbyPhoneNumber(Class<T> responseType, String phonenumber) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealersbyphone/{0}", new Object[]{phonenumber}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallDealersbyaddress(Class<T> responseType, String adress) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealersbyaddress/{0}", new Object[]{adress}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getallDealersbyName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealersbyname/{0}", new Object[]{name}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
