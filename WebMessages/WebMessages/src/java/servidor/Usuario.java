/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hz
 */
public class Usuario implements Serializable{
    
    private static final AtomicInteger count = new AtomicInteger(0); 
    private String nombre;
    private String password;
    private String email;
    private String address;
    private int id;
    
       public Usuario(String nombre, String password, String email, String address) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.address = address;
        id = count.incrementAndGet(); 
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}