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

            String sql = "insert into accounttable values('" + u.getNombre() + "','" + u.getPassword()+"'";
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

   boolean comprobar_ususario_pass (String user, String pass){
        ResultSet rs = null;
        Statement s = null;
        boolean existe=false;
        try {
            s = this.conexion.createStatement();
            System.out.println("statement creado");
            String sql = "select * from accounttable where (Nombre='+user+') AND (Password='+pass+');";

            rs = s.executeQuery(sql);

            if (rs!= null) {
                //si veduelve alguna fila esque el login está correcto
                
               existe=true;
                return existe;
            }
            
            else{
                return existe;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
                return existe;
        
    }

    }


