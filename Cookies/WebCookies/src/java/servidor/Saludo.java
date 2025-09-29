/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String valorNombre = request.getParameter("nombre");
        String contador = null;

        if (valorNombre == null) //No es la primera ejecucion, la peticion
        //no llega de index.html   
        {
            Cookie[] rC = request.getCookies(); //rc Recuperar Cookies
            for (Cookie cookie : rC) {

                if (cookie.getName().equalsIgnoreCase("nombre")) {
                    valorNombre = cookie.getValue();
                    // break;
                }
                if (cookie.getName().equalsIgnoreCase("contador")) {

                    contador = cookie.getValue();

                    int contInt = Integer.parseInt(contador);

                    contInt++;

                    contador = Integer.toString(contInt);

                    Cookie count = new Cookie("contador", contador);
                    //Al crear una Cookie dará igual el nombre que le damos ""
                    //, el valor posterior puede ser "1"
                    response.addCookie(count);

                 //break; Quitamos los break al tratar con dos COokies a la vez
                }
  //cookie cookie Cookie v, como quieras que se llamen a los elementos del array
            }

        } else {
            //primera preticion, proviene de index.html
            //jerarquia de creacion, y tratamiento de cookies > importante.
            
            Cookie c = new Cookie("nombre", valorNombre);
            c.setMaxAge(10);
            //String contador = "1" || lo mismo que poner 1 en valor. Es
            //Importante darle valor al contador antes de la creacion de la cookie
            //Debido a que si no dará fallo de tipo null.
            contador = "1"; 
            
            Cookie count = new Cookie("contador", contador);//"contador", "contador"
           
            response.addCookie(count);
            response.addCookie(c);

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");
            out.println("<title>Servlet con la Cookie</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tu nombre es: " + valorNombre + "  , a las   : " + LocalDateTime.now() + "</h1>");
            out.println("<a href=\"saludar\">Volver a saludar</a>");
            out.println("<h1>El servlet te ha saludo " + contador + " veces");
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

//    private void generarPrimeraRespuesta(HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet con la Cookie</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Tu nombre es: " + valorNombre + "  , a las   : " + LocalDate.now()+ "</h1>");
//            out.println("<a href=\"saludar\">Volver a saludar</a>");
//            
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
}
