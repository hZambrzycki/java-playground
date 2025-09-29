<%-- 
    Document   : Segundo_usuario
    Created on : 15 oct 2021, 9:01:28
    Author     : dawmi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="servidor.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiere introducir otra vez otro usuario?</title>
        <style>
            
       table, tr, td {
        text-align: center;
        border: 1px solid black; 
        border-collapse: collapse;
        }
     
        </style>
    </head>
    <body>

        <%   char opt = ((Character) session.getAttribute("option"));

            switch (opt) {
                case 'i':
                    boolean success = (Boolean) session.getAttribute("estadoValidacionInsercion");
                     if (success) { %>
        <h2>Insercion correcta</h2>
        <%     } else { %>
        <h2>Insercion Incorrecta</h2>
        <%  }

                break;

            case 's':
                ArrayList<Usuario> lu = (ArrayList<Usuario>) session.getAttribute("userList");
        %>
        <table>       
            <tr>
                <th>Nombre</th>
            <%
                for (Usuario usuario : lu) {
            %>  <td><%
                out.print(usuario.getNombre());
            %>  </td><%
          }
                %>
            </tr>
           

            <tr>
                <th>Password</th>
            <%
                for (Usuario usuario : lu) {
            %><td><%
            out.print(usuario.getPassword());
                    %></td><%
                }
                %>
            </tr>
         
            <tr>
                <th>Email</th>
            <%
                for (Usuario usuario : lu) {
            %><td><%
         out.print(usuario.getEmail());
                    %></td><%
             }
                %>
            </tr>

            <tr>
                <th>Address</th>
            <%
                for (Usuario usuario : lu) {
            %><td><%
     out.print(usuario.getAddress());
                    %></td><%
         }
                %>
            </tr>
        </table> 

        <%
                    break;
                default:
            }


        %>
        <h1>Introduzca otro usuario</h1>
        <form method="post" action="servlet">
            Introduzca su nombre <br>
            <input type="text" name="nombre"><br>
            Introduzca su contraseña <br>
            <input type="text" name="password"><br>
            Introduzca su email <br>
            <input type="text" name="email"><br>
            Introduzca su dirección <br>
            <input type="text" name="address"><br>
            <input type="hidden" name="option" value="ins">
            <input type="submit">
        </form>

        <form method="post" action="servlet">
            Ver todos los usuarios
            <input type="hidden" name="option" value="sel">
            <input type="submit">
        </form>
    </body>
</html>
