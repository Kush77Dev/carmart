/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.OrderItems;
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
import javax.print.attribute.standard.Media;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("OrderItem")
@RequestScoped
public class OrderItemResource {
    
    @EJB UserBeanLocal ubl;

    @Context
    private UriInfo context;
    
    

    /**
     * Creates a new instance of OrderItemResource
     */
    public OrderItemResource() {
    }

    /**
     * Retrieves representation of an instance of REST.OrderItemResource
     * @return an instance of java.lang.String
     */
    
    @POST
    @Path("/additem/{carID}/{orderID}")
    public void addItem(@PathParam("carID") Integer carId, @PathParam("orderID")Integer orderId){
        ubl.addItem(carId, orderId);
    }
    
    @PUT
    @Path("/updateitem/{item_id}/{carID}/{orderID}")
    public void updateItem(@PathParam("item_id") Integer item_id,@PathParam("carID") Integer carId, @PathParam("orderID")Integer orderId){
        ubl.updateItem(item_id,carId, orderId);
    }
    
    @DELETE
    @Path("/removeitem/{item_id}/{orderID}/{carID}")
    public void removeItem(@PathParam("item_id") Integer item_id, @PathParam("orderID")Integer orderId,@PathParam("carID") Integer carId){
        ubl.removeItem(item_id,orderId, carId);
    }
    
    @GET
    @Path("/itembyid/{item_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderItems getOrderItemById(@PathParam("item_id") Integer item_id){
        return ubl.getOrderItemById(item_id);
    }
    
    @GET
    @Path("/itembycarid/{carID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderItems> getItemByCarId(@PathParam("carID") Integer carID){
        return ubl.getItemByCarId(carID);
    }
    
    @GET
    @Path("/itembyorderid/{orderID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderItems> getItemByOrderId(@PathParam("orderID") Integer orderID){
        return ubl.getItemByOrderId(orderID);
    }
    

}
