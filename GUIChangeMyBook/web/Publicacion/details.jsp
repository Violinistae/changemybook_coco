<%-- 
    Document   : details
    Created on : 22-jun-2018, 6:01:51
    Author     : Wero
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.rmi.Naming"%>
<%@page import="db.models.Publicacion"%>
<%@page import="db.models.Publicacion"%>
<%@page import="rmiserverbook.PublicacionInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicación a Detalle</title>
        <link href="../Assets/css/materialize.css" rel="stylesheet"/>
        <link href="../Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="../Assets/js/jquery.min.js"></script>
        <script src="../Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="../Assets/imgs/tab.png"/>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper">
                <a href="./../index.jsp" class="brand-logo">Inicio</a>
                <ul class="right hide-on-med-and-down">
                    <%
                        HttpSession sesion = request.getSession();
                        if(sesion.getAttribute("username") == null) {
                            out.print("<li><a href='./User/login.jsp'><i class='material-icons left'>input</i>Ingresar</a></li>");
                            out.print("<li><a href='./User/register.jsp'><i class='material-icons left'>add_box</i>Registrarse</a></li>");
                        } else {
                            out.print("<li><a href='./User/logout.jsp'><i class='material-icons left'>chevron_left</i>Salir</a></li>");
                        }

                    %>
                </ul>
            </div>
        </nav>
        <div class="container">
        <%  
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt((String)request.getParameter("id"));
                PublicacionInterface controller;
                controller = (PublicacionInterface)Naming.lookup("rmi://localhost/Publicacion");
                Publicacion publicacion = controller.readPublicacionById(id);
                out.print("<div class='col s4'>");
                    out.print("<div class='card'>");
                        out.print("<div class='card-image'>");
                            out.print("<img src='../Assets/imgs/"+publicacion.getFoto()+"'/>");
                        out.print("</div>");
                        out.print("<div class='card-content'>");
                            out.print("<p>"+publicacion.getTexto()+"</p>");
                        out.print("</div>");
                        out.print("<div class='card-action'>");
                            out.print("<a href='details.jsp?id="+publicacion.getId_Pub()+"'>Ver a detalle</a>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
            } else {
                response.sendRedirect("./index.jsp");
            }
        %>
        </div>
    </body>
</html>
