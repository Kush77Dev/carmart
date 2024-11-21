package REST;

import ejb.DealerBeanLocal;
import ejb.adminLocal;
import entities.Brand;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;
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
