/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Dealer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@Stateless
public class admin implements adminLocal {

    @PersistenceContext(unitName = "carmart_unit")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addDealer(String name, String adress, String phonenumber, String email) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Dealer d=new Dealer();
        d.setName(name);
        d.setAdress(adress);
        d.setPhonenumber(phonenumber);
        d.setEmail(email);
        
        em.persist(d);
    
    
    }

    @Override
    public void updateDealer(Integer id, String name, String adress, String phonenumber, String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer d=(Dealer) em.find(Dealer.class, id);
        d.setName(name);
        d.setAdress(adress);
        d.setPhonenumber(phonenumber);
        d.setEmail(email);
        
        em.persist(d);
        
    }

    @Override
    public void removeDealer(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer d=(Dealer) em.find(Dealer.class, id);
        em.remove(d);
    }

    @Override
    public Collection<Dealer> getallDealers() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  
//        return em.createNamedQuery("Dealer.findAll").getResultList();
    Collection<Dealer> deal = em.createNamedQuery("Dealer.findAll").getResultList();
    return deal;
    }

    @Override
    public Collection<Dealer> getallDealersbyId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Dealer> getallDealersbyName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Dealer> getallDealersbyaddress(String adress) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Dealer> getallDealersbyPhoneNumber(String phonenumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Dealer> getallDealersbyEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
  

   

}
