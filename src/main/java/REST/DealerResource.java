/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.adminLocal;
import entities.Dealer;
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
@Path("dealer")
@RequestScoped
public class DealerResource {

    @EJB
    adminLocal adminbean;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DealerResource
     */
    public DealerResource() {
    }

    /**
     * Retrieves representation of an instance of REST.DealerResource
     *
     * @return an instance of java.lang.String
     */
    
    @POST
    @Path("/adddealer/{name}/{adress}/{phonenumber}/{email}/{groupMaster_id}")    
    public void addDealer(@PathParam("name")String name,@PathParam("adress") String adress,@PathParam("phonenumber") String phonenumber,@PathParam("email") String email,@PathParam("groupMaster_id") Integer groupMaster_id){
        adminbean.addDealer(name, adress, phonenumber, email, groupMaster_id);
    }
    
    @PUT
    @Path("/updatedealer/{id}/{name}/{adress}/{phonenumber}/{email}")
    public void updateDealer(@PathParam("id")Integer id,@PathParam("name") String name,@PathParam("adress") String adress,@PathParam("phonenumber") String phonenumber,@PathParam("email") String email){
        adminbean.updateDealer(id, name, adress, phonenumber, email);
    }
    
    
    @DELETE
    @Path("/removedealer/{id}")
    public void removeDealer(@PathParam("id")Integer id,@PathParam("groupMaster_id") Integer groupMaster_id){
        adminbean.removeDealer(id, groupMaster_id);
    }
    
    @GET
    @Path("/dealers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Dealer> getallDealers(){
        return adminbean.getallDealers();
    }   
    
    @GET
    @Path("/dealersbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Dealer> getallDealersbyName(@PathParam("name") String name){
        return adminbean.getallDealersbyName(name);
    }
    
    @GET
    @Path("/dealersbyaddress/{adress}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dealer getallDealersbyaddress(@PathParam("adress") String adress){
        return adminbean.getallDealersbyaddress(adress);
    }
    
    @GET
    @Path("/dealersbyphone/{phonenumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dealer getallDealersbyPhoneNumber(@PathParam("phonenumber") String phonenumber){
        return adminbean.getallDealersbyPhoneNumber(phonenumber);
    }
    
     @GET
     @Path("/dealersbyemail/{email}")
     @Produces(MediaType.APPLICATION_JSON)
     public Dealer getallDealersbyEmail(@PathParam("email") String email){
        return adminbean.getallDealersbyEmail(email);
     }
     
     @GET
     @Path("/dealersbyid/{id}")
     @Produces(MediaType.APPLICATION_JSON)
     public Dealer getallDealersbyId(@PathParam("id") Integer id){
        return adminbean.getallDealersbyId(id);
     }

//       @GET
//    @Path("/users")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<User> getAllUsers() {
//        return ubl.getAllUsers();
//    }

}
