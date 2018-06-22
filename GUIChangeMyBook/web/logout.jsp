<%-- 
    Document   : logout
    Created on : 21-jun-2018, 22:25:12
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    HttpSession sesion = request.getSession();
    if(sesion.getAttribute("username") != null) {
        sesion.removeAttribute("username");
        response.sendRedirect("index.jsp");
    } else {
        response.sendRedirect("index.jsp");
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
