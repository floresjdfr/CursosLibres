

<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>

<%
    Service lista = (Service) request.getAttribute("listaCursos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>CursosLibres</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/my-styles.css">
        <link rel="stylesheet" href="fonts/ionicons.min.css">
        <link rel="stylesheet" href="css/Login-Form-Dark.css">
    </head>
    <body>
        <%@ include file="header.jsp" %>

    <div class="main-container">
        <div class="table-container">
            <table>
                <tr>
                  <th>Curso</th>
                  <th>Precio</th>
                  <th></th>
                </tr>
                <% if (lista.cursosList() != null) {%>
                <%for (Curso c : lista.cursosList()) {%>
                <tr>
                    <td><%=c.getNombre()%></td>
                    <td><%=c.getCosto()%></td>
                    
                    <td><button class="table-btn" onclick="location.href='presentation/misc/Grupos.jsp'">Ver</button></td>
                </tr>
                <%}%>
                <%}%>
              </table>
        </div>
    </div>                               


        <script src="js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
