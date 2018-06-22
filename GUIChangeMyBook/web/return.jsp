<%-- 
    Document   : return
    Created on : 22-jun-2018, 10:44:06
    Author     : Wero
--%>

<%@page import="java.util.Date"%>
<%@page import="java.rmi.Naming"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.models.Usuario"%>
<%@page import="rmiserverbook.PublicacionInterface"%>
<%@page import="rmiserverbook.UsuarioInterface"%>
<%@page import="db.models.Compra"%>
<%@page import="rmiserverbook.CompraInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            if(sesion.getAttribute("username") != null) {
                
                if (request.getParameter("id") != null) {
                    int id = Integer.parseInt((String)request.getParameter("id"));
                    CompraInterface compra;
                    compra = (CompraInterface)Naming.lookup("rmi://localhost/Compra");
                    Compra data = compra.readCompraById(id);

                    if(data == null) {
                        response.sendRedirect("foros.jsp");
                    } else {
                        
                        PublicacionInterface pub;
                        pub = (PublicacionInterface)Naming.lookup("rmi://localhost/Publicacion");
                        int res = pub.updateEstado_P(data.getPublicacion().getId_Pub(), 0);
                        
                        UsuarioInterface user;
                        user = (UsuarioInterface)Naming.lookup("rmi://localhost/Usuario");
                        Usuario info = user.readUsuarioByUsername((String)sesion.getAttribute("username"));
                        
                        user.updateDinero(info.getId_U(), (data.getPublicacion().getPrecio() + info.getCreditos()));
                        
                        compra.removeCompra(id);
                        
                        if(res == 1) {
                            response.sendRedirect("index.jsp");
                        } else {
                            response.sendRedirect("register.jsp");
                        }
                    }

                } else {
                    response.sendRedirect("index.jsp");
                }
                
            } else {
                response.sendRedirect("login.jsp");
            }
            

        %>
    </body>
</html>
