/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Cars;
import entities.Review;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        Collection<Review> revieOfUser=u.getReviewCollection();
        
        Cars c=em.find(Cars.class, carID);
        Collection<Review> revieOfCar=c.getReviewCollection();
        
        Review r=new Review();
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
        
        Cars car=em.find(Cars.class, carID);
        
        Review r=em.find(Review.class, id);
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

   

}
