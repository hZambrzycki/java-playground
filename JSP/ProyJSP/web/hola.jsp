<%-- 
    Document   : jsp_prueba
    Created on : 13 oct 2021, 8:47:28
    Author     : dawmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos correctos!</h1>
        <% String nombre = ((String) session.getAttribute("nombre")); %>
        <% int password = ((Integer) session.getAttribute("password")); %>
        <div> Tus credenciales, Con tu nombre de usuario : <br>
            <% out.print(nombre);%>
            ,<br> Son correctas </div>
            <br>
            <div> Con la contraseña : 
                <% out.print(password); %> </div>
    </body>
</html>
