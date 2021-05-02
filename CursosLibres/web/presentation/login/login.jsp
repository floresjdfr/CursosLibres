<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="logic.usuario.Model"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="html-login">

    <% Model model = (Model) request.getAttribute("model"); %>
    <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
    <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Login</title>
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/login.css">

    </head>
    <body>


        <%@ include file="/header.jsp" %>

        <div class="wrapper">
            <div class="title">
                Bienvenido</div>
            <form action="/CursosLibres/Login" method="post">
                <div class="field">
                    <input class="<%=erroneo("usernameText", errores)%>" type="text" name="usernameText" 
                           value="<%=form.get("usernameText")[0]%>" title="<%=title("usernameText", errores)%>" required>
                    <label>Cedula del usuario</label>
                </div>
                <div class="field">
                    <input class="<%=erroneo("passwordText", errores)%>" type="password" name="passwordText" 
                           value="<%=form.get("passwordText")[0]%>" title="<%=title("passwordText", errores)%>"required>
                    <label>Clave del usuario</label>
                </div>
                <div class="content">


                </div>
                <div class="field">
                    <input type="submit" value="Login">
                </div>
                <div class="signup-link">
                    <a href="/CursosLibres/presentation/login/registrar.jsp">Registrarse</a></div>
            </form>
        </div>
    </body>>

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



