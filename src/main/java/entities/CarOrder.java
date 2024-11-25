/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.json.bind.annotation.JsonbTransient;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author maharaja
 */
@Entity
@Table(name = "car_order")
@NamedQueries({
    @NamedQuery(name = "CarOrder.findAll", query = "SELECT c FROM CarOrder c"),
    @NamedQuery(name = "CarOrder.findById", query = "SELECT c FROM CarOrder c WHERE c.id = :id"),
    @NamedQuery(name = "CarOrder.findByShippmentAddress", query = "SELECT c FROM CarOrder c WHERE c.shippmentAddress = :shippmentAddress"),
    @NamedQuery(name = "CarOrder.findByShippingPrice", query = "SELECT c FROM CarOrder c WHERE c.shippingPrice = :shippingPrice"),
    @NamedQuery(name = "CarOrder.findByTotalPrice", query = "SELECT c FROM CarOrder c WHERE c.totalPrice = :totalPrice"),
    @NamedQuery(name = "CarOrder.findByOrderDate", query = "SELECT c FROM CarOrder c WHERE c.orderDate = :orderDate"),
    @NamedQuery(name = "CarOrder.findByIsPaid", query = "SELECT c FROM CarOrder c WHERE c.isPaid = :isPaid"),
    @NamedQuery(name = "CarOrder.findByPaidAt", query = "SELECT c FROM CarOrder c WHERE c.paidAt = :paidAt"),
    @NamedQuery(name = "CarOrder.findByIsDelivered", query = "SELECT c FROM CarOrder c WHERE c.isDelivered = :isDelivered"),
    @NamedQuery(name = "CarOrder.findByDeliveredAt", query = "SELECT c FROM CarOrder c WHERE c.deliveredAt = :deliveredAt")})
public class CarOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "shippmentAddress")
    private String shippmentAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shippingPrice")
    private int shippingPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalPrice")
    private int totalPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isPaid")
    private boolean isPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paidAt")
    @Temporal(TemporalType.DATE)
    private Date paidAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isDelivered")
    private boolean isDelivered;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "deliveredAt")
    private String deliveredAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userID;
    @OneToMany(mappedBy = "orderId")
    private Collection<OrderItems> orderItemsCollection;

    public CarOrder() {
    }

    public CarOrder(Integer id) {
        this.id = id;
    }

    public CarOrder(Integer id, String shippmentAddress, int shippingPrice, int totalPrice, Date orderDate, boolean isPaid, Date paidAt, boolean isDelivered, String deliveredAt) {
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

    @JsonbTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @JsonbTransient
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
        if (!(object instanceof CarOrder)) {
            return false;
        }
        CarOrder other = (CarOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CarOrder[ id=" + id + " ]";
    }
    
}
