/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "appointment")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id"),
    @NamedQuery(name = "Appointment.findByAppointmentDate", query = "SELECT a FROM Appointment a WHERE a.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "Appointment.findByStatus", query = "SELECT a FROM Appointment a WHERE a.status = :status")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appointmentDate")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "carID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cars carID;
    @JoinColumn(name = "dealerID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dealer dealerID;
    @JoinColumn(name = "userID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userID;

    public Appointment() {
    }

    public Appointment(Integer id) {
        this.id = id;
    }

    public Appointment(Integer id, Date appointmentDate, String status) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cars getCarID() {
        return carID;
    }

    public void setCarID(Cars carID) {
        this.carID = carID;
    }

    public Dealer getDealerID() {
        return dealerID;
    }

    public void setDealerID(Dealer dealerID) {
        this.dealerID = dealerID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Appointment[ id=" + id + " ]";
    }
    
}
