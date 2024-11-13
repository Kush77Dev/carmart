/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Review;
import entities.User;
import jakarta.ejb.Local;
import java.util.Collection;

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

}
