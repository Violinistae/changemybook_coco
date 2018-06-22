<%-- 
    Document   : ResForo
    Created on : 22/06/2018, 10:50:45 AM
    Author     : usuario
--%>

<%@page import="db.models.Res_Foro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.models.Foro"%>
<%@page import="java.rmi.Naming"%>
<%@page import="rmiserverbook.ForoInterface"%>
<%@page import="rmiserverbook.Res_ForoInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foro en específico</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
    </head>
    <body>
        <div class="container">
        <h1>Foro especifico</h1>
            <%
                
                ForoInterface controller;
                controller = (ForoInterface)Naming.lookup("rmi://localhost/Foro");
                Foro foro = controller.readForoById(Integer.valueOf(request.getParameter("id")));

                out.print("<div class='col s4'>");
                    out.print("<div class='card'>");
                        out.print("<div class='card-content'>");
                            out.print("<p><strong>"+foro.getMensaje()+"</strong></p>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");

                out.print("<div class='col s4'>");
                    out.print("<div class='card'>");
                        out.print("<div class='card-content'>");
                            out.print("<p>Respuestas:</p>");
                        out.print("</div>");
                    out.print("</div>");
                out.print("</div>");
                
                Res_ForoInterface resforo;
                resforo = (Res_ForoInterface)Naming.lookup("rmi://localhost/ResForo");
                System.out.println(request.getParameter("id"));
                ArrayList<Res_Foro> messages = resforo.readRes_ForoByMensaje(Integer.parseInt(request.getParameter("id")));
                
                for(Res_Foro message : messages) {

                    out.print("<div class='col s4'>");
                        out.print("<div class='card'>");
                            out.print("<div class='card-content'>");
                                out.print("<p>"+message.getRemitente().getUsername()+":</p>");
                                out.print("<p>"+message.getRespuestaM()+"</p>");
                            out.print("</div>");                            
                        out.print("</div>");
                    out.print("</div>");
                    
                }
            
            %>       
            <div class="row">
                <form class="col s12" action="AddMessage">
                    <div class="row">
                        <input type="hidden" value="<% out.print(foro.getId_Mens()); %>" name="id_foro" id="id_foro"/>
                        <div class="input-field col s12">
                            <input id="mensaje" name="mensaje" type="text" class="validate">
                            <label for="mensaje">Mensaje</label>
                        </div>
                        <div class="col s12 right-align">
                            <button type="submit" class="waves-effect waves-light btn blue"><i class="material-icons right">arrow_right</i>Continuar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
