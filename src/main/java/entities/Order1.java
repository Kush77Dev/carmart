/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Kush Khakhiwala
 */
@Entity
@Table(name = "order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByShippmentAddress", query = "SELECT o FROM Order1 o WHERE o.shippmentAddress = :shippmentAddress"),
    @NamedQuery(name = "Order1.findByShippingPrice", query = "SELECT o FROM Order1 o WHERE o.shippingPrice = :shippingPrice"),
    @NamedQuery(name = "Order1.findByTotalPrice", query = "SELECT o FROM Order1 o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "Order1.findByOrderDate", query = "SELECT o FROM Order1 o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Order1.findByIsPaid", query = "SELECT o FROM Order1 o WHERE o.isPaid = :isPaid"),
    @NamedQuery(name = "Order1.findByPaidAt", query = "SELECT o FROM Order1 o WHERE o.paidAt = :paidAt"),
    @NamedQuery(name = "Order1.findByIsDelivered", query = "SELECT o FROM Order1 o WHERE o.isDelivered = :isDelivered"),
    @NamedQuery(name = "Order1.findByDeliveredAt", query = "SELECT o FROM Order1 o WHERE o.deliveredAt = :deliveredAt")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "shippmentAddress")
    private String shippmentAddress;
    @Basic(optional = false)
    @Column(name = "shippingPrice")
    private int shippingPrice;
    @Basic(optional = false)
    @Column(name = "totalPrice")
    private int totalPrice;
    @Basic(optional = false)
    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "isPaid")
    private boolean isPaid;
    @Basic(optional = false)
    @Column(name = "paidAt")
    @Temporal(TemporalType.DATE)
    private Date paidAt;
    @Basic(optional = false)
    @Column(name = "isDelivered")
    private boolean isDelivered;
    @Basic(optional = false)
    @Column(name = "deliveredAt")
    private String deliveredAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "carID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cars carID;
    @JoinColumn(name = "itemID", referencedColumnName = "item_id")
    @ManyToOne(optional = false)
    private OrderItems itemID;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userID;
    @OneToMany(mappedBy = "orderId")
    private Collection<OrderItems> orderItemsCollection;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, String shippmentAddress, int shippingPrice, int totalPrice, Date orderDate, boolean isPaid, Date paidAt, boolean isDelivered, String deliveredAt) {
        this.id = id;
        this.shippmentAddress = shippmentAddress;
        this.shippingPrice = shippingPrice;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
        this.paidAt = paidAt;
        this.isDelivered = isDelivered;
        this.deliveredAt = deliveredAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippmentAddress() {
        return shippmentAddress;
    }

    public void setShippmentAddress(String shippmentAddress) {
        this.shippmentAddress = shippmentAddress;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(String deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Cars getCarID() {
        return carID;
    }

    public void setCarID(Cars carID) {
        this.carID = carID;
    }

    public OrderItems getItemID() {
        return itemID;
    }

    public void setItemID(OrderItems itemID) {
        this.itemID = itemID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Order1[ id=" + id + " ]";
    }
    
}
