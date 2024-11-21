///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
// */
//package REST;
//
//import ejb.adminLocal;
//import entities.Dealer;
//import javax.ejb.EJB;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Produces;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PUT;
//import javax.enterprise.context.RequestScoped;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.POST;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.MediaType;
//import java.util.Collection;
//
///**
// * REST Web Service
// *
// * @author Kush Khakhiwala
// */
//@Path("dealer")
//@RequestScoped
//public class DealerResource {
//
//    @EJB
//    adminLocal adminbean;
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of DealerResource
//     */
//    public DealerResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of REST.DealerResource
//     *
//     * @return an instance of java.lang.String
//     */
//    
//    @POST
//    @Path("/adddealer/{name}/{adress}/{phonenumber}/{email}")    
//    public void addDealer(@PathParam("name")String name,@PathParam("adress") String adress,@PathParam("phonenumber") String phonenumber,@PathParam("email") String email){
//        adminbean.addDealer(name, adress, phonenumber, email);
//    }
//    
//    @PUT
//    @Path("/updatedealer/{id}/{name}/{adress}/{phonenumber}/{email}")
//    public void updateDealer(@PathParam("id")Integer id,@PathParam("name") String name,@PathParam("adress") String adress,@PathParam("phonenumber") String phonenumber,@PathParam("email") String email){
//        adminbean.updateDealer(id, name, adress, phonenumber, email);
//    }
//    
//    
//    @DELETE
//    @Path("/removedealer/{id}")
//    public void removeDealer(@PathParam("id")Integer id){
//        adminbean.removeDealer(id);
//    }
//    
//    @GET
//    @Path("/dealers")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Dealer> getallDealers(){
//        return adminbean.getallDealers();
//    }   
//    
//    @GET
//    @Path("/dealersbyname/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Collection<Dealer> getallDealersbyName(@PathParam("name") String name){
//        return adminbean.getallDealersbyName(name);
//    }
//    
//    @GET
//    @Path("/dealersbyaddress/{adress}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Dealer getallDealersbyaddress(@PathParam("adress") String adress){
//        return adminbean.getallDealersbyaddress(adress);
//    }
//    
//    @GET
//    @Path("/dealersbyphone/{phonenumber}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Dealer getallDealersbyPhoneNumber(@PathParam("phonenumber") String phonenumber){
//        return adminbean.getallDealersbyPhoneNumber(phonenumber);
//    }
//    
//     @GET
//     @Path("/dealersbyemail/{email}")
//     @Produces(MediaType.APPLICATION_JSON)
//     public Dealer getallDealersbyEmail(@PathParam("email") String email){
//        return adminbean.getallDealersbyEmail(email);
//     }
//     
//     @GET
//     @Path("/dealersbyid/{id}")
//     @Produces(MediaType.APPLICATION_JSON)
//     public Dealer getallDealersbyId(@PathParam("id") Integer id){
//        return adminbean.getallDealersbyId(id);
//     }
//
////       @GET
////    @Path("/users")
////    @Produces(MediaType.APPLICATION_JSON)
////    public Collection<User> getAllUsers() {
////        return ubl.getAllUsers();
////    }
//
//}
