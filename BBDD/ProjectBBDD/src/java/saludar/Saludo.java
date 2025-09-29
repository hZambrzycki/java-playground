/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludar;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hz
 */
public class Saludo extends HttpServlet {

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

        String opt = request.getParameter("option");
        ConectorBD c = new ConectorBD();
        HttpSession s = request.getSession();

        switch (opt) {
            case "ins":
                String n = request.getParameter("name");
                String p = request.getParameter("pass");
                String e = request.getParameter("mail");

                Usuario u = new Usuario(n, p, e);
                boolean insertCorrecto = c.insertarUsuario(u);
                s.setAttribute("option", 'i');
                s.setAttribute("insertcorrecto", insertCorrecto);

                response.sendRedirect("form.jsp");
                break;
            case "sel":
                ArrayList<Usuario> list = c.recuperarTodosLosUsuarios();
                s.setAttribute("option", 's');
                s.setAttribute("userslist", list);

                response.sendRedirect("form.jsp");
                break;
                
            case "log":
                String usuario= request.getParameter("usuario");
                String pass= request.getParameter("password");
                System.out.println(usuario);
                System.out.println(pass);
                boolean existe=c.comprobar_ususario_pass(usuario, pass);
                if (existe) {
                    System.out.println(existe);
                response.sendRedirect("ok.jsp");
                }
                else{
                    System.out.println(existe);   
                response.sendRedirect("nook.jsp");
                }
                break;
            case "reg":
                
                
                
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
