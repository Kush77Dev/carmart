/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Kush Khakhiwala
 */
public class CustomBCryptPasswordHash {
//    @Override
    public String generate(char[] password) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return BCrypt.hashpw(String.valueOf(password), BCrypt.gensalt());
    }

//    @Override
    public boolean verify(char[] password, String hashedPassword) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return BCrypt.checkpw(String.valueOf(password), hashedPassword);
    }
    
}
