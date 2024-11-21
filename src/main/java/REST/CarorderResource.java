/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.CarOrder;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("carorder")
@RequestScoped
public class CarorderResource {

    @Context
    private UriInfo context;

    @EJB
    UserBeanLocal ubl;

    /**
     * Creates a new instance of CarorderResource
     */
    public CarorderResource() {
    }

    /**
     * Retrieves representation of an instance of REST.CarorderResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/addorder/{userID}/{shippmentAddress}/{shippingPrice}/{totalPrice}/{isPaid}/{isDelivered}/{deliveredAt}")
    public Response addOrder(
            @PathParam("userID") Integer userID,
            @PathParam("shippmentAddress") String shippmentAddress,
            @PathParam("shippingPrice") Integer shippingPrice,
            @PathParam("totalPrice") Integer totalPrice,
            @PathParam("isPaid") Boolean isPaid,
            @PathParam("isDelivered") Boolean isDelivered,
            @PathParam("deliveredAt") String deliveredAt) {

        ubl.addOrder(userID, shippmentAddress, shippingPrice, totalPrice, isPaid, isDelivered, deliveredAt);
        return Response.status(Response.Status.CREATED).entity("Order added successfully.").build();
    }

    @PUT
    @Path("/updateorder/{id}/{userID}/{shippmentAddress}/{shippingPrice}/{totalPrice}/{isPaid}/{isDelivered}/{deliveredAt}")
    public Response updateOrder(
            @PathParam("id") Integer id,
            @PathParam("userID") Integer userID,
            @PathParam("shippmentAddress") String shippmentAddress,
            @PathParam("shippingPrice") Integer shippingPrice,
            @PathParam("totalPrice") Integer totalPrice,
            @PathParam("isPaid") Boolean isPaid,
            @PathParam("isDelivered") Boolean isDelivered,
            @PathParam("deliveredAt") String deliveredAt) {

        ubl.updateOrder(id, userID, shippmentAddress, shippingPrice, totalPrice, isPaid, isDelivered, deliveredAt);
        return Response.ok("Order updated successfully.").build();
    }

    @DELETE
    @Path("/removeorder/{id}/{userID}")
    public Response removeOrder(@PathParam("id") Integer id, @PathParam("userID") Integer userID) {
        ubl.removeOrder(id, userID);
        return Response.ok("Order removed successfully.").build();
    }

    @GET
    @Path("/getorderbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarOrderById(@PathParam("id") Integer id) {
        CarOrder order = ubl.getCarOrderById(id);
        return Response.ok(order).build();
    }

    @GET
    @Path("/getorderbyuserid/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarOrderByUserId(@PathParam("userID") Integer userID) {
        Collection<CarOrder> orders = ubl.getCarOrderByUserId(userID);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/getorderbydate/{orderDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarOrderByDate(@PathParam("orderDate") String orderDate) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(orderDate);
            Collection<CarOrder> orders = ubl.getCarOrderByDate(date);
            return Response.ok(orders).build();
        } catch (ParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format. Use yyyy-MM-dd.").build();
        }
    }

    @GET
    @Path("/getallorder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCarOrders() {
        Collection<CarOrder> orders = ubl.getAllCarorder();
        return Response.ok(orders).build();
    }
}
