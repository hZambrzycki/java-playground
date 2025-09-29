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
        <h1>Hello World!</h1>

        <%
            char valor = ((Character) session.getAttribute("value"));
           
            switch (valor) {
                case 'l':
        %><h1>LOGIN CONSEGUIDO</h1>
        <h4>Tiene acceso a 50 funciones</h4><%
                break;
            case 'c':
        %><h1>USUARIO CREADO
            <h1>Introduzca su cuenta de usuario</h1>
            <br>
            <br>
            <form method="post" action="servidor">
                Introduzca su nombre <br>
                <input type="text" name="nombre"><br>
                Introduzca su contraseña <br>
                <input type="text" name="password"><br> 
                <input type="hidden" name="option" value='login'>
                <input type="hidden" name="contador" value="0">
                <input type="submit">
            </form>
        </h1><%
                break;
            case 'e':
              int contInt = ((Integer) session.getAttribute("contador"));
            contInt++;
            System.out.println(contInt);

            if (contInt == 3) {
                
                TimeUnit.SECONDS.sleep(10);
            }
        %><h1>ERROR LOGIN</h1>
        <form method="post" action="servidor">
            Introduzca su nombre <br>
            <input type="text" name="nombre"><br>
            Introduzca su contraseña <br>
            <input type="text" name="password"><br> 
            <input type="hidden" name="option" value="login">
            <input type="hidden" name="contador" value="1">
            <input type="submit">
        </form>
        <%
            
               
                break;
           case 'p':
        %><h1>ERROR CREAR CUENTA</h1><%
                break;
                case 'f':
               

        %><h1>3 INTENTOS LOGIN FALLIDOS</h1><%
            
                break;
            default:
        }
        %>
    </body>
</html>
