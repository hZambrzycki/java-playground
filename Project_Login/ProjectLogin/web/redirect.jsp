<%-- 
    Document   : redirect
    Created on : 29 oct 2021, 8:38:50
    Author     : dawmi
--%>

<%@page import="java.util.concurrent.TimeUnit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                text-align: center;
            }
        </style>
    </head>
    <body>
      

        <%
            char valor = ((Character) session.getAttribute("value"));
            
            switch (valor) {
                
                case 'l':
               String nombre = ((String) session.getAttribute("nombre"));
                    
        %>
        <h1>Bienvenido de nuevo</h1>
        <h2>Seleccione lo que quiere hacer :</h2>
        <br>
        <br>
        <form method="post" action="mensajeria">
            <input type="hidden" name="option" value="vMensajes" >
            <input type="hidden" name="nombre" value="<%out.println(nombre);%>">
            <input type="submit" value="Ver todos los mensajes">
        </form>
        <form method="post" action="mensajeria">
            <input type="hidden" name="option" value="vMNuevos">
            <br>
            <br>
            <input type="submit" value="Ver mensajes recibidos nuevos">
        </form>
        <form method="post" action="mensajeria">
            <input type="hidden" name="option" value="eMensaje">
            <input type="hidden" name="nombre" value="<%out.println(nombre);%>">
            <br>
            <br>
            <input type="submit" value="Escribir Mensaje">
        </form>
        <%
        
            
                break;
                
                
                case 'c':
                %><h1>USUARIO CREADO</h1>
                <h1>Introduzca su cuenta de usuario</h1>
            <br>
            <br>
             <form method="post" action="servidor">
                    Introduzca su nombre <br>
                    <input type="text" name="nombre" required><br>
                    Introduzca su contraseña <br>
                    <input type="text" name="password" required><br> 
                    <input type="hidden" name="option" value="login">
                    <input type="submit">
            </form>
          <%
                break;
                
            case 'e':
                int contInt = ((Integer) session.getAttribute("contador"));
                contInt++;
                System.out.println(contInt);

                if (contInt >= 3) {

                TimeUnit.SECONDS.sleep(10);
                }

                %><h1>ERROR LOGIN</h1>
               <form method="post" action="servidor">
                Introduzca su nombre <br>
               <input type="text" name="nombre" required=""><br>
                Introduzca su contraseña <br>
               <input type="text" name="password" required=""><br> 
               <input type="hidden" name="option" value="login">
               <input type="hidden" name="contador" value="1">
               <input type="submit">
               </form>
        <%   
            break;
            
            
            case 'p':
        %><h1>ERROR CREAR CUENTA</h1><%
                break;
                
                
                
                
            case 'w':
        %><h1>Buena contraseña</h1><%
                break;
                
                
                
            case 'f':
        %><h1>Mala</h1><%
                break;
                
                
            case 'n':
        %><h1>Mala</h1><%
                    break;
                default:
            }
     
        %>
    </body>
</html>
