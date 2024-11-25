package ejb;

import entities.Appointment;
import entities.Brand;
import entities.Cars;
import entities.Dealer;
import entities.Inventory;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @Author Kush Khakhiwala
 */
@Stateless
public class DealerBean implements DealerBeanLocal {

    @PersistenceContext(unitName = "carmart_unit")
    private EntityManager em;

    @Override
    public void addCar(String name, String image, Integer brandID, String category, String description, int price, String model, int mileage, String color, int vin, Integer dealerID, boolean inStock) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Cars car = new Cars();
        Dealer dealer = em.find(Dealer.class, dealerID);
        Brand brand = em.find(Brand.class, brandID);
        Collection<Cars> carsOfDeal = dealer.getCarsCollection();
        Collection<Cars> carsOfbrand = brand.getCarsCollection();

        car.setName(name);
        car.setImage(image);
        car.setBrandID(brand);
        car.setCategory(category);
        car.setDescription(description);
        car.setPrice(price);
        car.setModel(model);
        car.setMilage(mileage);
        car.setColor(color);
        car.setVin(vin);
        car.setDealerID(dealer);
        car.setInStock(inStock);
        em.persist(car);

        carsOfDeal.add(car);
        dealer.setCarsCollection(carsOfDeal);
        brand.setCarsCollection(carsOfDeal);
        em.merge(dealer);
        em.merge(brand);

    }

    @Override
    public void updateCar(Integer id, String name, String image, Integer brandID, String category, String description, int price, String model, int mileage, String color, int vin, int dealerID, boolean inStock) {
        Cars car = (Cars) em.find(Cars.class, id);
        Dealer dealer = (Dealer) em.find(Dealer.class, dealerID);
        Brand brand = em.find(Brand.class, brandID);

        car.setName(name);
        car.setImage(image);
        car.setBrandID(brand);
        car.setCategory(category);
        car.setDescription(description);
        car.setPrice(price);
        car.setModel(model);
        car.setMilage(mileage);
        car.setColor(color);
        car.setVin(vin);
        car.setInStock(inStock);

        if (dealer != null) {
            car.setDealerID(dealer); // Set the Dealer object
        }

        em.merge(car); // Persist changes

    }

    @Override
    public void removeCar(Integer id, Integer dealerId, Integer brandID) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Cars c = em.find(Cars.class, id);

        Dealer d = em.find(Dealer.class, dealerId);
        Collection<Cars> carsOfDealer = d.getCarsCollection();

        Brand brand = em.find(Brand.class, brandID);
        Collection<Cars> carsOfBrand = brand.getCarsCollection();

        carsOfDealer.remove(c);
        em.merge(d);

        carsOfBrand.remove(c);
        em.merge(brand);

        em.remove(c);
    }

    @Override
    public Cars getCarById(Integer id) {
        return em.find(Cars.class, id);
    }

    @Override
    public Collection<Cars> getCarByName(String name) {
        return em.createNamedQuery("Cars.findByName", Cars.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Collection<Cars> getCarByBrandid(Integer brandID) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Brand b = em.find(Brand.class, brandID);
        return b.getCarsCollection();

    }

    @Override
    public Collection<Cars> getCarByCategory(String category) {
        return em.createNamedQuery("Cars.findByCategory", Cars.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public Collection<Cars> getCarByColor(String color) {
        return em.createNamedQuery("Cars.findByColor", Cars.class)
                .setParameter("color", color)
                .getResultList();
    }

    @Override
    public Collection<Cars> getCarByModel(String model) {
        return em.createNamedQuery("Cars.findByModel", Cars.class)
                .setParameter("model", model)
                .getResultList();
    }

    @Override
    public Collection<Cars> getCarByPrice(Integer price) {
        return em.createNamedQuery("Cars.findByPrice", Cars.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public Collection<Cars> getCarByMileage(Integer mileage) {
        return em.createNamedQuery("Cars.findByMilage", Cars.class)
                .setParameter("milage", mileage)
                .getResultList();
    }

//    @Override
//    public Collection<Dealer> getDealersofCars(Integer dealerID) {
//        return em.createNamedQuery("Dealer.findByDealerID", Dealer.class)
//                .setParameter("dealerID", dealerID)
//                .getResultList();
//    }
    @Override
    public Collection<Cars> getCarByInStock(Boolean inStock) {
        return em.createNamedQuery("Cars.findByInStock", Cars.class)
                .setParameter("inStock", inStock)
                .getResultList();
    }

    @Override
    public Collection<Cars> getAllCars() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Collection<Cars> car = em.createNamedQuery("Cars.findAll").getResultList();
        return car;
    }

    @Override
    public Collection<Cars> getCarsByDealerId(Integer dealerId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Dealer d = em.find(Dealer.class, dealerId);
        return d.getCarsCollection();
    }

    @Override
    public Collection<Cars> searchCarByName(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("Cars.findByName", Cars.class)
                .setParameter("name", name)
                .getResultList();

    }

    @Override
    public void addInventory(Integer carID, Integer dealerID, Integer quantity) {
        // Find the associated entities
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Create a new Inventory entity
        Inventory inventory = new Inventory();
        inventory.setCarID(car);
        inventory.setDealerID(dealer);
        inventory.setQuantity(quantity);
        inventory.setDateAdded(new Date());

        // Persist the new inventory
        em.persist(inventory);

        // Update the collections for dealer and car
        if (dealer != null) {
            dealer.getInventoryCollection().add(inventory);
            em.merge(dealer);
        }
        if (car != null) {
            car.getInventoryCollection().add(inventory);
            em.merge(car);
        }
    }

    @Override
    public void updateInventory(Integer id, Integer carID, Integer dealerID, Integer quantity) {
        // Find the existing inventory
        Inventory inventory = em.find(Inventory.class, id);

        // Find the associated entities
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Update the associations and attributes
        if (dealer != null) {
            inventory.setDealerID(dealer);
        }
        if (car != null) {
            inventory.setCarID(car);
        }

        inventory.setQuantity(quantity);
        inventory.setDateAdded(new Date());

        // Merge the updated inventory
        em.merge(inventory);
    }

    @Override
    public void removeInventory(Integer id, Integer carID, Integer dealerID) {
        // Find the inventory to remove
        Inventory inventory = em.find(Inventory.class, id);

        // Find the associated entities
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Remove the inventory from the collections
        if (dealer != null) {
            dealer.getInventoryCollection().remove(inventory);
            em.merge(dealer);
        }
        if (car != null) {
            car.getInventoryCollection().remove(inventory);
            em.merge(car);
        }

        // Finally, remove the inventory entity
        em.remove(inventory);
    }

    @Override
    public Inventory inventorybyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(Inventory.class, id);
    }

    @Override
    public Collection<Inventory> getAllInventory() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Collection<Inventory> car = em.createNamedQuery("Inventory.findAll").getResultList();
        return car;
    }

    @Override
    public void addBrand(String name, String image) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Brand b = new Brand();
        b.setName(name);
        b.setImage(image);

        em.persist(b);

    }

    @Override
    public void updateBrand(Integer id, String name, String image) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Brand b = em.find(Brand.class, id);

        b.setName(name);
        b.setImage(image);

        em.merge(b);

    }

    @Override
    public void removeBrand(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Brand b = em.find(Brand.class, id);
        if (b != null) {
            em.remove(b);
        }
    }

    @Override
    public Brand brandById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.find(Brand.class, id);

    }

    @Override
    public Collection<Brand> getAllBrand() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("Brand.findAll", Brand.class).getResultList();
    }

    @Override
    public Collection<Brand> getBrandByName(String name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Brand.findByName", Brand.class)
                .setParameter("name", name)
                .getResultList();
    }

}
