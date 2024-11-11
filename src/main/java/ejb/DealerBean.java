package ejb;

import entities.Cars;
import entities.Dealer;
import entities.Review;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 * 
 * @Author Kush Khakhiwala
 */
@Stateless
public class DealerBean implements DealerBeanLocal {

    @PersistenceContext(unitName = "carmart_unit")
    private EntityManager em;

    @Override
  

public void addCar(String name, String image, String brand, String category, String description, int price, String model, int mileage, String color, int vin, Integer dealerID, boolean inStock) {
    Cars car = new Cars();
    Dealer dealer = em.find(Dealer.class, dealerID);
  
    
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
}


    @Override
   public void updateCar(Integer id, String name, String image, String brand, String category, String description, int price, String model, int mileage, String color, int vin, int dealerID, boolean inStock) {
    Cars car = em.find(Cars.class, id);
    
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

        // Retrieve Dealer and Review entities by ID
        Dealer dealer = em.find(Dealer.class, dealerID);
        

        if (dealer != null) {
            car.setDealerID(dealer); // Set the Dealer object
        }
      

        em.merge(car); // Persist changes
    
}

    @Override
    public void removeCar(Integer id) {
        Cars car = em.find(Cars.class, id);
        if (car != null) {
            em.remove(car);
        }
    }

    @Override
    public Cars getCarById(Integer id) {
        return em.find(Cars.class, id);
    }

    @Override
    public Cars getCarByName(String name) {
        return em.createNamedQuery("Cars.findByName", Cars.class)
                 .setParameter("name", name)
                 .getSingleResult();
    }

    @Override
    public Cars getCarByBrand(String brand) {
        return em.createNamedQuery("Cars.findByBrand", Cars.class)
                 .setParameter("brand", brand)
                 .getSingleResult();
    }

    @Override
    public Cars getCarByCategory(String category) {
        return em.createNamedQuery("Cars.findByCategory", Cars.class)
                 .setParameter("category", category)
                 .getSingleResult();
    }

    @Override
    public Cars getCarByColor(String color) {
        return em.createNamedQuery("Cars.findByColor", Cars.class)
                 .setParameter("color", color)
                 .getSingleResult();
    }

    @Override
    public Cars getCarByModel(String model) {
        return em.createNamedQuery("Cars.findByModel", Cars.class)
                 .setParameter("model", model)
                 .getSingleResult();
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
}
