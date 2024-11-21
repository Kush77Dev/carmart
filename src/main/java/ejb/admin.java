/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.Dealer;
import entities.Groupmaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void addDealer(String name, String adress, String phonenumber, String email, Integer groupMaster_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
        Collection<Dealer> groupByDealer=gid.getDealerCollection();
        
        Dealer d = new Dealer();
        d.setName(name);
        d.setAdress(adress);
        d.setPhonenumber(phonenumber);
        d.setEmail(email);
        d.setGroupMasterid(gid);
        
        groupByDealer.add(d);
        
        em.merge(gid);

        em.persist(d);

    }

    @Override
    public void updateDealer(Integer id, String name, String adress, String phonenumber, String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer d = (Dealer) em.find(Dealer.class, id);
        d.setName(name);
        d.setAdress(adress);
        d.setPhonenumber(phonenumber);
        d.setEmail(email);

        em.merge(d);

    }

    @Override
    public void removeDealer(Integer id, Integer groupMaster_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer d = (Dealer) em.find(Dealer.class, id);
        Groupmaster gid = em.find(Groupmaster.class, groupMaster_id);
        Collection<Dealer> deal=gid.getDealerCollection();
        
        deal.remove(d);
        em.merge(d);

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
    public Dealer getallDealersbyId(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer deal = (Dealer) em.createNamedQuery("Dealer.findById")
                .setParameter("id", id)
                .getSingleResult();
        return deal;
    }

    @Override
    public Collection<Dealer> getallDealersbyName(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        return em.createNamedQuery("User.findByName", User.class)
//                .setParameter("name", name)
//                .getResultList();
        return em.createNamedQuery("Dealer.findByName", Dealer.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public Dealer getallDealersbyaddress(String adress) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer deal = (Dealer) em.createNamedQuery("Dealer.findByAdress")
                .setParameter("adress", adress)
                .getSingleResult();
        return deal;
    }

    @Override
    public Dealer getallDealersbyPhoneNumber(String phonenumber) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer deal = (Dealer) em.createNamedQuery("Dealer.findByPhonenumber")
                .setParameter("phonenumber", phonenumber)
                .getSingleResult();
        return deal;
    }

    @Override
    public Dealer getallDealersbyEmail(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Dealer deal = (Dealer) em.createNamedQuery("Dealer.findByEmail")
                .setParameter("email", email)
                .getSingleResult();
        return deal;
    }

}
