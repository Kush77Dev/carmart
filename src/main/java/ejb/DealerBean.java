package ejb;

import entities.Appointment;
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

    public void addCar(String name, String image, String brand, String category, String description, int price, String model,
            int mileage, String color, int vin, Integer dealerID, boolean inStock) {
        Cars car = new Cars();
        Dealer dealer = em.find(Dealer.class, dealerID);
        Collection<Cars> carsOfDeal = dealer.getCarsCollection();

        car.setName(name);
        car.setImage(image);
        car.setBrand(brand);
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
        em.merge(dealer);
    }

    @Override
    public void updateCar(Integer id, String name, String image, String brand, String category, String description, int price, String model, int mileage, String color, int vin, int dealerID, boolean inStock) {
        Cars car = (Cars) em.find(Cars.class, id);
        Dealer dealer = (Dealer) em.find(Dealer.class, dealerID);

        car.setName(name);
        car.setImage(image);
        car.setBrand(brand);
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
    public void removeCar(Integer id, Integer dealerId) {
        Cars c = em.find(Cars.class, id);

        Dealer d = em.find(Dealer.class, dealerId);
        Collection<Cars> carsOfDealer = d.getCarsCollection();

        carsOfDealer.remove(c);
        em.merge(d);

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
    public Collection<Cars> getCarByBrand(String brand) {
        return em.createNamedQuery("Cars.findByBrand", Cars.class)
                .setParameter("brand", brand)
                .getResultList();
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
    public Cars getCarByPrice(int price) {
        return em.createNamedQuery("Cars.findByPrice", Cars.class)
                .setParameter("price", price)
                .getSingleResult();
    }

    @Override
    public Cars getCarByMileage(int mileage) {
        return em.createNamedQuery("Cars.findByMileage", Cars.class)
                .setParameter("mileage", mileage)
                .getSingleResult();
    }

    @Override
    public Collection<Dealer> getDealersofCars(int dealerID) {
        return em.createNamedQuery("Dealer.findByDealerID", Dealer.class)
                .setParameter("dealerID", dealerID)
                .getResultList();
    }

    @Override
    public Cars getCarByInStock(boolean inStock) {
        return em.createNamedQuery("Cars.findByInStock", Cars.class)
                .setParameter("inStock", inStock)
                .getSingleResult();
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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
         Dealer d=em.find(Dealer.class, dealerID);
        Collection<Inventory> inventoryOfDealer=d.getInventoryCollection();
        
        Cars c=em.find(Cars.class, carID);
        Collection<Inventory> inventoryOfCar=c.getInventoryCollection();
        
        Inventory i = new Inventory();
        i.setCarID(c);
        i.setDealerID(d);
        i.setQuantity(quantity);
        i.setDateAdded(new Date());
        em.persist(i);
        
        inventoryOfDealer.add(i);
        em.merge(i);
        
        inventoryOfCar.add(i);
        em.merge(i);
    }

    @Override
    public void updateInventory(Integer id, Integer carID, Integer dealerID, Integer quantity) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
         Cars car=em.find(Cars.class, carID);
         
         Dealer dealer = em.find(Dealer.class, dealerID);
         
         Inventory i = em.find(Inventory.class, id);
         
         i.setCarID(car);
         i.setDealerID(dealer);
         i.setQuantity(quantity);
         i.setDateAdded(new Date());
         
         if (dealer != null) {
            i.setDealerID(dealer); // Set the Dealer object
        }
         
         if (car != null) {
            i.setCarID(car); // Set the Dealer object
        }
         
         
         em.merge(i);
         
         
    }

    @Override
    public void removeInventory(Integer id, Integer carID, Integer dealerID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Inventory inventory = new Inventory();
        
        
        Dealer dealer= em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);
        
        Collection<Inventory> inventoryofDealer = dealer.getInventoryCollection();
        Collection<Inventory> inventoryofCar = car.getInventoryCollection();
        
        inventoryofCar.remove(car);
        inventoryofDealer.remove(dealer);
        
        em.merge(car);
        em.merge(dealer);
        
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
}
