<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pro.presentation.login.Model"%>
<%@page import="pro.logic.usuario.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Usuario</title>
    </head>
    <body>
        <%Model modelo = (Model)request.getAttribute("model");%>
        <%Usuario usr = modelo.getUsuario();%>
        
        <%@include file="/header.jsp"%>

        <p>Cedula <%=usr.getCedula()%></p>
        <p>Nombre: <%=usr.getNombre()%></p>
        <p>Password: <%=usr.getPassword()%></p>
        <%@include file="/footer.jsp"%>        
    </body>
</html>

