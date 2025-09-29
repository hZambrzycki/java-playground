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
         
            table, tr,td {
                padding: auto;
                margin: auto;
                
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
   <%
       char valor = ((Character) session.getAttribute("option"));
       
       switch(valor) {
           case 'a':
   %>  <h1>Ver todos los mensajes</h1>   
         <%ArrayList<Mensaje> lM = (ArrayList<Mensaje>) session.getAttribute("listaMensajes");%>
        <%   String nombre = ((String) session.getAttribute("nombre"));   %> 
 <h1>Bienvenido de nuevo : <% out.println(nombre);%></h1>
 <input type="hidden" name="nombre" value="<%out.println(nombre);%>">                     
 <%        for (Mensaje mensaje : lM) {
     %><h1>        out.println(mensaje.getDestinatario());</h1><%
           out.println(mensaje.getRemitente());
           out.println(mensaje.getMensaje());
 }
  %><%
               break;
               
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
                    <h1>Remitente : <% out.println(nombre);  %></h1>
                    <input type="hidden" name="rem" value="<%out.println(nombre);%>">
                  
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
                %><option value="<%out.println(usuario.getNombre());%>"><%out.println(usuario.getNombre());%></option><%
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
           default:
       }
   %>
</html>
