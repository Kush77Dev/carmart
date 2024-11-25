/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBeanLocal;
import entities.User;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("user")
@RequestScoped
public class UserResource {
    
    @EJB
    UserBeanLocal ubl;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of REST.UserResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Default
    @Produces(MediaType.TEXT_HTML)
    public String sayhello() {
        return "<h1> Hello World</h1>";
    }
    
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers() {
        return ubl.getAllUsers();
    }
    
    @GET
    @Path("/userbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserbyId(@PathParam("id") Integer id) {
        return ubl.getUserbyId(id);
    }
    
    @GET
    @Path("/userbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUserbyName(@PathParam("name") String name) {
        return ubl.getUserbyName(name);
    }
    
    @GET
    @Path("/userbyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUserbyEmail(@PathParam("email") String email) {
        return ubl.getUserbyEmail(email);
    }
    
    @POST
    @Path("/adduser/{name}/{email}/{password}/{adress}/{phonenumber}/{groupMaster_id}")
    public void addUser(@PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("adress") String adress, @PathParam("phonenumber") String phonenumber, @PathParam("groupMaster_id") Integer groupMaster_id) {
        ubl.addUser(name, email, password, adress, phonenumber, groupMaster_id);
    }
    
    @PUT
    @Path("/updateuser/{id}/{name}/{email}/{password}/{adress}/{phonenumber}")
    public void updateUser(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("adress") String adress, @PathParam("phonenumber") String phonenumber) {
        ubl.updateUser(id, name, email, password, adress, phonenumber);
    }
    
    @DELETE
    @Path("/removeuser/{id}/{groupMaster_id}")
    public void removeUser(@PathParam("id") Integer id, @PathParam("groupMaster_id") Integer groupMaster_id) {
        ubl.removeUser(id, groupMaster_id);
    }
}
