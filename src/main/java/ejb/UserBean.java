/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Appointment;
import entities.CarOrder;
import entities.Cars;
import entities.Dealer;
import entities.Groupmaster;
import entities.OrderItems;
import entities.Payment;
import entities.Review;
import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Kush Khakhiwala
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "carmart_unit")
    private EntityManager em;

    // Review Methods
    @Override
    public void addReview(Integer userID, Integer carID, Integer rating, String comment) {
        // Find user and car by their IDs
        User u = em.find(User.class, userID);
        Cars c = em.find(Cars.class, carID);

        // Create a new review
        Review r = new Review();
        r.setCarID(c); // Set car for the review
        r.setUserID(u); // Set user for the review
        r.setRating(rating);
        r.setComment(comment);
        r.setReviewDate(new Date());

        // Persist the review entity
        em.persist(r);

        // Update collections for user and car (optional if you want to maintain the collections manually)
        u.getReviewCollection().add(r);
        c.getReviewCollection().add(r);

        // Merge the updated user and car collections (if manually managing them)
        em.merge(u);
        em.merge(c);
    }

    @Override
    public void updateReview(Integer id, Integer userID, Integer carID, Integer rating, String comment) {
        // Find the user and car by their IDs
        User user = em.find(User.class, userID);
        Cars car = em.find(Cars.class, carID);

        // Find the review to update
        Review r = em.find(Review.class, id);
        r.setCarID(car);
        r.setUserID(user);
        r.setRating(rating);
        r.setComment(comment);
        r.setReviewDate(new Date());

        // Merge the review entity to update it
        em.merge(r);
    }

    @Override
    public void removeReview(Integer id, Integer userID, Integer carID) {
        // Find the review to remove
        Review review = em.find(Review.class, id);

        // Find the user and car associated with the review
        User user = em.find(User.class, userID);
        Cars car = em.find(Cars.class, carID);

        // Remove the review from user and car collections
        user.getReviewCollection().remove(review);
        car.getReviewCollection().remove(review);

        // Merge the updated user and car collections
        em.merge(user);
        em.merge(car);

        // Finally, remove the review
        em.remove(review);
    }

    @Override
    public Review getReviewbyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(Review.class, id);
    }

    @Override
    public Collection<Review> getReviewbyUserId(Integer userId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User u = em.find(User.class, userId);
        return u.getReviewCollection();
    }

    @Override
    public Collection<Review> getReviewbyCarId(Integer carId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carId);
        return c.getReviewCollection();
    }

    @Override
    public Collection<Review> getReviewByDate(Date reviewDate) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        TypedQuery<Review> query = em.createNamedQuery("Review.findByReviewDate", Review.class);
        query.setParameter("reviewDate", reviewDate);

        return query.getResultList();
    }

    // Users Method
    @Override
    public void addUser(String name, String email, String password, String adress, String phonenumber, Integer groupMaster_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
        Collection<User> groupByUser = gid.getUserCollection();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdress(adress);
        user.setPhonenumber(phonenumber);
        user.setGroupMasterid(gid);

        groupByUser.add(user);
        em.merge(gid);

        em.persist(user);
    }

    @Override
    public void updateUser(Integer id, String name, String email, String password, String adress, String phonenumber) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User user = em.find(User.class, id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdress(adress);
        user.setPhonenumber(phonenumber);

        em.merge(user);

    }

    @Override
    public void removeUser(Integer id, Integer groupMaster_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User user = em.find(User.class, id);

        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
        Collection<User> groupByUser = gid.getUserCollection();

        groupByUser.remove(user);
        em.merge(user);
        em.remove(user);

//                Dealer d = (Dealer) em.find(Dealer.class, id);
//        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
//        Collection<Dealer> deal=gid.getDealerCollection();
//        
//        deal.remove(d);
//        em.merge(d);
//
//        em.remove(d);
    }

    @Override
    public User getUserbyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(User.class, id);
    }

    @Override
    public Collection<User> getUserbyName(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("User.findByName", User.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Collection<User> getUserbyEmail(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public Collection<User> getAllUsers() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Collection<User> user = em.createNamedQuery("User.findAll").getResultList();
        return user;
    }

    // Appinetment Methods
    @Override
    public void addAppointment(Integer userID, Integer dealerID, Integer carID, String status) {
        // Find the associated entities
        User user = em.find(User.class, userID);
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Create a new Appointment entity
        Appointment appointment = new Appointment();
        appointment.setUserID(user);
        appointment.setDealerID(dealer);
        appointment.setCarID(car);
        appointment.setAppointmentDate(new Date());
        appointment.setStatus(status);

        // Persist the new appointment
        em.persist(appointment);

        // Update the collections for user, dealer, and car
        user.getAppointmentCollection().add(appointment);
        dealer.getAppointmentCollection().add(appointment);
        car.getAppointmentCollection().add(appointment);

        // Merge the updated entities
        em.merge(user);
        em.merge(dealer);
        em.merge(car);
    }

    @Override
    public void updateAppointment(Integer id, Integer userID, Integer dealerID, Integer carID, String status) {
        // Find the existing appointment
        Appointment appointment = em.find(Appointment.class, id);

        // Find the associated entities
        User user = em.find(User.class, userID);
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Update the associations and attributes
        if (user != null) {
            appointment.setUserID(user);
        }
        if (dealer != null) {
            appointment.setDealerID(dealer);
        }
        if (car != null) {
            appointment.setCarID(car);
        }

        appointment.setStatus(status);
        appointment.setAppointmentDate(new Date());

        // Merge the updated appointment
        em.merge(appointment);
    }

    @Override
    public void remmoveAppointment(Integer id, Integer userID, Integer dealerID, Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Appointment appointment = em.find(Appointment.class, id);

        // Find the associated entities
        User user = em.find(User.class, userID);
        Dealer dealer = em.find(Dealer.class, dealerID);
        Cars car = em.find(Cars.class, carID);

        // Remove the appointment from the collections
        if (user != null) {
            user.getAppointmentCollection().remove(appointment);
            em.merge(user);
        }
        if (dealer != null) {
            dealer.getAppointmentCollection().remove(appointment);
            em.merge(dealer);
        }
        if (car != null) {
            car.getAppointmentCollection().remove(appointment);
            em.merge(car);
        }

        // Finally, remove the appointment entity
        em.remove(appointment);
    }

    @Override
    public Appointment getAppointmentbyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(Appointment.class, id);
    }

    @Override
    public Collection<Appointment> getAppoinetmentbyStatus(String status) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("Appointment.findByStatus", Appointment.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public Collection<Appointment> getAppoinetmentbyUserId(Integer userID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User u = em.find(User.class, userID);
        return u.getAppointmentCollection();
    }

    @Override
    public Collection<Appointment> getAppoinetmentbyDealerId(Integer dealerID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer d = em.find(Dealer.class, dealerID);
        return d.getAppointmentCollection();
    }

    @Override
    public Collection<Appointment> getAppoinetmentbyCarId(Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carID);
        return c.getAppointmentCollection();
    }

    @Override
    public void addPayment(Integer orderID, Integer paymentAmount, String paymentMethod) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        CarOrder order = em.find(CarOrder.class, orderID);
//        Collection<Payment> paymentsOfOrder = order.getPaymentCollection();

        Payment payment = new Payment();
        payment.setOrderID(order);
        payment.setPaymentAmount(paymentAmount);
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod(paymentMethod);

        em.persist(payment);

        order.getPaymentCollection().add(payment);

//        paymentsOfOrder.add(payment);
        em.merge(order);

    }

//    public void addReview(Integer userID, Integer carID, Integer rating, String comment) {
//        // Find user and car by their IDs
//        User u = em.find(User.class, userID);
//        Cars c = em.find(Cars.class, carID);
//
//        // Create a new review
//        Review r = new Review();
//        r.setCarID(c); // Set car for the review
//        r.setUserID(u); // Set user for the review
//        r.setRating(rating);
//        r.setComment(comment);
//        r.setReviewDate(new Date());
//
//        // Persist the review entity
//        em.persist(r);
//
//        // Update collections for user and car (optional if you want to maintain the collections manually)
//        u.getReviewCollection().add(r);
//        c.getReviewCollection().add(r);
//
//        // Merge the updated user and car collections (if manually managing them)
//        em.merge(u);
//        em.merge(c);
//    }
    @Override
    public void updatePayment(Integer id, Integer orderID, Integer paymentAmount, String paymentMethod) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        CarOrder order = em.find(CarOrder.class, orderID);
        Payment payment = em.find(Payment.class, id);

        payment.setOrderID(order);
        payment.setPaymentAmount(paymentAmount);
        payment.setPaymentMethod(paymentMethod);
        payment.setPaymentDate(new Date());

        if (order != null) {
            payment.setOrderID(order); // Set the Dealer object
        }

        em.merge(payment);
    }

    @Override
    public void removePayment(Integer id, Integer orderID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Payment payment = em.find(Payment.class, id);
        CarOrder order = em.find(CarOrder.class, orderID);

        Collection<Payment> paymentsOfOrder = order.getPaymentCollection();
        paymentsOfOrder.remove(payment);

        em.merge(order);
        em.remove(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(Payment.class, id);
    }

    @Override
    public Collection<Payment> getPaymentByOrderId(Integer orderID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        CarOrder co = em.find(CarOrder.class, orderID);
        return co.getPaymentCollection();
    }

    @Override
    public Collection<Payment> getPaymentByMethod(String paymentMethod) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("Payment.findByPaymentMethod", Payment.class)
                .setParameter("paymentMethod", paymentMethod)
                .getResultList();

    }

    @Override
    public Collection<Payment> getAllPayments() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("Payment.findAll", Payment.class).getResultList();
    }

    @Override
    public Collection<Payment> getPaymentByDate(Date paymentDate) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//     TypedQuery<CarOrder> query = em.createNamedQuery("CarOrder.findByOrderDate", CarOrder.class);
//        query.setParameter("orderDate", orderDate);
//
//        // Execute the query and return the list of matching CarOrders
//        return query.getResultList();

        TypedQuery<Payment> query = em.createNamedQuery("Payment.findByPaymentDate", Payment.class);
        query.setParameter("paymentDate", paymentDate);

        return query.getResultList();

    }

    @Override
    public void addItem(Integer carId, Integer orderId) {
        // Find the car and order entities
        Cars car = em.find(Cars.class, carId);
        CarOrder order = em.find(CarOrder.class, orderId);

        // Create a new OrderItems entity
        OrderItems item = new OrderItems();
        item.setCarid(car); // Associate with car
        item.setOrderId(order); // Associate with order

        // Persist the new item
        em.persist(item);

        // Update the collections for car and order
        car.getOrderItemsCollection().add(item);
        order.getOrderItemsCollection().add(item);

        // Merge updated car and order entities
        em.merge(car);
        em.merge(order);
    }

    @Override
    public void updateItem(Integer item_Id, Integer carId, Integer orderId) {
        // Find the OrderItems entity to update
        OrderItems item = em.find(OrderItems.class, item_Id);

        // Find the associated car and order
        Cars car = em.find(Cars.class, carId);
        CarOrder order = em.find(CarOrder.class, orderId);

        // Update the associations
        if (car != null) {
            item.setCarid(car);
        }
        if (order != null) {
            item.setOrderId(order);
        }

        // Merge the updated item
        em.merge(item);
    }

    @Override
    public void removeItem(Integer item_Id, Integer orderId, Integer carId) {
        // Find the OrderItems entity to remove
        OrderItems item = em.find(OrderItems.class, item_Id);

        // Find the associated car and order
        Cars car = em.find(Cars.class, carId);
        CarOrder order = em.find(CarOrder.class, orderId);

        // Remove the item from the collections
        car.getOrderItemsCollection().remove(item);
        order.getOrderItemsCollection().remove(item);

        // Merge the updated car and order entities
        em.merge(car);
        em.merge(order);

        // Remove the item
        em.remove(item);
    }

    @Override
    public OrderItems getOrderItemById(Integer item_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(OrderItems.class, item_id);

//           OrderItems items = (OrderItems) em.createNamedQuery("OrderItems.findByItemId")
//                   .setParameter("itemId", item_id)
//                   .getSingleResult();
//           
//           return items;    
//        Dealer deal = (Dealer) em.createNamedQuery("Dealer.findById")
//                .setParameter("id", id)
//                .getSingleResult();
//        return deal;
    }

    @Override
    public Collection<OrderItems> getItemByCarId(Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carID);
        return c.getOrderItemsCollection();

    }

    @Override
    public Collection<OrderItems> getItemByOrderId(Integer orderID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        CarOrder o = em.find(CarOrder.class, orderID);
        return o.getOrderItemsCollection();

    }

    @Override
    public void addOrder(Integer userID, String shippmentAddress, Integer shippingPrice, Integer totalPrice, Boolean isPaid, Boolean isDelivered, String deliveredAt) {
        // Find the associated user entity
        User user = em.find(User.class, userID);

        // Create a new CarOrder entity
        CarOrder order = new CarOrder();
        order.setUserID(user);
        order.setShippmentAddress(shippmentAddress);
        order.setShippingPrice(shippingPrice);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(new Date());
        order.setIsPaid(isPaid);
        order.setIsDelivered(isDelivered);
        order.setDeliveredAt(deliveredAt);

        // Persist the new order
        em.persist(order);

        // Update the user's order collection
        if (user != null) {
            user.getCarOrderCollection().add(order);
            em.merge(user);
        }
    }

    @Override
    public void updateOrder(Integer id, Integer userID, String shippmentAddress, Integer shippingPrice, Integer totalPrice, Boolean isPaid, Boolean isDelivered, String deliveredAt) {
        // Find the existing CarOrder entity
        CarOrder order = em.find(CarOrder.class, id);

        // Find the associated user entity
        User user = em.find(User.class, userID);

        // Update the order attributes
        if (user != null) {
            order.setUserID(user);
        }
        order.setShippmentAddress(shippmentAddress);
        order.setShippingPrice(shippingPrice);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(new Date());
        order.setIsPaid(isPaid);
        order.setIsDelivered(isDelivered);
        order.setDeliveredAt(deliveredAt);

        // Merge the updated order
        em.merge(order);
    }

    @Override
    public void removeOrder(Integer id, Integer userID) {
        // Find the existing CarOrder entity
        CarOrder order = em.find(CarOrder.class, id);

        // Find the associated user entity
        User user = em.find(User.class, userID);

        // Remove the order from the user's collection
        if (user != null && order != null) {
            user.getCarOrderCollection().remove(order);
            em.merge(user);
        }

        // Finally, remove the order entity
        if (order != null) {
            em.remove(order);
        }
    }

    @Override
    public CarOrder getCarOrderById(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(CarOrder.class, id);
    }

    @Override
    public Collection<CarOrder> getCarOrderByUserId(Integer userID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User u = em.find(User.class, userID);
        return u.getCarOrderCollection();

    }

    @Override
    public Collection<CarOrder> getCarOrderByDate(Date orderDate) {
        // Define the query to find CarOrder entities by a specific order date
        TypedQuery<CarOrder> query = em.createNamedQuery("CarOrder.findByOrderDate", CarOrder.class);
        query.setParameter("orderDate", orderDate);

        // Execute the query and return the list of matching CarOrders
        return query.getResultList();
    }

    @Override
    public Collection<CarOrder> getAllCarorder() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Collection<CarOrder> carOrders = em.createNamedQuery("CarOrder.findAll").getResultList();
        return carOrders;
    }

    @Override
    public Collection<User> getUserByGroup(Integer groupMaster_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
        return gid.getUserCollection();

    }

}
