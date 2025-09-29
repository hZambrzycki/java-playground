package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hz
 */

public class ConectorBD {
        
    Connection conexion = null;
   
    String user = "hubert";
    String pass = "1234";

    String URL = "jdbc:mysql://localhost:3306/account?user=hubert&password=1234&serverTimezone=UTC&autoRecconect=true&useSSL=false&allowPublicKeyRetrieval=true";

    public ConectorBD() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            try {

                conexion = DriverManager.getConnection(URL, user, pass);

                System.out.println("conectado");
            } catch (SQLException ex) {
                System.out.println("sqlexception");
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("classnotfound");
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Boolean insertarUsuario(Usuario u) {
        Boolean success = false;
        try {

            Statement s = this.conexion.createStatement();

            String sql = "insert into accounttable values('" + u.getNombre() + "','" + u.getPassword() + "','" + u.getEmail() + "','" + u.getAddress() + "')";
            System.out.println(sql);
            try {
                int nfilas = s.executeUpdate(sql);

                if (nfilas == 1) {
                    success = true;
                } else {
                    success = false;
                }
                if(u.getNombre().equalsIgnoreCase("") || u.getPassword().equalsIgnoreCase("") || u.getAddress().equalsIgnoreCase("") || u.getEmail().equalsIgnoreCase("")) {
                    success = false;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

    public boolean consultarUsuario(String nombre, String pass) {
        ResultSet rs = null;
        Statement s = null;
        boolean existe = false;
     
        try {
            s = this.conexion.createStatement();
            System.out.println("statement create");
            String sql = "select * from accounttable where(Nombre='" + nombre + "')and(Password='" + pass + "');";
            System.out.println(sql);
            rs = s.executeQuery(sql);


    
            while (rs.next()) {
               existe = true;
              
            }
            
             return existe;
             

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    
    
    }


