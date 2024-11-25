/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author maharaja
 */
@Entity
@Table(name = "dealer")
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d"),
    @NamedQuery(name = "Dealer.findById", query = "SELECT d FROM Dealer d WHERE d.id = :id"),
    @NamedQuery(name = "Dealer.findByName", query = "SELECT d FROM Dealer d WHERE d.name = :name"),
    @NamedQuery(name = "Dealer.findByAdress", query = "SELECT d FROM Dealer d WHERE d.adress = :adress"),
    @NamedQuery(name = "Dealer.findByPhonenumber", query = "SELECT d FROM Dealer d WHERE d.phonenumber = :phonenumber"),
    @NamedQuery(name = "Dealer.findByEmail", query = "SELECT d FROM Dealer d WHERE d.email = :email")})
public class Dealer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "phonenumber")
    private String phonenumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealerID")
    private Collection<Cars> carsCollection;
    @JoinColumn(name = "groupMaster_id", referencedColumnName = "groupMasterID")
    @ManyToOne(optional = false)
    private Groupmaster groupMasterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealerID")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealerID")
    private Collection<Inventory> inventoryCollection;

    public Dealer() {
    }

    public Dealer(Integer id) {
        this.id = id;
    }

    public Dealer(Integer id, String name, String adress, String phonenumber, String email) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phonenumber = phonenumber;
        this.email = email;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Cars> getCarsCollection() {
        return carsCollection;
    }

    public void setCarsCollection(Collection<Cars> carsCollection) {
        this.carsCollection = carsCollection;
    }

    public Groupmaster getGroupMasterid() {
        return groupMasterid;
    }

    public void setGroupMasterid(Groupmaster groupMasterid) {
        this.groupMasterid = groupMasterid;
    }

    @JsonbTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
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
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dealer[ id=" + id + " ]";
    }
    
}
