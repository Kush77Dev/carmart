/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entities.Dealer;
import javax.ejb.Local;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@Local
public interface adminLocal {

    void addDealer(String name, String adress, String phonenumber, String email, Integer groupMaster_id);

    void updateDealer(Integer id, String name, String adress, String phonenumber, String email);

    void removeDealer(Integer id,Integer groupMaster_id);

    Collection<Dealer> getallDealers();

    Dealer getallDealersbyId(Integer id);

    Collection<Dealer> getallDealersbyName(String name);

    Dealer getallDealersbyaddress(String adress);

    Dealer getallDealersbyPhoneNumber(String phonenumber);

    Dealer getallDealersbyEmail(String email);

}
