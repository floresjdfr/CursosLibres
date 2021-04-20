<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logic.usuario.Usuario"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Usuario</title>
    </head>
    <body>
        <%Usuario usr = (Usuario) session.getAttribute("usr"); %>

        <%@include file="/header.jsp"%>

        <p>Cedula <%=usr.getCedula()%> Ver</p>
        <p>Nombre: <%=usr.getNombre()%> Ver</p>
        <p>Password: <%=usr.getPassword()%> Ver</p>
        <%@include file="/footer.jsp"%>        
    </body>
</html>

