<%-- 
    Document   : index
    Created on : 19-jun-2018, 21:21:08
    Author     : Wero
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="rmiserverbook.PublicacionInterface"%>
<%@page import="db.models.Publicacion"%>
<%@page import="java.rmi.Naming"%>
<%@page import="java.rmi.Naming"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="Assets/imgs/tab.png"/>
    </head>
    <body>
        <div class="container">
            <h1>Lista de publicaciones</h1>
            <div class="row">
            <%
                PublicacionInterface controller;
                controller = (PublicacionInterface)Naming.lookup("rmi://localhost/Publicacion");
                ArrayList<Publicacion> publicaciones = controller.readPublicaciones();
                for(Publicacion publicacion : publicaciones) {
                    
                    out.print("<div class='col s12'>");
                        out.print("<div class='card'>");
                            out.print("<div class='card-content'>");
                                out.print("<p>"+publicacion.getTexto()+"</p>");
                            out.print("</div>");
                            out.print("<div class='card-action'>");
                                out.print("<a href='details.jsp?id="+publicacion.getId_Pub()+"'>Ver a detalle</a>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                    
                }
            %>
            </div>
        </div>
    </body>
</html>
