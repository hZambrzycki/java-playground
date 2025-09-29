/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

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
    String servidor = "localhost";
    String bd = "account";
    String user = "hubert";
    String pass = "1234";
    //String URL="jdbc:mysql://" + servidor + ":3306/" + bd + "?autoRecconect=true&useSSL=false";
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
               
               if(nfilas == 1) {
                   success = true;
               } else {
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

    ArrayList<Usuario> recuperarUsers() {

        Statement s = null;
        ResultSet rS = null;

        ArrayList<Usuario> listaUsers = new ArrayList<Usuario>();

        try {
            s = this.conexion.createStatement();
            System.out.println("Statement creado");
            String sql = ("select * from accounttable;");
            System.out.println(sql);
            try {
                rS = s.executeQuery(sql);
            } catch (SQLException ex) {
                System.out.println("Ha cascado el executeQuerry");
            }
              
            
            while(rS.next()) {
                //cojoDatos y creo un objetoUsuario
                String nombre = rS.getString(1);
                String apellido = rS.getString(2);
                String email = rS.getString(3);
                String address = rS.getString(4);
                
                Usuario user = new Usuario(nombre,apellido,email,address);
                 //añado el objeto al ArrayList
                listaUsers.add(user);
                //rS.getMetaData() para saber que conforma tu tabla
            }
        } catch (SQLException ex) {
            System.out.println("Ha cascado crear el statement");
        }

        return listaUsers;

    }

    }


