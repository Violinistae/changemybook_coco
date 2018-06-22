<%-- 
    Document   : details
    Created on : 22-jun-2018, 6:01:51
    Author     : Wero
--%>

<%@page import="db.models.Compra"%>
<%@page import="rmiserverbook.CompraInterface"%>
<%@page import="db.models.Usuario"%>
<%@page import="rmiserverbook.UsuarioInterface"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.rmi.Naming"%>
<%@page import="db.models.Publicacion"%>
<%@page import="db.models.Publicacion"%>
<%@page import="rmiserverbook.PublicacionInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicación a Detalle</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="/Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="Assets/imgs/tab.png"/>
    </head>
    <body>
        <div class="container">
        <%  
            if(sesion.getAttribute("username") != null) {
                UsuarioInterface user;
                user = (UsuarioInterface)Naming.lookup("rmi://localhost/Usuario");
                Usuario data = user.readUsuarioByUsername((String)sesion.getAttribute("username"));
                out.print("<h5 class='right'>Créditos: " + data.getCreditos() + "</h5>");
            }
        %>
        <h1>Publicación a detalle</h1>
        <%
            
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt((String)request.getParameter("id"));
                PublicacionInterface controller;
                controller = (PublicacionInterface)Naming.lookup("rmi://localhost/Publicacion");
                Publicacion publicacion = controller.readPublicacionById(id);
                
                CompraInterface compra;
                compra = (CompraInterface)Naming.lookup("rmi://localhost/Compra");
                Compra info = compra.readCompraByPublicacion(id);
                
                out.print("<div class='col s4'>");
                    out.print("<div class='card'>");
                        out.print("<div class='card-content'>");
                            out.print("<p>"+publicacion.getTexto()+"</p>");
                            out.print("<p>Precio: $ "+publicacion.getPrecio()+"</p>");
                        out.print("</div>");
                        out.print("<div class='card-action'>");
                            if(sesion.getAttribute("username") != null) {
                                
                                if(publicacion.getEstadoP() == 1) {
                                    if(!publicacion.getPublicador().getUsername().equals(sesion.getAttribute("username"))) {
                                        if(info.getComprador().getUsername().equals(sesion.getAttribute("username"))) {
                                            out.print("<a href='return.jsp?id="+info.getId_Compra()+"'>Devolver</a>");
                                        } else {
                                            out.print("<h6>Esta publicación ya fue comprada por otro usuario</h6>");
                                        }
                                    } 
                                } else if (!publicacion.getPublicador().getUsername().equals(sesion.getAttribute("username")) && publicacion.getEstadoP() == 0) {
                                    out.print("<a href='buy.jsp?id="+publicacion.getId_Pub()+"'>Comprar</a>");
                                } else {
                                    out.print("<h6>No puedes comprar tu publicación</h6>");
                                }
                            } else {
                                out.print("<h6>Necesitas registrarte o iniciar sesión</h6>");
                            }
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
        </div>
    </body>
</html>
