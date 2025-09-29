<%-- 
    Document   : form
    Created on : 15 oct 2021, 9:56:05
    Author     : dawmi
--%>

<%@page import="saludar.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, tr, thead,td{
                border-collapse: collapse;
                border: 1px solid black;
            }
            
            thead{
                background-color: lightblue;
                font-size: 1.2em;
            }
            h1,h2,h3{
                text-align: center;
                background-color: lightgreen;
            }
            .contenedortabla{margin-left: 40%}
                               
            
            .formulario{
                align-content: center
            }
            form{
                align-content: center;
            }
            
        </style>
    </head>
    <body>
       


        <%  char opt = (Character) session.getAttribute("option");

            switch (opt) {
                case 'i':

                    boolean success = (Boolean) session.getAttribute("insertcorrecto");
                    if (success) {
        %>
        <h2>Inserción correcta!</h2>

        <%
        } else {
        %>
        <h2>Inserción chunga :-( </h2>
        <%
                }
                break;
            case 's':%>

        <h2>CONSULTA DATOS</h2>
        <div class="contenedortabla">
        <table>
            <thead>
            <td>Usuario</td>
            <td>Password</td>
            <td>Email</td>
        </thead>
        <%
            ArrayList<Usuario> lu = (ArrayList<Usuario>) session.getAttribute("userslist");

            for (Usuario usuario : lu) {
        %>
        <tr>
            <td><%out.print(usuario.getN());%></td>
            <td><%out.print(usuario.getP());%></td>
            <td><%out.print(usuario.getE());%></td>
        <tr>
            <%
                }
            %>



    </table>
    </div>        
    <%
                break;

        }
    %>




    <h2> Nueva Consulta</h2>
    
    <h3>Insertar nuevo usuario</h3>
    
    
    <form action="saludar" method="post">
        
        Mi nombre es: <input type="text" name="name">
        <br>
        Mi contraseña es: <input type="text" name="pass">
        <br>
        Mi e-mail es: <input type="text" name="mail">
        <br>
        <input type="hidden" name="option" value="ins">
        <input type="submit" value="Añadir usuario">
    </form>
    
        
        <h3>Consultar usuarios</h3>
    <form action="saludar" method="post">
        
        <input type="hidden" name="option" value="sel">
        <input type="submit" value="Ver todos los usuarios">
    </form>
        
        
</body>
</html>
