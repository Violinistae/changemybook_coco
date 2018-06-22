<%-- 
    Document   : Foro
    Created on : 22/06/2018, 10:50:09 AM
    Author     : usuario
--%>

<%@page import="java.rmi.Naming"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.models.Foro"%>
<%@page import="rmiserverbook.ForoInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foros</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Foros</h1>
            <%
                ForoInterface controller;
                controller = (ForoInterface)Naming.lookup("rmi://localhost/Foro");
                ArrayList<Foro> foros = controller.readForo();
                for(Foro foro : foros) {

                    out.print("<div class='col s4'>");
                        out.print("<div class='card'>");
                            out.print("<div class='card-content'>");
                                out.print("<p>"+foro.getMensaje()+"</p>");
                            out.print("</div>");
                            out.print("<div class='card-action'>");
                                out.print("<a href='ResForo.jsp?id="+foro.getId_Mens()+"'>Ver a detalle</a>");
                            out.print("</div>");
                        out.print("</div>");
                    out.print("</div>");
                }
            %>
        </div>
    </body>
</html>
