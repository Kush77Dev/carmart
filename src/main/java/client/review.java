/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ReviewResource [review]<br>
 * USAGE:
 * <pre>
 *        review client = new review();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class review {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public review() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("review");
    }

    public <T> T getReviewbyUserId(Class<T> responseType, String userID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getreviewbyuserid/{0}", new Object[]{userID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviewbyId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getreviewbyid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReviewbyCarId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getreviewbycarid/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeReview(String id, String userID, String carID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removereview/{0}/{1}/{2}", new Object[]{id, userID, carID})).request().delete();
    }

    public <T> T getReviewByDate(Class<T> responseType, String reviewDate) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("reviewbydate/{0}", new Object[]{reviewDate}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addReview(String userID, String carID, String rating, String commment) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addreview/{0}/{1}/{2}/{3}", new Object[]{userID, carID, rating, commment})).request().post(null);
    }

    public void updateReview(String id, String userID, String carID, String rating, String commment) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatereview/{0}/{1}/{2}/{3}/{4}", new Object[]{id, userID, carID, rating, commment})).request().put(null);
    }

    public void close() {
        client.close();
    }
    
}
