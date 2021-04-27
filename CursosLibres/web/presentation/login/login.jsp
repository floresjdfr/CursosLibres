

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Login</title>
        <link rel="stylesheet" href="/CursosLibres/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/CursosLibres/fonts/ionicons.min.css">
        <link rel="stylesheet" href="/CursosLibres/css/Login-Form-Dark.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>
    <body class="main-container-simple"">
        <%@ include file="/header.jsp" %>
        <section class="login-dark" style="height: 800px;">
            <form name="form" action="/CursosLibres/Login" method="post">
                <h2 class="sr-only">Login Form</h2>
                <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
                <div class="form-group"><input class="form-control" type="number" name="usernameText" placeholder="Cedula"></div>
                <div class="form-group"><input class="form-control" type="password" name="passwordText" placeholder="Password"></div>
                <div class="form-group"> <a href="/CursosLibres/presentation/login/registrar.jsp" >Registrar</a> </div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Log In</button></div>
            </form>
        </section>
        <script src="/CursosLibres/js/jquery.min.js"></script>
        <script src="/CursosLibres/bootstrap/js/bootstrap.min.js"></script>

    </body>

    
</html>
