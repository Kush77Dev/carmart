/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:CarResource [car]<br>
 * USAGE:
 * <pre>
 *        cars client = new cars();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maharaja
 */
public class cars {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/carmart/resources";

    public cars() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("car");
    }

    public <T> T getCarByCategory(Class<T> responseType, String category) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbycategory/{0}", new Object[]{category}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarByInStock(Class<T> responseType, String inStock) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carbystock/{0}", new Object[]{inStock}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCar(String name, String image, String brandID, String category, String description, String price, String model, String mileage, String color, String vin, String dealerID, String inStock) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcar/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{name, image, brandID, category, description, price, model, mileage, color, vin, dealerID, inStock})).request().post(null);
    }

    public <T> T getCarByName(Class<T> responseType, String name) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbyname/{0}", new Object[]{name}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCars(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcars");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarsByDealerId(Class<T> responseType, String dealerId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbydealerid/{0}", new Object[]{dealerId}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarByBrandid(Class<T> responseType, String brandID) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbybrandid/{0}", new Object[]{brandID}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarByModel(Class<T> responseType, String model) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbymodel/{0}", new Object[]{model}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarByMileage(Class<T> responseType, String mileage) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carbymileage/{0}", new Object[]{mileage}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCarByPrice(Class<T> responseType, String price) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carbyprice/{0}", new Object[]{price}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCar(String id, String name, String image, String brandID, String category, String description, String price, String model, String mileage, String color, String vin, String dealerID, String inStock) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecar/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{id, name, image, brandID, category, description, price, model, mileage, color, vin, dealerID, inStock})).request().put(null);
    }

    public <T> T getCarByColor(Class<T> responseType, String color) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("carsbycolor/{0}", new Object[]{color}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCar(String id, String dealerID, String brandID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removecar/{0}/{1}/{2}", new Object[]{id, dealerID, brandID})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
