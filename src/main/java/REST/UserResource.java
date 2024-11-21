///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
// */
//package REST;
//
//import ejb.UserBeanLocal;
//import entities.User;
//import javax.ejb.EJB;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.inject.Default;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import java.util.Collection;
//
///**
// * REST Web Service
// *
// * @author Kush Khakhiwala
// */
//@Path("user")
//@RequestScoped
//public class UserResource {
//
//    @EJB
//    UserBeanLocal ubl;
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of UserResource
//     */
//    public UserResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of REST.UserResource
//     *
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Default
//    @Produces(MediaType.TEXT_HTML)
//    public String sayhello() {
//        return "<h1> Hello World</h1>";
//    }
//
//    @GET
//    @Path("/users")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<User> getAllUsers() {
//        return ubl.getAllUsers();
//    }
//
//    @GET
//    @Path("/userbyid/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public User getUserbyId(@PathParam("id") Integer id) {
//        return ubl.getUserbyId(id);
//    }
//
//    @GET
//    @Path("/userbyname/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<User> getUserbyName(@PathParam("name") String name) {
//        return ubl.getUserbyName(name);
//    }
//
//    @GET
//    @Path("/userbyemail/{email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<User> getUserbyEmail(@PathParam("email") String email) {
//        return ubl.getUserbyEmail(email);
//    }
//
//    @POST
//    @Path("/adduser/{name}/{email}/{password}/{adress}/{phonenumber}")
//    public void addUser(@PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("adress") String adress, @PathParam("phonenumber") String phonenumber) {
//        ubl.addUser(name, email, password, adress, phonenumber);
//    }
//
//    @PUT
//    @Path("/updateuser/{id}/{name}/{email}/{password}/{adress}/{phonenumber}")
//    public void updateUser(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("email") String email, @PathParam("password") String password, @PathParam("adress") String adress, @PathParam("phonenumber") String phonenumber) {
//        ubl.updateUser(id, name, email, password, adress, phonenumber);
//    }
//
//    @DELETE
//    @Path("/removeuser/{id}")
//    public void removeUser(@PathParam("id") Integer id) {
//        ubl.removeUser(id);
//    }
//}
