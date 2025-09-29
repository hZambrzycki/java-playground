package servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author hz
 */
public class servidor extends HttpServlet {
       
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        ConectorBD c = new ConectorBD();
        HttpSession s = request.getSession();
    
        switch (option) {
            
            case "login":
               
                String nombre = request.getParameter("nombre");
                String password = (request.getParameter("password"));
                s.setAttribute("nombre", nombre);
                s.setAttribute("password", password);
                
                
                boolean existe = c.consultarUsuario(nombre, password);
                
                if(existe == true) {
                    s.setAttribute("value", 'l');
                    System.out.println(existe);
                    response.sendRedirect("redirect.jsp");
                } else {
                    
            int contador = Integer.parseInt(request.getParameter("contador"));
                    s.setAttribute("value", 'e');
                    s.setAttribute("contador", contador);
                    System.out.println(existe);
                    response.sendRedirect("redirect.jsp");
                }
                break;

            case "create":
                
                String nombreStr = request.getParameter("nombre");
                String passwordStr = request.getParameter("password");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                
                
                
                Usuario u = new Usuario(nombreStr, passwordStr, email, address);
                
                if(c.insertarUsuario(u)== true) {
                    s.setAttribute("value", 'c');
                    
                    response.sendRedirect("redirect.jsp");
                   
                } else {
                    s.setAttribute("value", 'p');
                    response.sendRedirect("redirect.jsp");
                }
               
               
                
                break;

            default:
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
