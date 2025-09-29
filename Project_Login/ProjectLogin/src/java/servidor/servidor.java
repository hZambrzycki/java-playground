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

        String cont = request.getParameter("contador");

        int aux = 0;

        switch (option) {

            case "login":

                String nombre = request.getParameter("nombre");
                String password = (request.getParameter("password"));
                s.setAttribute("nombre", nombre);
                s.setAttribute("password", password);

                boolean existe = c.consultarUsuario(nombre, password);
                if (existe) {
                    boolean concuerda = c.consultarPassword(password);
                    s.setAttribute("value", 'l');
                    if (concuerda == true) {
                        
                      
                        System.out.println(existe);
                        response.sendRedirect("redirect.jsp");
                    } else {
                        s.setAttribute("value", 'f');
                        response.sendRedirect("redirect.jsp");
                    }

                } else {

                    if (cont == null) {

                        aux = 1;

                    } else {

                        aux = Integer.parseInt(cont);
                        aux++;

                    }

                    s.setAttribute("contador", aux);
                    System.out.println("contador: " + aux);
                    s.setAttribute("value", 'e');
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

                if (c.insertarUsuario(u) == true) {
                    s.setAttribute("value", 'c');
                    if (c.consultarPassword(passwordStr) == true) {
                        s.setAttribute("value", 'w');
                    } else {
                        s.setAttribute("value", 'n');
                    }
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
