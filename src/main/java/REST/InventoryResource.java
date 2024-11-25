/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.DealerBeanLocal;
import entities.Inventory;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("inventory")
@RequestScoped
public class InventoryResource {
    
    @EJB
    DealerBeanLocal dbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InventoryResource
     */
    public InventoryResource() {
    }

    /**
     * Retrieves representation of an instance of REST.InventoryResource
     * @return an instance of java.lang.String
     */
    
    @POST
    @Path("/add/{carID}/{dealerID}/{quantity}")
    public void addInventory(
        @PathParam("carID") Integer carID,
        @PathParam("dealerID") Integer dealerID,
        @PathParam("quantity") Integer quantity
    ) {
        dbl.addInventory(carID, dealerID, quantity);
    }

    @PUT
    @Path("/update/{id}/{carID}/{dealerID}/{quantity}")
    public void updateInventory(
        @PathParam("id") Integer id,
        @PathParam("carID") Integer carID,
        @PathParam("dealerID") Integer dealerID,
        @PathParam("quantity") Integer quantity
    ) {
        dbl.updateInventory(id, carID, dealerID, quantity);
    }

    @DELETE
    @Path("/remove/{id}/{carID}/{dealerID}")
    public void removeInventory(
        @PathParam("id") Integer id,
        @PathParam("carID") Integer carID,
        @PathParam("dealerID") Integer dealerID
    ) {
        dbl.removeInventory(id, carID, dealerID);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Inventory getInventoryById(@PathParam("id") Integer id) {
        return dbl.inventorybyId(id);
    }

//    @GET
//    @Path("/dealer/{dealerID}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Inventory> getInventoryByDealerId(@PathParam("dealerID") Integer dealerID) {
//        return dbl.getInventoryByDealerId(dealerID);
//    }
//
//    @GET
//    @Path("/car/{carID}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Inventory> getInventoryByCarId(@PathParam("carID") Integer carID) {
//        return dbl.getInventoryByCarId(carID);
//    }
    
}
