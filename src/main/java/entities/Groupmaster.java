/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author maharaja
 */
@Entity
@Table(name = "groupmaster")
@NamedQueries({
    @NamedQuery(name = "Groupmaster.findAll", query = "SELECT g FROM Groupmaster g"),
    @NamedQuery(name = "Groupmaster.findByGroupMasterID", query = "SELECT g FROM Groupmaster g WHERE g.groupMasterID = :groupMasterID"),
    @NamedQuery(name = "Groupmaster.findByGroupName", query = "SELECT g FROM Groupmaster g WHERE g.groupName = :groupName")})
public class Groupmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupMasterID")
    private Integer groupMasterID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "groupName")
    private String groupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupMasterid")
    private Collection<Dealer> dealerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupMasterid")
    private Collection<User> userCollection;

    public Groupmaster() {
    }

    public Groupmaster(Integer groupMasterID) {
        this.groupMasterID = groupMasterID;
    }

    public Groupmaster(Integer groupMasterID, String groupName) {
        this.groupMasterID = groupMasterID;
        this.groupName = groupName;
    }

    public Integer getGroupMasterID() {
        return groupMasterID;
    }

    public void setGroupMasterID(Integer groupMasterID) {
        this.groupMasterID = groupMasterID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Collection<Dealer> getDealerCollection() {
        return dealerCollection;
    }

    public void setDealerCollection(Collection<Dealer> dealerCollection) {
        this.dealerCollection = dealerCollection;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupMasterID != null ? groupMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmaster)) {
            return false;
        }
        Groupmaster other = (Groupmaster) object;
        if ((this.groupMasterID == null && other.groupMasterID != null) || (this.groupMasterID != null && !this.groupMasterID.equals(other.groupMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Groupmaster[ groupMasterID=" + groupMasterID + " ]";
    }
    
}
