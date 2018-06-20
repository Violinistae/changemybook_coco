<%-- 
    Document   : login
    Created on : 19-jun-2018, 21:24:27
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="../Assets/css/materialize.css" rel="stylesheet"/>
        <link href="./Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="../Assets/js/jquery.min.js"></script>
        <script src="../Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="../Assets/imgs/tab.png"/>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper">
                <a href="../index.jsp" class="brand-logo">Inicio</a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="login.jsp"><i class="material-icons left">input</i>Ingresar</a></li>
                    <li><a href="register.jsp"><i class="material-icons left">add_box</i>Registrarse</a></li>                   
                </ul>
            </div>
        </nav>
        <div class="container">
            <h1 class="center">Iniciar Sesión</h1>
            <div class="row">
                <div class="col s4"></div>
                <form class="col s4">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="username" type="text" class="validate">
                            <label for="username">Nombre de Usuario</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate">
                            <label for="password">Contraseña</label>
                        </div>
                        <div class="col s12 right-align">
                            <a class="waves-effect waves-light btn blue"><i class="material-icons right">arrow_right</i>Continuar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
