<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="logic.usuario.Model"%>


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
            
            <% Model model = (Model) request.getAttribute("model"); %>
            <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
            <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>


            
            
            
            <form name="form" action="/CursosLibres/Login" method="post">
                <h2 class="sr-only">Login Form</h2>
                <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
                
                
                <%--<div class="form-group"><input class="form-control" type="number" name="usernameText" placeholder="Cedula"></div>
                <div class="form-group"><input class="form-control" type="password" name="passwordText" placeholder="Password"></div>--%>
                
                <div class="form-group"><input class="<%=erroneo("usernameText", errores)%>" placeholder="Cedula del usuario" type="text" name="usernameText" value="<%=form.get("usernameText")[0]%>" title="<%=title("usernameText", errores)%>"></div>
                <div class="form-group"><input class="<%=erroneo("passwordText", errores)%>" placeholder="Clave del usuario" type="password" name="passwordText" value="<%=form.get("passwordText")[0]%>" title="<%=title("passwordText", errores)%>"></div>

                
                <div class="form-group"> <a href="/CursosLibres/presentation/login/registrar.jsp" >Registrar</a> </div>
                <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Log In</button></div>
            </form>
        </section>
        <script src="/CursosLibres/js/jquery.min.js"></script>
        <script src="/CursosLibres/bootstrap/js/bootstrap.min.js"></script>

    </body>

    
</html>


<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<>();

        String aux = Integer.toString(model.getUsr().getCedula());
        if (!aux.equals(0)) {

            values.put("usernameText", new String[]{""});
            values.put("passwordText", new String[]{""});
        } else {
            values.put("usernameText", new String[]{aux});
            values.put("passwordText", new String[]{model.getUsr().getPassword()});

        }
        return values;
    }

%> 



