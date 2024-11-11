/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Dealer;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@Local
public interface adminLocal {

    void addDealer(String name, String adress, String phonenumber, String email);

    void updateDealer(Integer id, String name, String adress, String phonenumber, String email);

    void removeDealer(Integer id);

    Collection<Dealer> getallDealers();

    Collection<Dealer> getallDealersbyId(Integer id);

    Collection<Dealer> getallDealersbyName(String name);

    Collection<Dealer> getallDealersbyaddress(String adress);

    Collection<Dealer> getallDealersbyPhoneNumber(String phonenumber);

    Collection<Dealer> getallDealersbyEmail(String email);

}
