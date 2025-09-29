<%-- 
    Document   : mensajeria
    Created on : 5 nov 2021, 8:34:34
    Author     : dawmi
--%>

<%@page import="servidor.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servidor.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionalidades</title>
        <style>
            * {
                text-align: center;

            }
            table {
                margin-left: auto;
                margin-right: auto;
            }
            table,th,td {

                border: 1px solid black;
                border-collapse: collapse;
            }


        </style>
    </head>
    <%
        char valor = ((Character) session.getAttribute("option"));

        switch (valor) {
            case 'a':
    %>  <h1>Ver todos los mensajes</h1>   
    <%ArrayList<Mensaje> lM = (ArrayList<Mensaje>) session.getAttribute("listaMensajes");%>
    <%   String nombre = ((String) session.getAttribute("nombre"));   %> 

    <h1>Bienvenido de nuevo : <% out.println(nombre);%></h1>

    <input type="hidden" name="nombre" value="<%out.print(nombre);%>">    
    <br>
    <br>
    <%

    %>
    <table> 
        <tr>
            <th>Remitente: </th>
            <th>Destinatario: </th>
            <th>Texto: </th>
            <th>Leido: </th>
            <th>Eliminar Mensaje:</th>
        </tr>

        <%                for (Mensaje mensaje : lM) {
        %><tr>
            <td><%
                out.print(mensaje.getRemitente());
                %>  </td><%%>
            <td><%
                out.print(mensaje.getDestinatario());
                %>  </td><%
            %><td><%                  out.print(mensaje.getMensaje());
                %>  </td><%
                %><%
                %><form method="post" action="mensajeria">
            <%                        boolean x = false; %>
            <td> <input type="checkbox" name="leido" onclick="<% out.print(x = true); %>" value="<% out.print(mensaje.getId());%>"/></td>
                  <td> <input type="checkbox" name="eliminar" onclick="<% out.print(x = true); %>" value="<% out.print(mensaje.getId());%>"/></td>
            <input type="hidden" name="option" value="asignValor">       
            </tr><%            }
            %><input type="submit"></form><%

            %>


    </table> 

    <%            break;

        case 'b':
    %>  <h1>Ver mensajes nuevos</h1>
    <%
            break;

        case 'c':
    %>  <h1>Escribir mensaje</h1>
    <table>
        <form method="post" action="mensajeria"> 
            <input type="hidden" name="option" value="envMensaje">   
            <%
                nombre = ((String) session.getAttribute("nombre"));
            %>
            <tr>
                <td>
                    <h1>Remitente : <% out.print(nombre);  %></h1>
                    <input type="hidden" name="rem" value="<%out.print(nombre);%>">

                </td>  
            </tr>
            <td>
                <textarea name="mensaje" rows="5" cols="100" placeholder="Esto es el campo para escribir el cuerpo del mensaje"></textarea>
            </td>
            <br>
            <br>
            <br>
            <br>
            <tr> 
                <td>
                    Destinatario :  
                    <select name="dest"> 
                        <% ArrayList<Usuario> lU1 = (ArrayList<Usuario>) session.getAttribute("userList");
                            for (Usuario usuario : lU1) {
                        %><option value="<%out.print(usuario.getNombre());%>"><%out.print(usuario.getNombre());%></option><%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <br>
            <br>
            <tr>
                <td>
                    <input type="submit" value="Enviar mensaje">
                </td>
            </tr>
        </form>
    </table>
    <%
            break;

        case 'd':
    %><h1>CHANA</h1><%
                break;

            case 'e':
    %><h1>ASIGNAR VALORES PRUEBA</h1><%
                break;
            default:
        }
    %>
</html>
