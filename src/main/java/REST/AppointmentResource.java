/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.Appointment;
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
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("appointment")
@RequestScoped
public class AppointmentResource {

    @EJB
    UserBeanLocal ubl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AppointmentResource
     */
    public AppointmentResource() {
    }

    /**
     * Retrieves representation of an instance of REST.AppointmentResource
     *
     * @return an instance of java.lang.String
     */
   @GET
    @Path("/appointmentbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("id") Integer id) {
        return ubl.getAppointmentbyId(id);
    }

    @GET
    @Path("/appointmentbystatus/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAppointmentsByStatus(@PathParam("status") String status) {
        return ubl.getAppoinetmentbyStatus(status);
    }

    @GET
    @Path("/appointmentsbyuserid/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAppointmentsByUserId(@PathParam("userID") Integer userID) {
        return ubl.getAppoinetmentbyUserId(userID);
    }

    @GET
    @Path("/appointmentsbydealerid/{dealerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAppointmentsByDealerId(@PathParam("dealerID") Integer dealerID) {
        return ubl.getAppoinetmentbyDealerId(dealerID);
    }

    @GET
    @Path("/appointmentsbycarid/{carID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Appointment> getAppointmentsByCarId(@PathParam("carID") Integer carID) {
        return ubl.getAppoinetmentbyCarId(carID);
    }

    @POST
    @Path("/addappointment/{userID}/{dealerID}/{carID}/{status}")
    public void addAppointment(
            @PathParam("userID") Integer userID,
            @PathParam("dealerID") Integer dealerID,
            @PathParam("carID") Integer carID,
            @PathParam("status") String status) {
        ubl.addAppointment(userID, dealerID, carID, status);
    }

    @PUT
    @Path("/updateappointment/{id}/{userID}/{dealerID}/{carID}/{status}")
    public void updateAppointment(
            @PathParam("id") Integer id,
            @PathParam("userID") Integer userID,
            @PathParam("dealerID") Integer dealerID,
            @PathParam("carID") Integer carID,
            @PathParam("status") String status) {
        ubl.updateAppointment(id, userID, dealerID, carID, status);
    }

    @DELETE
    @Path("/removeappointment/{id}/{userID}/{dealerID}/{carID}")
    public void removeAppointment(
            @PathParam("id") Integer id,
            @PathParam("userID") Integer userID,
            @PathParam("dealerID") Integer dealerID,
            @PathParam("carID") Integer carID) {
        ubl.remmoveAppointment(id, userID, dealerID, carID);
    }

  
}

