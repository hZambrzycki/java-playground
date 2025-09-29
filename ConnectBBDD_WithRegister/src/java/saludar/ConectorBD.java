/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludar;

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
    String bd = "usuarios";
    String user = "user";
    String pass = "pass";
    String URL = "jdbc:mysql://" + servidor + ":3306/" + bd
            + "?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";

    public ConectorBD() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                System.out.println(URL);
                conexion = DriverManager.getConnection(URL, user, pass);

                System.out.println("conectado");
            } catch (SQLException ex) {
                System.out.println("sqlexception");
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("classnotfoundexception");
//            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean insertarUsuario(Usuario u) {
        Statement s;
        boolean success = false;
        try {
            s = this.conexion.createStatement();
            System.out.println("statement creado");
            String sql = "insert into usuarios values ('" + u.getN() + "', '" + u.getP() + "', '" + u.getE() + "')";
            System.out.println(sql);
            success = (s.executeUpdate(sql)==1);
        } catch (SQLException ex) {
            System.out.println("problema al crear el objeto statement");

            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;

    }

    ArrayList<Usuario> recuperarTodosLosUsuarios() {

        ResultSet rs = null;
        Statement s = null;
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        try {
            s = this.conexion.createStatement();
            System.out.println("statement creado");
            String sql = "select * from usuarios;";
            System.out.println(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {
                //cojo datos y creo un objeto Usuario
                String n = rs.getString(1);
                String p = rs.getString(2);
                String e = rs.getString(3);
                Usuario u = new Usuario(n, p, e);
                //añado el objeto al ArrayList
                list.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    boolean comprobar_ususario_pass (String user, String pass){
        ResultSet rs = null;
        Statement s = null;
        boolean existe=false;
        try {
            s = this.conexion.createStatement();
            System.out.println("statement creado");
            String sql = "select * from usuarios where (nombre='+user+')AND (pass='+pass+');";
//            System.out.println(sql);
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
