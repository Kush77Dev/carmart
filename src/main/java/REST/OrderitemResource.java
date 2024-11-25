/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.CarOrder;
import entities.OrderItems;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("orderitem")
@RequestScoped
public class OrderitemResource {

    @EJB
    UserBeanLocal ubl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrderitemResource
     */
    public OrderitemResource() {
    }

    /**
     * Retrieves representation of an instance of REST.OrderitemResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello() {
        return "<h1>Hello world</h1>";
    }

    @GET
    @Path("/itembyid/{item_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderItems getOrderItemById(@PathParam("item_id") Integer item_id) {
        return ubl.getOrderItemById(item_id);

    }

    @GET
    @Path("/itembyorderid/{orderID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderItems> getItemByOrderId(@PathParam("orderID") Integer orderID) {
        return ubl.getItemByOrderId(orderID);

    }

    @GET
    @Path("/itembycarid/{carID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderItems> getItemByCarId(@PathParam("carID") Integer carID) {
        return ubl.getItemByCarId(carID);
    }

    @POST
    @Path("/addorderitem/{carId}/{orderId}")
    public void addItem(@PathParam("carId") Integer carId, @PathParam("orderId") Integer orderId) {
        ubl.addItem(carId, orderId);
    }

    @PUT
    @Path("/updateorderitem/{item_id}/{carId}/{orderId}")
    public void updateItem(@PathParam("item_id") Integer item_id, @PathParam("carId") Integer carId, @PathParam("orderId") Integer orderId) {
        ubl.updateItem(item_id, carId, orderId);
    }

    @DELETE
    @Path("/removeorderitem/{item_id}/{carId}/{orderId}")
    public void removeItem(@PathParam("item_id")Integer item_id,@PathParam("orderId") Integer orderId,@PathParam("carId") Integer carId){
        ubl.removeItem(item_id, orderId, carId);
    }

}
