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

    // String user = "user";
    // String pass = "pass";
    //  String URL = "jdbc:mysql://localhost:3306/usuarios?user=hubert&password=1234&serverTimezone=UTC&autoRecconect=true&useSSL=false&allowPublicKeyRetrieval=true";
    String user = "hubert";
    String pass = "1234";

    String URL = "jdbc:mysql://localhost:3306/account?user=user&password=pass&serverTimezone=UTC&autoRecconect=true&useSSL=false&allowPublicKeyRetrieval=true";

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
            
            String sql = "insert into accounttable values('"+ u.getId() + "','" + u.getNombre() + "','" + u.getPassword() + "','" + u.getEmail() + "','" + u.getAddress() + "');";
            System.out.println(sql);
            try {
                int nfilas = s.executeUpdate(sql);

                if (nfilas == 1) {
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

    public boolean consultarPassword(String pass) {

        Statement s = null;
        boolean concuerda = false;

        try {
            s = this.conexion.createStatement();
            System.out.println("statement create1");
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            System.out.println(pass.matches(pattern));

            if (pass.matches(pattern)) {
                concuerda = true;
            } else {
                concuerda = false;
            }

            //(?=.*[0-9]) a digit must occur at least once
            //(?=.*[a-z]) a lower case letter must occur at least once
            //(?=.*[A-Z]) an upper case letter must occur at least once
            //(?=.*[@#$%^&+=]) a special character must occur at least once
            //(?=\\S+$) no whitespace allowed in the entire string
            //.{8,} at least 8 characters
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return concuerda;
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
                String nombre = rS.getString(2);
                String apellido = rS.getString(3);
                String email = rS.getString(4);
                String address = rS.getString(5);
              
                
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
       ArrayList<Mensaje> listaMensajes(String nombre) {
           Statement s = null;
           ResultSet rs = null;
           
           ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
           
             try {
            s = this.conexion.createStatement();
            System.out.println("Statement creado");
            String sql = "select IDrem from mensaje where(remitente='" + nombre + "');";
          
           
            System.out.println(sql);
            try {
                rs = s.executeQuery(sql);
                
                
            } catch (SQLException ex) {
                System.out.println("Ha cascado el executeQuerry");
            } 
                 System.out.println("ESTOY FUERA");
              while(rs.next()) {
                   System.out.println("ESTOY DENTRO");
                //cojoDatos y creo un objetoUsuario
            
                String remitente = rs.getString(3);
                  System.out.println(remitente);
                String destinatario = rs.getString(4);
                  System.out.println(destinatario);
                String mensaje = rs.getString(5);
                  System.out.println(mensaje);
                 
           
               Mensaje m = new Mensaje(remitente, destinatario, mensaje);
                 //añado el objeto al ArrayList
               listaMensajes.add(m);
                //rS.getMetaData() para saber que conforma tu tabla
            }
                 System.out.println("VUELVO A ESTAR FUERA");
        } catch (SQLException ex) {
            System.out.println("Ha cascado crear el statement");
        }
        return listaMensajes;
       }
 
       public boolean insertarMensaje(Mensaje m) {
           Statement s = null;
           boolean success = true;
           
            try {
            s = this.conexion.createStatement();
               
            String sql = "insert into mensaje values('"+ m.getId()+ "','"+ m.getRemitente()+ "','" + m.getDestinatario() + "','" + m.getMensaje()+ "');";
            System.out.println(sql);
            try {
                int nfilas = s.executeUpdate(sql);
                if (nfilas == 1) {
                    success = true;
                } else {
                   success = false;               }
            } catch (SQLException ex) {
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }catch (SQLException e) {
           Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, e);
       }
            return success;
       }
       
       public boolean consultarID(String nombre) {
           Statement s = null;
           ResultSet rs = null;
           boolean existe = false;

        try {
            s = this.conexion.createStatement();
            System.out.println("statement create");
             String sql =  "select ID from accounttable where(Nombre='" + nombre + "')";
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
        

     
     
     
     

