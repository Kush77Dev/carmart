/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Appointment;
import entities.CarOrder;
import entities.OrderItems;
import entities.Payment;
import entities.Review;
import entities.User;
import jakarta.ejb.Local;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Kush Khakhiwala
 */
@Local
public interface UserBeanLocal {

    //Review
    void addReview(Integer userID, Integer carID, Integer rating, String commment);

    void updateReview(Integer id, Integer userID, Integer carID, Integer rating, String commment);

    void removeReview(Integer id, Integer userID, Integer carID);

    Review getReviewbyId(Integer id);

    Collection<Review> getReviewbyUserId(Integer userId);

    Collection<Review> getReviewbyCarId(Integer carId);

    //User
    void addUser(String name, String email, String password, String adress, String phonenumber);

    void updateUser(Integer id, String name, String email, String password, String adress, String phonenumber);

    void removeUser(Integer id);

    User getUserbyId(Integer id);

    User getUserbyName(String name);

    User getUserbyEmail(String email);

    Collection<User> getAllUsers();

    // Appointment
    void addAppointment(Integer userID, Integer dealerID, Integer carID, String status);

    void updateAppointment(Integer id, Integer userID, Integer dealerID, Integer carID, String status);

    void remmoveAppointment(Integer id, Integer userID, Integer dealerID, Integer carID);

    Appointment getAppointmentbyId(Integer id);

    Collection<Appointment> getAppoinetmentbyStatus(String status);

    Collection<Appointment> getAppoinetmentbyUserId(Integer userID);

    Collection<Appointment> getAppoinetmentbyDealerId(Integer dealerID);

    Collection<Appointment> getAppoinetmentbyCarId(Integer carID);

    // Payment
    
    void addPayment(Integer orderID, Integer paymentAmount, String paymentMethod);

    void updatePayment(Integer id,Integer orderID, Integer paymentAmount, String paymentMethod);

    void removePayment(Integer id,Integer orderID);
    
    Payment getPaymentById(Integer id);
    
    Collection<Payment> getPaymentByMethod(String paymentMethod);
    
    Collection<Payment> getAllPayments();

    
    // Order Item
    
     void addItem(Integer carId, Integer orderId);
     
     void updateItem(Integer item_id,Integer carId, Integer orderId);
     
     void removeItem(Integer item_id,Integer carId, Integer orderId);
     
     OrderItems getOrderItemById(Integer item_id);
     
     Collection<OrderItems> getItemByCarId(Integer carID);
     
     Collection<OrderItems> getItemByOrderId(Integer orderID);

     
     // Car Order Methods
     
     void addOrder(Integer carID,Integer userID,Integer itemID,String shippmentAddress,Integer shippingPrice,Integer totalPrice,Boolean isPaid,Boolean isDelivered,String delieverdAt);
     
     void updateOrder(Integer id,Integer carID,Integer userID,Integer itemID,String shippmentAddress,Integer shippingPrice,Integer totalPrice,Boolean isPaid,Boolean isDelivered,String delieverdAt);
     
     void removeOrder(Integer id,Integer carID,Integer userID,Integer itemID);
     
     CarOrder getCarOrderById(Integer id);
     
     Collection<CarOrder> getCarOrderByCarId(Integer carID);
     
     Collection<CarOrder> getCarOrderByUserId(Integer userID);
     
     Collection<CarOrder> getCarOrderByItemId(Integer itemID);
     
     Collection<CarOrder> getCarOrderByDate(Date orderDate);
     
     Collection<CarOrder> getAllCarorder();


}
