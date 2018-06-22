<%-- 
    Document   : index
    Created on : 19-jun-2018, 21:21:08
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <nav>
            <div class="nav-wrapper">
                <a href="./index.jsp" class="brand-logo">Inicio</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="./User/login.jsp"><i class="material-icons left">input</i>Ingresar</a></li>
                    <li><a href="./User/register.jsp"><i class="material-icons left">add_box</i>Registrarse</a></li>                   
                </ul>
            </div>
        </nav>
        <div class="container">
            <h1>Index</h1>
            ${sessionScope.username}
        </div>
    </body>
</html>
