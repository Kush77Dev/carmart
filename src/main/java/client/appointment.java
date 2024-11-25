/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AppointmentResource
 * [appointment]<br>
 * USAGE:
 * <pre>
 *        appointment client = new appointment();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class appointment {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public appointment() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("appointment");
    }

    public <T> T getAppointmentsByUserId(Class<T> responseType, String userID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("appointmentsbyuserid/{0}", new Object[]{userID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAppointment(String id, String userID, String dealerID, String carID, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateappointment/{0}/{1}/{2}/{3}/{4}", new Object[]{id, userID, dealerID, carID, status})).request().put(null);
    }

    public void addAppointment(String userID, String dealerID, String carID, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addappointment/{0}/{1}/{2}/{3}", new Object[]{userID, dealerID, carID, status})).request().post(null);
    }

    public <T> T getAppointmentById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("appointmentbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAppointmentsByStatus(Class<T> responseType, String status) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("appointmentbystatus/{0}", new Object[]{status}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeAppointment(String id, String userID, String dealerID, String carID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeappointment/{0}/{1}/{2}/{3}", new Object[]{id, userID, dealerID, carID})).request().delete();
    }

    public <T> T getAppointmentsByCarId(Class<T> responseType, String carID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("appointmentsbycarid/{0}", new Object[]{carID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAppointmentsByDealerId(Class<T> responseType, String dealerID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("appointmentsbydealerid/{0}", new Object[]{dealerID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
