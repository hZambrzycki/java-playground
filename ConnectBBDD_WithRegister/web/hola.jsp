<%-- 
    Document   : hola
    Created on : 13 oct 2021, 8:50:03
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
        <h1>Hello World!</h1>

        <% String name = ((String) session.getAttribute("name"));
            boolean correct_user = ((Boolean) session.getAttribute("correct-user"));
        %>

        <%  out.println(correct_user);
            if (correct_user) {
        %><h1>
            <%
                out.print("correcto " + name);
            %></h1>
            <%
                } else {
                    out.print("incorrecto " + name);

                }
            %>
        <h1>Hello World!</h1>
    </body>
</html>
