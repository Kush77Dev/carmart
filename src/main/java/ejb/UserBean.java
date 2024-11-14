/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Appointment;
import entities.CarOrder;
import entities.Cars;
import entities.Dealer;
import entities.OrderItems;
import entities.Payment;
import entities.Review;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    public void addReview(Integer userID, Integer carID, Integer rating, String commment) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        User u = em.find(User.class, userID);
        Collection<Review> revieOfUser = u.getReviewCollection();

        Cars c = em.find(Cars.class, carID);
        Collection<Review> revieOfCar = c.getReviewCollection();

        Review r = new Review();
        r.setCarID(c);
        r.setUserID(u);
        r.setRating(rating);
        r.setComment(commment);
        r.setReviewDate(new Date());
        em.persist(r);

        revieOfUser.add(r);
        em.merge(u);

        revieOfCar.add(r);
        em.merge(c);
    }

    @Override
    public void updateReview(Integer id, Integer userID, Integer carID, Integer rating, String commment) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        User user = em.find(User.class, userID);

        Cars car = em.find(Cars.class, carID);

        Review r = em.find(Review.class, id);
        r.setCarID(car);
        r.setUserID(user);
        r.setRating(rating);
        r.setComment(commment);
        r.setReviewDate(new Date());

        if (user != null) {
            r.setUserID(user); // Set the Dealer object
        }

        if (car != null) {
            r.setCarID(car); // Set the Dealer object
        }

        em.merge(r);

    }

    @Override
    public void removeReview(Integer id, Integer userID, Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Review review = em.find(Review.class, id);

        User user = em.find(User.class, userID);
        Cars car = em.find(Cars.class, carID);

        Collection<Review> reviewofUser = user.getReviewCollection();
        Collection<Review> reviewofCars = car.getReviewCollection();

        reviewofUser.remove(review);
        reviewofCars.remove(review);

        em.merge(car);
        em.merge(user);

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

    // Users Method
    @Override
    public void addUser(String name, String email, String password, String adress, String phonenumber) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAdress(adress);
        user.setPhonenumber(phonenumber);

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
    public void removeUser(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserbyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(User.class, id);
    }

    @Override
    public User getUserbyName(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("User.findByName", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public User getUserbyEmail(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.createNamedQuery("User.findByEmail", User.class)
                .setParameter("email", email)
                .getSingleResult();
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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User u = em.find(User.class, userID);
        Collection<Appointment> appointmentOfUser = u.getAppointmentCollection();

        Dealer d = em.find(Dealer.class, dealerID);
        Collection<Appointment> appoinetmentOfDealer = d.getAppointmentCollection();

        Cars c = em.find(Cars.class, carID);
        Collection<Appointment> appoinetmentOfCar = c.getAppointmentCollection();

        Appointment a = new Appointment();
        a.setUserID(u);
        a.setDealerID(d);
        a.setCarID(c);
        a.setAppointmentDate(new Date());
        a.setStatus(status);

        em.persist(a);

        appointmentOfUser.add(a);
        em.merge(u);

        appoinetmentOfDealer.add(a);
        em.merge(d);

        appoinetmentOfCar.add(a);
        em.merge(c);

    }

    @Override
    public void updateAppointment(Integer id, Integer userID, Integer dealerID, Integer carID, String status) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User user = em.find(User.class, userID);

        Cars car = em.find(Cars.class, carID);

        Dealer dealer = em.find(Dealer.class, dealerID);

        Appointment a = em.find(Appointment.class, id);
        a.setCarID(car);
        a.setUserID(user);
        a.setDealerID(dealer);
        a.setStatus(status);
        a.setAppointmentDate(new Date());

        if (user != null) {
            a.setUserID(user); // Set the Dealer object
        }

        if (car != null) {
            a.setCarID(car); // Set the Dealer object
        }

        if (dealer != null) {
            a.setDealerID(dealer);// Set the Dealer object
        }

        em.merge(a);
    }

    @Override
    public void remmoveAppointment(Integer id, Integer userID, Integer dealerID, Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Appointment appointment = em.find(Appointment.class, id);

        User user = em.find(User.class, userID);
        Cars car = em.find(Cars.class, carID);
        Dealer dealer = em.find(Dealer.class, dealerID);

        Collection<Appointment> appointmentofUser = user.getAppointmentCollection();
        Collection<Appointment> appointmentofCars = car.getAppointmentCollection();
        Collection<Appointment> appointmentofDealer = dealer.getAppointmentCollection();

        appointmentofUser.remove(appointment);
        appointmentofDealer.remove(appointment);
        appointmentofCars.remove(appointment);

        em.merge(car);
        em.merge(user);
        em.merge(dealer);

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
        Collection<Payment> paymentsOfOrder = order.getPaymentCollection();

        Payment payment = new Payment();
        payment.setOrderID(order);
        payment.setPaymentAmount(paymentAmount);
        payment.setPaymentDate(new Date());
        payment.setPaymentMethod(paymentMethod);

        em.persist(payment);

        paymentsOfOrder.add(payment);
        em.merge(order);

    }

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
    public void addItem(Integer carId, Integer orderId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars car = em.find(Cars.class, carId);
        Collection<OrderItems> itemsInCar = car.getOrderItemsCollection();

        CarOrder order = em.find(CarOrder.class, orderId);
        Collection<OrderItems> itemsInOrder = order.getOrderItemsCollection();

        OrderItems item = new OrderItems();
        item.setCarid(car);
        item.setOrderId(order);
        em.persist(item);

        itemsInCar.add(item);
        car.setOrderItemsCollection(itemsInCar);
        em.merge(car);

        itemsInOrder.add(item);
        order.setOrderItemsCollection(itemsInOrder);
        em.merge(order);
    }

    @Override
    public void updateItem(Integer item_id, Integer carId, Integer orderId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars car = em.find(Cars.class, carId);

        CarOrder order = em.find(CarOrder.class, orderId);

        OrderItems oi = em.find(OrderItems.class, item_id);

        oi.setCarid(car);
        oi.setOrderId(order);

        if (car != null) {
            oi.setCarid(car); // Set the Dealer object
        }

        if (order != null) {
            oi.setOrderId(order); // Set the Dealer object
        }

    }

    @Override
    public void removeItem(Integer item_id, Integer orderId, Integer carId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        OrderItems orderItems = em.find(OrderItems.class, item_id);

        Cars car = em.find(Cars.class, carId);
        CarOrder order = em.find(CarOrder.class, orderId);

        Collection<OrderItems> itemsInCar = car.getOrderItemsCollection();
        Collection<OrderItems> itemsInOrder = order.getOrderItemsCollection();

        itemsInCar.remove(orderItems);
        itemsInOrder.remove(orderItems);

        em.merge(car);
        em.merge(order);

        em.remove(orderItems);

    }

    @Override
    public OrderItems getOrderItemById(Integer item_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(OrderItems.class, item_id);
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
    public void addOrder(Integer carID, Integer userID, Integer itemID, String shippmentAddress, Integer shippingPrice, Integer totalPrice, Boolean isPaid, Boolean isDelivered, String delieverdAt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carID);
        Collection<CarOrder> orderOfCar = c.getCarOrderCollection();

        User u = em.find(User.class, userID);
        Collection<CarOrder> orderOfUser = u.getCarOrderCollection();

        OrderItems oi = em.find(OrderItems.class, carID);
        Collection<CarOrder> orderOfItem = oi.getCarOrderCollection();

        CarOrder co = new CarOrder();
        co.setCarID(c);
        co.setUserID(u);
        co.setItemID(oi);
        co.setShippmentAddress(shippmentAddress);
        co.setShippingPrice(shippingPrice);
        co.setTotalPrice(totalPrice);
        co.setOrderDate(new Date());
        co.setIsPaid(isPaid);
        co.setPaidAt(new Date());
        co.setIsDelivered(isDelivered);
        co.setDeliveredAt(delieverdAt);
        em.persist(co);

        orderOfCar.add(co);
        c.setCarOrderCollection(orderOfCar);
        em.merge(c);

        orderOfUser.add(co);
        u.setCarOrderCollection(orderOfUser);
        em.merge(u);

        orderOfItem.add(co);
        oi.setCarOrderCollection(orderOfItem);
        em.merge(oi);
    }

    @Override
    public void updateOrder(Integer id, Integer carID, Integer userID, Integer itemID, String shippmentAddress, Integer shippingPrice, Integer totalPrice, Boolean isPaid, Boolean isDelivered, String delieverdAt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carID);

        User u = em.find(User.class, userID);

        OrderItems oi = em.find(OrderItems.class, carID);

        CarOrder co = em.find(CarOrder.class, id);

        co.setCarID(c);
        co.setUserID(u);
        co.setItemID(oi);
        co.setShippmentAddress(shippmentAddress);
        co.setShippingPrice(shippingPrice);
        co.setTotalPrice(totalPrice);
        co.setOrderDate(new Date());
        co.setIsPaid(isPaid);
        co.setPaidAt(new Date());
        co.setIsDelivered(isDelivered);
        co.setDeliveredAt(delieverdAt);

        if (c != null) {
            co.setCarID(c); // Set the Dealer object
        }

        if (u != null) {
            co.setUserID(u); // Set the Dealer object
        }

        if (oi != null) {
            co.setItemID(oi); // Set the Dealer object
        }

        em.merge(co);

    }

    @Override
    public void removeOrder(Integer id, Integer carID, Integer userID, Integer itemID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        CarOrder carOrder = em.find(CarOrder.class, id);

        Cars c = em.find(Cars.class, carID);
        User u = em.find(User.class, userID);
        OrderItems oi = em.find(OrderItems.class, carID);

        Collection<CarOrder> orderOfCar = c.getCarOrderCollection();
        Collection<CarOrder> orderOfUser = u.getCarOrderCollection();
        Collection<CarOrder> orderOfItems = oi.getCarOrderCollection();

        orderOfCar.remove(carOrder);
        orderOfUser.remove(carOrder);
        orderOfItems.remove(carOrder);

        em.merge(c);
        em.merge(u);
        em.merge(oi);

        em.remove(carOrder);

    }

    @Override
    public CarOrder getCarOrderById(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        return em.find(CarOrder.class, id);
    }

    @Override
    public Collection<CarOrder> getCarOrderByCarId(Integer carID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Cars c = em.find(Cars.class, carID);
        return c.getCarOrderCollection();
    }

    @Override
    public Collection<CarOrder> getCarOrderByUserId(Integer userID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        User u = em.find(User.class, userID);
        return u.getCarOrderCollection();

    }

    @Override
    public Collection<CarOrder> getCarOrderByItemId(Integer itemID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        OrderItems oi = em.find(OrderItems.class, itemID);
        return oi.getCarOrderCollection();
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

}
