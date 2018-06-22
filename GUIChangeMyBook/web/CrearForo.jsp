<%-- 
    Document   : CrearForo
    Created on : 22/06/2018, 10:50:24 AM
    Author     : usuario
--%>

<%@page import="java.rmi.Naming"%>
<%@page import="rmiserverbook.UsuarioInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear foro</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
    </head>
    <body>
        <h1 class="center">Crear Foro</h1>
        <div class="row">
            <div class="col s4"></div>
            <form class="col s4" action="AddForo">
                <div class="row">
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
    </body>
</html>
