<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Service lista = (Service) request.getAttribute("listaCursos");
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Administrador</title>
        <link rel="stylesheet" href="/CursosLibres/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="table-container">
                <table>
                    <tr class="titulo-tabla">
                        <th>Cursos</th>
                        <th></th>
                    </tr>
                    
                    <% if (lista.cursosList() != null) {%>
                    <%for (Curso c : lista.cursosList()) {
                            String urlVer = "/CursosLibres/GruposMatricularShow?idCurso=" + c.getCodigo();
                    %>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td>
                            <button onclick="location.href = '<%=urlVer%>'" class="table-btn">Matricular</button>
                        </td>
                    </tr>
                    <%}%>
                    <%}%>

                </table>
            </div>
        </div>
    </body>  
</html>
