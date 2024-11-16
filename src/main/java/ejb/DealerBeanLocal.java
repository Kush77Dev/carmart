/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Cars;
import entities.Dealer;
import entities.Inventory;
import entities.Review;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@Local
public interface DealerBeanLocal {

    void addCar(String name, String image, String brand, String category, String description, int price, String model, int mileage, String color, int vin, Integer dealerID, boolean inStock);

    void updateCar(Integer id, String name, String image, String brand, String category, String description, int price, String model, int mileage, String color, int vin, int dealerID, boolean inStock);

    void removeCar(Integer id, Integer dealerId);

    Cars getCarById(Integer id);

    Collection<Cars> getCarByName(String name);

    Collection<Cars> getCarByBrand(String brand);

    Collection<Cars> getCarByCategory(String category);

    Collection<Cars> getCarByColor(String color);

    Collection<Cars> getCarByModel(String model);

    Cars getCarByPrice(int price);

    Cars getCarByMileage(int mileage);

    Collection<Dealer> getDealersofCars(int dealerID);

    Collection<Cars> getAllCars();

    Cars getCarByInStock(boolean inStock);

    Collection<Cars> getCarsByDealerId(Integer dealerId);
    
    Collection<Cars> searchCarByName(String name);
    
    
    // Inventory Methods
    
    void addInventory(Integer carID,Integer dealerID,Integer quantity);
    
    void updateInventory(Integer id,Integer carID,Integer dealerID,Integer quantity);
    
    void removeInventory(Integer id,Integer carID,Integer dealerID);
    
    Inventory inventorybyId(Integer id);
    
    Collection<Inventory> getAllInventory();
    
    
    

}
