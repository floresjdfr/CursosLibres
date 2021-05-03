<%@page import="logic.grupo.Service"%>
<%@page import="logic.grupo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Service listaCursos = (Service) request.getAttribute("listaGrupos");
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Administrador</title>
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="table-container">
                <table>
                    <tr class="titulo-tabla">
                        <th>Grupos</th>
                        <th>Horario</th>
                        <th></th>
                    </tr>

                    <%
                        if (listaCursos != null) {
                            for (Grupo g : listaCursos.gruposList()) {
                                int idGrupo = g.getCodigo();
                                String URL = "/CursosLibres/Profesor/EstudiantesShow?idGrupo=" + idGrupo;
                                int codigo = g.getCodigo();
                                String horario = g.getFecha();
                    %>
                    <tr>
                        <td>Grupo <%=codigo%></td>
                        <td>Grupo <%=horario%></td>
                        <td>
                            <button onclick="location.href = '<%=URL%>'" class="table-btn">Ver estudiantes</button>
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
