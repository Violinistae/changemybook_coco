<%-- 
    Document   : login
    Created on : 19-jun-2018, 21:24:27
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="Assets/imgs/tab.png"/>
    </head>
    <body>
        <div class="container">
            <h1 class="center">Iniciar Sesión</h1>
            <div class="row">
                <div class="col s4"></div>
                <form class="col s4" action="Login">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="username" name="username" type="text" class="validate">
                            <label for="username">Nombre de Usuario</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="password" name="password" type="password" class="validate">
                            <label for="password">Contraseña</label>
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
