/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.UserBean;
import ejb.UserBeanLocal;
import entities.Cars;
import entities.Payment;
import entities.Review;
import entities.User;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * REST Web Service
 *
 * @author Kush Khakhiwala
 */
@Path("review")
@RequestScoped
public class ReviewResource {

    @EJB
    UserBeanLocal ubl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReviewResource
     */
    public ReviewResource() {

    }

    /**
     * Retrieves representation of an instance of REST.ReviewResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/addreview/{userID}/{carID}/{rating}/{commment}")
    public void addReview(@PathParam("userID") Integer userID, @PathParam("carID") Integer carID, @PathParam("rating") Integer rating, @PathParam("commment") String commment) {
        ubl.addReview(userID, carID, rating, commment);
    }

    @PUT
    @Path("/updatereview/{id}/{userID}/{carID}/{rating}/{commment}")
    public void updateReview(@PathParam("id") Integer id, @PathParam("userID") Integer userID, @PathParam("carID") Integer carID, @PathParam("rating") Integer rating, @PathParam("commment") String commment) {
        ubl.updateReview(id, userID, carID, rating, commment);
    }

    @DELETE
    @Path("/removereview/{id}/{userID}/{carID}")
    public void removeReview(@PathParam("id") Integer id, @PathParam("userID") Integer userID, @PathParam("carID") Integer carID) {
        ubl.removeReview(id, userID, carID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getreviewbyid/{id}")
    public Review getReviewbyId(@PathParam("id") Integer id) {
        return ubl.getReviewbyId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getreviewbyuserid/{userID}")
    public Collection<Review> getReviewbyUserId(@PathParam("userID")Integer userId) {
        return ubl.getReviewbyUserId(userId);
    }
    
    @GET
    @Path("/getreviewbycarid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Review> getReviewbyCarId(@PathParam("id") Integer carId) {
        return ubl.getReviewbyCarId(carId);
    }


    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("reviewbydate/{reviewDate}")
    public Collection<Review> getReviewByDate(@PathParam("reviewDate")String reviewDate){
     try {
            // Parse the order date from string to Date object
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(reviewDate);

            // Call the EJB method to fetch orders by the parsed date
            return ubl.getReviewByDate(parsedDate);

        } catch (ParseException e) {
// Handle exceptions (e.g., invalid date format)
                throw new WebApplicationException("Invalid date format. Please use yyyy-MM-dd.", 400);
        }
    }


}
