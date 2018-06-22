<%-- 
    Document   : navbar
    Created on : 22-jun-2018, 9:00:44
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    HttpSession sesion = request.getSession();

%>
<!DOCTYPE html>
<html>
    <body>
        <nav>
            <div class="nav-wrapper">
                <a href="./index.jsp" class="brand-logo">Inicio</a>
                <ul class="right hide-on-med-and-down">
                    <%
                        out.print("<li><a href='Foro.jsp'><i class='material-icons left'>list</i>Foros</a></li>");
                        if(sesion.getAttribute("username") == null) {
                            out.print("<li><a href='login.jsp'><i class='material-icons left'>input</i>Ingresar</a></li>");
                            out.print("<li><a href='register.jsp'><i class='material-icons left'>add_box</i>Registrarse</a></li>");
                        } else {
                            out.print("<li><a href='addPublication.jsp'><i class='material-icons left'>add</i>Crear publicación</a></li>");
                            out.print("<li><a href='CrearForo.jsp'><i class='material-icons left'>add</i>Crear foro</a></li>");
                            out.print("<li><a href='logout.jsp'><i class='material-icons left'>chevron_left</i>Salir</a></li>");
                        }
                    %>
                </ul>
            </div>
        </nav>
    </body>
</html>
