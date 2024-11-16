///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
// */
//package REST;
//
//import ejb.UserBean;
//import ejb.UserBeanLocal;
//import jakarta.ejb.EJB;
//import jakarta.ws.rs.core.Context;
//import jakarta.ws.rs.core.UriInfo;
//import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.PUT;
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.PathParam;
//import jakarta.ws.rs.core.MediaType;
//import java.util.Date;
//
///**
// * REST Web Service
// *
// * @author Kush Khakhiwala
// */
//@Path("review")
//@RequestScoped
//public class ReviewResource {
//    
//    @EJB UserBeanLocal ubl;
//
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of ReviewResource
//     */
//    public ReviewResource() {
//        
//    }
//
//    /**
//     * Retrieves representation of an instance of REST.ReviewResource
//     * @return an instance of java.lang.String
//     */
//    @POST
//    @Path("/addreview/{userID}/{carID}/{rating}/{commment}}")
//    public void addReview(@PathParam("usedID") Integer userID,@PathParam("carID") Integer carID,@PathParam("rating") Integer rating,@PathParam("comment") String commment){
//        ubl.addReview(userID,carID,rating,commment);
//    }
//    
//        
//
//}
