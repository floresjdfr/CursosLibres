<%@page import="logic.usuario.estudiante.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Service listaEstudiantes = (Service) request.getAttribute("listaEstudiantes");
        String idGrupo = (String) request.getAttribute("idGrupo");
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
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Nota</th>
                        <th></th>
                    </tr>
                    <tr>
                        <%
                            if (listaEstudiantes != null) {
                                for (Estudiante e : listaEstudiantes.estudiantesList()) {

                                    int cedula = e.getCedula();
                                    String nombre = e.getNombre();
                                    nombre = nombre + " " + e.getApellido1();
                                    String nota = e.getNota() != 0 ? String.valueOf(e.getNota()) : "N/A";

                                    String URL = "/CursosLibres/Profesor/CalificarEstudianteShow?idGrupo=";
                                    URL = URL + idGrupo + "&idEstudiante=" + cedula;
                        %>
                        <td><%=cedula%></td>
                        <td><%=nombre%></td>
                        <td><%=nota%></td>
                        <td>
                            <button onclick="location.href = '<%=URL%>'" class="table-btn">Calificar</button>
                        </td>
                        <%
                                }
                            }

                        %>


                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
