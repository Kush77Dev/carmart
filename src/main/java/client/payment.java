/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PaymentResource [payment]<br>
 * USAGE:
 * <pre>
 *        payment client = new payment();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class payment {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public payment() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("payment");
    }

    public <T> T getPaymentByOrderId(Class<T> responseType, String orderID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpaymentbyorderid/{0}", new Object[]{orderID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPaymentByMethod(Class<T> responseType, String paymentMethod) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("paymentbymethod/{0}", new Object[]{paymentMethod}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPaymentByDate(Class<T> responseType, String paymentDate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("paymentbydate/{0}", new Object[]{paymentDate}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPayment(String orderID, String paymentAmount, String paymentMethod) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addpayment/{0}/{1}/{2}", new Object[]{orderID, paymentAmount, paymentMethod})).request().post(null);
    }

    public void updatePayment(String id, String orderID, String paymentAmount, String paymentMethod) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatepayment/{0}/{1}/{2}/{3}", new Object[]{id, orderID, paymentAmount, paymentMethod})).request().put(null);
    }

    public void removePayment(String id, String orderID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removepayment/{0}/{1}", new Object[]{id, orderID})).request().delete();
    }

    public <T> T getPaymentById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getpaymentbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
