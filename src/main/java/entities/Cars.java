/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

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
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@Entity
@Table(name = "cars")
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id"),
    @NamedQuery(name = "Cars.findByName", query = "SELECT c FROM Cars c WHERE c.name = :name"),
    @NamedQuery(name = "Cars.findByImage", query = "SELECT c FROM Cars c WHERE c.image = :image"),
    @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand"),
    @NamedQuery(name = "Cars.findByCategory", query = "SELECT c FROM Cars c WHERE c.category = :category"),
    @NamedQuery(name = "Cars.findByDescription", query = "SELECT c FROM Cars c WHERE c.description = :description"),
    @NamedQuery(name = "Cars.findByPrice", query = "SELECT c FROM Cars c WHERE c.price = :price"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByMilage", query = "SELECT c FROM Cars c WHERE c.milage = :milage"),
    @NamedQuery(name = "Cars.findByColor", query = "SELECT c FROM Cars c WHERE c.color = :color"),
    @NamedQuery(name = "Cars.findByVin", query = "SELECT c FROM Cars c WHERE c.vin = :vin"),
    @NamedQuery(name = "Cars.findByInStock", query = "SELECT c FROM Cars c WHERE c.inStock = :inStock")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @Column(name = "milage")
    private int milage;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "vin")
    private int vin;
    @Basic(optional = false)
    @Column(name = "inStock")
    private boolean inStock;
    @JoinColumn(name = "dealerID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dealer dealerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<Review> reviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<Inventory> inventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carID")
    private Collection<CarOrder> carOrderCollection;
    @OneToMany(mappedBy = "carid")
    private Collection<OrderItems> orderItemsCollection;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Cars(Integer id, String name, String image, String brand, String category, String description, int price, String model, int milage, String color, int vin, boolean inStock) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.price = price;
        this.model = model;
        this.milage = milage;
        this.color = color;
        this.vin = vin;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public boolean getInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Dealer getDealerID() {
        return dealerID;
    }

    public void setDealerID(Dealer dealerID) {
        this.dealerID = dealerID;
    }

    @JsonbTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @JsonbTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @JsonbTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @JsonbTransient
    public Collection<CarOrder> getCarOrderCollection() {
        return carOrderCollection;
    }

    public void setCarOrderCollection(Collection<CarOrder> carOrderCollection) {
        this.carOrderCollection = carOrderCollection;
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
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cars[ id=" + id + " ]";
    }
    
}
