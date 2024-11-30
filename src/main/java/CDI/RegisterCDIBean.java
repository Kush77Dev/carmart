/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package CDI;

import client.user;
import entities.User;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.Collection;
//import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kush Khakhiwala
 */
@Named(value = "registerCDIBean")
@RequestScoped
public class RegisterCDIBean {

    @Inject
    private user u;

    @Inject
    private Pbkdf2PasswordHash pb;

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private Integer groupMasterId = 2;

    private User u1;
    private Collection<User> users;
    private GenericType<Collection<User>> gusers;

    /**
     * Creates a new instance of RegisterCDIBean
     */
    public RegisterCDIBean() {
        users = new ArrayList<>();
        gusers = new GenericType<Collection<User>>() {
        };
    }

    @PostConstruct
    public void init() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "2048");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA256");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "32");
        parameters.put("Pbkdf2PasswordHash.KeySizeBytes", "32");
        pb.initialize(parameters);
    }

    // Getters and Setters
    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    public Pbkdf2PasswordHash getPb() {
        return pb;
    }

    public void setPb(Pbkdf2PasswordHash pb) {
        this.pb = pb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getGroupMasterId() {
        return groupMasterId;
    }

    public void setGroupMasterId(Integer groupMasterId) {
        this.groupMasterId = groupMasterId;
    }

    public User getU1() {
        return u1;
    }

    public void setU1(User u1) {
        this.u1 = u1;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public GenericType<Collection<User>> getGusers() {
        return gusers;
    }

    public void setGusers(GenericType<Collection<User>> gusers) {
        this.gusers = gusers;
    }

    public String addUser() {
        try {
            String hashedPassword = pb.generate(password.toCharArray());
            u.addUser(name, email, hashedPassword, address, phoneNumber, String.valueOf(groupMasterId));
            return "login";

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error adding customer", e.getMessage()));
            return "error";
        }
    }

}
