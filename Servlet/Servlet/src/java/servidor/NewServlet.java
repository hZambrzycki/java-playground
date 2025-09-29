package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hz
 */
public class NewServlet extends HttpServlet {
//int contador = 0;
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
        
        int contador = Integer.parseInt(request.getParameter("contador"));
        
        String nombre = request.getParameter("nombre");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet"+nombre+"</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mi prueba de servlet" + request.getContextPath() + "</h1>");
            
            
            randomNumber x = new randomNumber();
             
              out.println("<h1>Mi prueba de Servlet me da un número aleatorio : "
                      + "" + x.getX() + "</h1>");
            
            out.println("<h1>¿Quieres otro número?</h1>");
              contador++;
            out.println("<button> <a href=\"servlet?contador="+contador+"\">Si</a></button>");
             // servlet?contador >> se ejecuta el servlet y por el otro lado
             //el contador que lo almacena el propio servlet sabiendo diferenciar
             //debido al primer login de la primera pagina, donde esta declarado
             // a 0.
            out.println("<form method=\"post\" action=\"servlet\">\n" +
"            <input type=\"hidden\" name=\"contador\" value=\"" +contador +"\">\n" +
"            <input type=\"submit\">\n" +
"        </form>");
           
            out.println("<h1>El contador de veces que me has pedido número es : " + contador +" </h1>");
    //El cliente y el servidor se comunican a traves dos objetos: 
    //request y response, el modo de ejecucion es que el cliente 
    //a traves del navegador hace una request al servlet, el servlet
    //se ejecuta hace una response, la devuelve y aupa. 
    //En el request viene un parametro contador, que 
    //inicialmente es 0, esta puesto en la url del <a> de arriba.
    //Ejecutando cualquiera de los, el usuario humano que soy produzco
    //una request. Con el form de arriba lo hacemos por post. El <a>
    //es un get. En el metodo request pillamos un parametro contador y
    //lo truncamos a int
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
