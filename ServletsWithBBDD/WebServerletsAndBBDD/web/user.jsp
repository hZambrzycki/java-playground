<%-- 
    Document   : user
    Created on : 15 oct 2021, 9:30:40
    Author     : zeta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
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
