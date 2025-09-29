/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dawmi
 */
public class NewServlet extends HttpServlet {
    Scanner teclado = new Scanner(System.in);
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
        
        String nombre = request.getParameter("nombre");
        int lim1 = Integer.parseInt(request.getParameter("lim1"));
        int lim2 = Integer.parseInt(request.getParameter("lim2"));
      
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juegecito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juego del azar. </h1>");
            out.println("<h2>Tu nombre es  "+ nombre +" has introducido :</h2>");
            out.println("<h2>El numero minimo introducido : "+ lim1 +"</h2>");
            out.println("<h2>El numero maximo introducido : "+ lim2 +"</h2>");
            out.println("Estos serán tus limites.");
            out.println("<br>");
            out.println("Ahora introduce un número para empezar el juego");
            out.println("<br>");
           
           
            out.println("<form method=\"post\" action=\"limites\">\n" +
 
"         <input type=\"hidden\" name=\"lim1\"> \n" +

"         <input type=\"hidden\" name=\"lim2\">\n" +
           
"         <input name=\"nombre\" type=\"hidden\">\n" +
  "<input type=\"number\" name=\"numero\">  \n" + "<input type=\"submit\">  \n"+
"        </form>");
            
             int numero = Integer.parseInt(request.getParameter("numero"));
             
             
            
            out.println("</body>");
            out.println("</html>");
            
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
