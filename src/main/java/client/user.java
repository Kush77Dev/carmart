/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserResource [user]<br>
 * USAGE:
 * <pre>
 *        user client = new user();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class user {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public user() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }

    public String sayhello() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(jakarta.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("users");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeUser(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeuser/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getUserbyName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userbyname/{0}", new Object[]{name}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String name, String email, String password, String adress, String phonenumber) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}/{4}", new Object[]{name, email, password, adress, phonenumber})).request().post(null);
    }

    public void updateUser(String id, String name, String email, String password, String adress, String phonenumber) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateuser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{id, name, email, password, adress, phonenumber})).request().put(null);
    }

    public <T> T getUserbyId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserbyEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userbyemail/{0}", new Object[]{email}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
