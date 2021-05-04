
<%@page import="logic.curso.CursoActual"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        ArrayList<CursoActual> listaCursos = (ArrayList<CursoActual>) request.getAttribute("listaCursos");
        session.setAttribute("listaCursos", listaCursos);
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Actuales</title>
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="table-container">
                <table>
                    <tr class="titulo-tabla">
                        <th>Cursos actuales</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr class="titulo-tabla">
                        <td>Nombre del curso</td>
                        <td>Nombre del profesor</td>
                        <td>Horario</td>
                        <td>Nota</td>
                    </tr>
                    <%
                        for (CursoActual c : listaCursos) {%>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getNombreProfesor()%> <%=c.getApellidoProfesor()%></td>
                        <td><%=c.getHorario()%></td>
                        <td><%=c.getNota()%></td>
                    </tr>
                    
                    <%
                        }
                    %>

                </table>
            </div>
                    <div class="volver-btn">
            <button class="table-btn" onclick="location.href='/CursosLibres/ImprimirHistorialAction'">Imprimir Historial</button>
            </div>
        </div>
    </body>  
</html>
