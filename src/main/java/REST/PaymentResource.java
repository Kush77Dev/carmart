/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.Payment;
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
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("payment")
@RequestScoped
public class PaymentResource {

    @EJB
    UserBeanLocal ubl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PaymentResource
     */
    public PaymentResource() {
    }

    /**
     * Retrieves representation of an instance of REST.PaymentResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/addpayment/{orderID}/{paymentAmount}/{paymentMethod}")
    public void addPayment(@PathParam("orderID") Integer orderID, @PathParam("paymentAmount") Integer paymentAmount, @PathParam("paymentMethod") String paymentMethod) {

        ubl.addPayment(orderID, paymentAmount, paymentMethod);
    }

    @PUT
    @Path("/updatepayment/{id}/{orderID}/{paymentAmount}/{paymentMethod}")
    public void updatePayment(@PathParam("id") Integer id, @PathParam("orderID") Integer orderID, @PathParam("paymentAmount") Integer paymentAmount, @PathParam("paymentMethod") String paymentMethod) {
        ubl.updatePayment(id, orderID, paymentAmount, paymentMethod);
    }

    @DELETE
    @Path("/removepayment/{id}/{orderID}")
    public void removePayment(@PathParam("id") Integer id, @PathParam("orderID") Integer orderID) {
        ubl.removePayment(id, orderID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getpaymentbyid/{id}")
    public Payment getPaymentById(@PathParam("id") Integer id) {
        return ubl.getPaymentById(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getpaymentbyorderid/{orderID}")
    public Collection<Payment> getPaymentByOrderId(@PathParam("orderID") Integer orderID) {
        return ubl.getPaymentByOrderId(orderID);
    }

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("paymentbymethod/{paymentMethod}")
    public Collection<Payment> getPaymentByMethod(@PathParam("paymentMethod")String paymentMethod){
     return ubl.getPaymentByMethod(paymentMethod);
    }

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("paymentbydate/{paymentDate}")
    public Collection<Payment> getPaymentByDate(@PathParam("paymentDate")String paymentDate){
     try {
            // Parse the order date from string to Date object
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(paymentDate);

            // Call the EJB method to fetch orders by the parsed date
            return ubl.getPaymentByDate(parsedDate);

        } catch (ParseException e) {
// Handle exceptions (e.g., invalid date format)
                throw new WebApplicationException("Invalid date format. Please use yyyy-MM-dd.", 400);
        }
    }
}
