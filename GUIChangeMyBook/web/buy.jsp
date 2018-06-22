<%-- 
    Document   : buy
    Created on : 22-jun-2018, 9:52:43
    Author     : Wero
--%>

<%@page import="rmiserverbook.PublicacionInterface"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="db.models.Usuario"%>
<%@page import="db.models.Publicacion"%>
<%@page import="rmiserverbook.UsuarioInterface"%>
<%@page import="db.models.Compra"%>
<%@page import="java.rmi.Naming"%>
<%@page import="rmiserverbook.CompraInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="navbar.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar producto</title>
    </head>
    <body>
        <%
            
            if(sesion.getAttribute("username") != null) {
                
                if (request.getParameter("id") != null) {
                    int id = Integer.parseInt((String)request.getParameter("id"));
                    CompraInterface compra;
                    compra = (CompraInterface)Naming.lookup("rmi://localhost/Compra");
                    Compra data = compra.readCompraByPublicacion(id);

                    if(data != null) {
                        response.sendRedirect("index.jsp");
                    } else {
                        UsuarioInterface user;
                        user = (UsuarioInterface)Naming.lookup("rmi://localhost/Usuario");
                        Usuario info = user.readUsuarioByUsername((String)sesion.getAttribute("username"));
                        
                        PublicacionInterface pub;
                        pub = (PublicacionInterface)Naming.lookup("rmi://localhost/Publicacion");
                        Publicacion infopub = pub.readPublicacionById(id);
                        
                        if(info.getCreditos() >= infopub.getPrecio()) {
                            user.updateDinero(info.getId_U(), (info.getCreditos() - infopub.getPrecio()));
                            pub.updateEstado_P(id, 1);
                            compra.createCompra(info.getId_U(), id, new Date());
                            response.sendRedirect("index.jsp");                       
                        } else {
                            response.sendRedirect("details.jsp?id="+Integer.toString(id));                       
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
