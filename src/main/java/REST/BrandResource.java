package REST;

import ejb.DealerBeanLocal;
import ejb.adminLocal;
import entities.Brand;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST Web Service for Brand entity
 *
 * @author Kush Khakhiwala
 */
@Path("brand")
@RequestScoped
public class BrandResource {

    @EJB
    DealerBeanLocal dealer;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BrandResource
     */
    public BrandResource() {
    }

    /**
     * Add a new Brand
     */
    @POST
    @Path("/addbrand/{name}/{image}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBrand(@PathParam("name") String name, @PathParam("image") String image) {
        dealer.addBrand(name, image);
    }

    /**
     * Update an existing Brand by id
     */
    @PUT
    @Path("/updatebrand/{id}/{name}/{image}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateBrand(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("image") String image) {
        dealer.updateBrand(id, name, image);
    }

    /**
     * Remove a Brand by id
     */
    @DELETE
    @Path("/removebrand/{id}")
    public void removeBrand(@PathParam("id") Integer id) {
        dealer.removeBrand(id);
    }

    /**
     * Get a Brand by its id
     */
    @GET
    @Path("/brandbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Brand brandById(@PathParam("id") Integer id) {
        return dealer.brandById(id);
    }

    /**
     * Get all Brands
     */
    @GET
    @Path("/brands")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brand> getAllBrand() {
        return dealer.getAllBrand();
    }

    /**
     * Get Brands by name
     */
    @GET
    @Path("/brandsbyname/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brand> getBrandByName(@PathParam("name") String name) {
        return dealer.getBrandByName(name);
    }
}
