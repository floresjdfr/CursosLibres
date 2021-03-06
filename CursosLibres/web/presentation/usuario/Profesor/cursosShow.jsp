<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logic.curso.Service"%>
<%@page import="logic.curso.Curso" %>
<!DOCTYPE html>
<html>

    <%
        Service listaCursos = (Service) request.getAttribute("listaCursos");
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


                    <%
                        if (listaCursos != null) {
                            for (Curso c : listaCursos.cursosList()) {
                                String nombre = c.getNombre();
                                int codigo = c.getCodigo();
                                String urlVerGrupos = "/CursosLibres/Profesor/GruposShow?idCurso=" + codigo;
                    %>
                    <tr>
                        <td><%=nombre%></td>
                        <td>
                            <button onclick="location.href = '<%=urlVerGrupos%>'" class="table-btn">Ver Grupos</button>
                        </td>
                    </tr>
                    <%
                            }
                        }

                    %>






                </table>
            </div>
        </div>
    </body>
</html>
