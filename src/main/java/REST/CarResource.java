/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.DealerBeanLocal;
import entities.Cars;
import entities.Dealer;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("car")
@RequestScoped
public class CarResource {

    @EJB
    DealerBeanLocal dbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarResource
     */
    public CarResource() {
    }

    /**
     * Retrieves representation of an instance of REST.CarResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("addcar/{name}/{image}/{brandID}/{category}/{description}/{price}/{model}/{mileage}/{color}/{vin}/{dealerID}/{inStock}")
    public void addCar(@PathParam("name") String name, @PathParam("image") String image, @PathParam("brandID") Integer brandID,
            @PathParam("category") String category, @PathParam("description") String description,
            @PathParam("price") int price, @PathParam("model") String model, @PathParam("mileage") int mileage,
            @PathParam("color") String color, @PathParam("vin") int vin, @PathParam("dealerID") Integer dealerID,
            @PathParam("inStock") boolean inStock) {
        dbl.addCar(name, image, brandID, category, description, price, model, mileage, color, vin, dealerID, inStock);
    }

    @PUT
    @Path("updatecar/{id}/{name}/{image}/{brandID}/{category}/{description}/{price}/{model}/{mileage}/{color}/{vin}/{dealerID}/{inStock}")
    public void updateCar(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("image") String image, @PathParam("brandID") Integer brandID,
            @PathParam("category") String category, @PathParam("description") String description,
            @PathParam("price") int price, @PathParam("model") String model, @PathParam("mileage") int mileage,
            @PathParam("color") String color, @PathParam("vin") int vin, @PathParam("dealerID") Integer dealerID,
            @PathParam("inStock") boolean inStock) {
        dbl.updateCar(id, name, image, brandID, category, description, price, model, mileage, color, vin, dealerID, inStock);
    }

    @DELETE
    @Path("removecar/{id}/{dealerID}/{brandID}")
    public void removeCar(@PathParam("id") Integer id, @PathParam("dealerID") Integer dealerID,@PathParam("brandID") Integer brandID) {
        dbl.removeCar(id, dealerID,brandID);
    }

    @GET
    @Path("/carsbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByName(@PathParam("name") String name) {
        return dbl.getCarByName(name);
    }

    @GET
    @Path("/carsbybrandid/{brandID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByBrandid(@PathParam("brandID") Integer brandID) {
        return dbl.getCarByBrandid(brandID);
    }

    @GET
    @Path("/carsbycategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByCategory(@PathParam("category") String category) {
        return dbl.getCarByCategory(category);
    }

    @GET
    @Path("/carsbycolor/{color}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByColor(@PathParam("color") String color) {
        return dbl.getCarByColor(color);
    }

    @GET
    @Path("/carsbymodel/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByModel(@PathParam("model") String model) {
        return dbl.getCarByModel(model);
    }

    @GET
    @Path("/carbyprice/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByPrice(@PathParam("price") Integer price) {
        return dbl.getCarByPrice(price);
    }

    @GET
    @Path("/carbymileage/{mileage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByMileage(@PathParam("mileage") Integer mileage) {
        return dbl.getCarByMileage(mileage);
    }

//    @GET
//    @Path("/dealersofcars/{dealerID}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Dealer> getDealersofCars(@PathParam("dealerID") Integer dealerID) {
//        return dbl.getDealersofCars(dealerID);
//    }

    @GET
    @Path("/allcars")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getAllCars() {
        return dbl.getAllCars();
    }

    @GET
    @Path("/carbystock/{inStock}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarByInStock(@PathParam("inStock") Boolean inStock) {
        return dbl.getCarByInStock(inStock);
    }

    @GET
    @Path("/carsbydealerid/{dealerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cars> getCarsByDealerId(@PathParam("dealerId") Integer dealerId) {
        return dbl.getCarsByDealerId(dealerId);
    }

}
