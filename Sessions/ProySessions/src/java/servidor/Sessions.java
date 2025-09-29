/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hz
 */
public class Adivino extends HttpServlet {

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

        String nombre = request.getParameter("nombre");
        int min = Integer.parseInt(request.getParameter("min"));
        	int max = Integer.parseInt(request.getParameter("max"));
        	int rand = generarAleatorio(min, max);

        if (nombre != null) {

            HttpSession s = request.getSession();
            s.setAttribute("sesion", nombre);
            s.setAttribute("max", min);
            s.setAttribute("min", min);
            s.setAttribute("rand", rand);
            
            generarPrimeraRespuesta(response, nombre, min, max, rand);
        } else {
            HttpSession s = request.getSession();
            nombre = (String) s.getAttribute(nombre);
            min = (Integer) s.getAttribute("min");
            max = (Integer) s.getAttribute("max");
            rand = (Integer) s.getAttribute("rand");
        int conj = (Integer) s.getAttribute("conj");
            
            if(conj == rand) {
                generarRespuestaAcierto(response, nombre, conj);
            } else if (FueraDeLimites(conj, min, max)) {
                generarRespuestaLimites(response, min, max, nombre);
            } else if (conj < rand) {
                generarRespuestaMenor(response, nombre, min, max, rand);
            } else {
                generarRespuestaMayor(response, nombre, min, max, rand);
            }
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
       private boolean primeraVez(HttpServletRequest request) {
        String randExiste = request.getParameter("rand");
        if(randExiste == null) {
            return true;
        } else {
             return false;
        }
    }

    private int generarAleatorio(int min, int max) {
       return (int) (min + (max-min +1) * Math.random());
    }

    private void generarPrimeraRespuesta(HttpServletResponse response, String nombre, int min, int max, int rand) throws IOException {
      response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
                   
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>JUEGO DEL AZAR</title>");            
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>¿Cual crees que es el numero oculto?</h1>");
          
          out.println("<form method=\"post\" action=\"adivino\">\n" +
"            <br>\n" +
"            <input type=\"text\" name=\"conj\" >\n" +                  
"            <input type=\"hidden\" name=\"nombre\" value=\""+ nombre +"\">\n" +
"            <br>\n" +
"            <input type=\"hidden\" name=\"max\" value=\""+ max + "\">\n" +
"            <br>\n" +
"            <input type=\"hidden\" name=\"min\" value=\""+min + "\">\n" +    
"            <input type=\"hidden\" name=\"rand\" value=\"" + rand + "\">\n" +     
"            <br>\n" +
"            Enviar <input type=\"submit\">\n" +
"            <br>\n" +
"            </form>");
          
          out.println("</body>");
          out.println("</html>");
    }
    }


    private void generarRespuestaAcierto(HttpServletResponse response, String nombre, int conj) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
                   
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>JUEGO DEL AZAR</title>");            
          out.println("</head>");
          out.println("<body>");
          out.println("Felicidades. Has adivinado el numero");
      
          
          out.println("Quieres jugar otra vez?");
          out.println("<form method=\"post\" action=\"index.html\">\n" +
"            <br>\n" +        
"            <h1>Tu nombre es: </h1>"+ 
"            <input type=\"text\" name=\"nombre\" value=\""+ nombre +"\">\n"+
"            <h1>Tu numero seleccionado ha sido :  </h1>"+ 
"            <input type=\"text\" name=\"conj\" value=\""+ conj +"\">\n" +
"            <br>\n" +  
             "<input type=\"submit\">\n" +
"            <br>\n" +
"            </form>");
          
          out.println("</body>");
          out.println("</html>");
    }
    }

    private void generarRespuestaLimites(HttpServletResponse response, int min, int max, String nombre) throws IOException {
     response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
           out.println("El numero introducido sobrepasa los limites establecidos");
           out.println("Pulsa para introducir otro numero");
          out.println("<form method=\"post\" action=\"adivino\">\n" +
"            <br>\n" +          
"            <input type=\"hidden\" name=\"min\" value=\""+ min +"\">\n"+
"            <input type=\"hidden\" name=\"max\" value=\""+ max +"\">\n" +
        "            <input type=\"hidden\" name=\"nombre\" value=\""+ nombre +"\">\n" +
"            <br>\n" +  
"            <br>\n" +
"            Enviar <input type=\"submit\">\n" +
"            <br>\n" +
"            </form>");
      
      }
    }

    private void generarRespuestaMenor(HttpServletResponse response, String nombre, int min, int max, int rand) throws IOException {
            response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
           out.println("El numero introducido es menor al numero aleatorio");
           out.println("Pulsa para introducir otro numero");
          out.println("<form method=\"post\" action=\"adivino\">\n" +
"            <br>\n" +          
"            <input type=\"hidden\" name=\"min\" value=\""+ min +"\">\n"+
"            <input type=\"hidden\" name=\"max\" value=\""+ max +"\">\n" +
        "            <input type=\"hidden\" name=\"nombre\" value=\""+ nombre +"\">\n" +
"            <br>\n" +  
"            <br>\n" +
"            Enviar <input type=\"submit\">\n" +
"            <br>\n" +
"            </form>");
      
    }
    }
    private void generarRespuestaMayor(HttpServletResponse response, String nombre, int min, int max, int rand) throws IOException {
            response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
           out.println("El numero introducido es mayor al numero generado");
           out.println("Pulsa para introducir otro numero");
          out.println("<form method=\"post\" action=\"adivino\">\n" +
"            <br>\n" +          
"            <input type=\"hidden\" name=\"min\" value=\""+ min +"\">\n"+
"            <input type=\"hidden\" name=\"max\" value=\""+ max +"\">\n" +
        "            <input type=\"hidden\" name=\"nombre\" value=\""+ nombre +"\">\n" +
"            <br>\n" +  
"            <br>\n" +
"            Enviar <input type=\"submit\">\n" +
"            <br>\n" +
"            </form>");
      
    }
    }
    	private boolean FueraDeLimites(int conj, int min, int max) {
    	if(conj < min || conj > max) {
            return false;
        } else {
            return true;
        }

	}
}
