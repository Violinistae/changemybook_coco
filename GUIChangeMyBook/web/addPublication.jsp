<%-- 
    Document   : addPublication
    Created on : 22-jun-2018, 11:17:32
    Author     : Wero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Publicación</title>
        <link href="Assets/css/materialize.css" rel="stylesheet"/>
        <link href="/Assets/css/styles.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <script src="Assets/js/jquery.min.js"></script>
        <script src="Assets/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="Assets/imgs/tab.png"/>
    </head>
    <body>
        <div class="container">
            <h1 class="center">Agregar Publicación</h1>
            <div class="row">
                <div class="col s4"></div>
                <form class="col s4" action="AddPublication">
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="text" name="text" type="text" class="validate">
                            <label for="text">Texto</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="price" name="price" type="number" class="validate">
                            <label for="price">Precio</label>
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
