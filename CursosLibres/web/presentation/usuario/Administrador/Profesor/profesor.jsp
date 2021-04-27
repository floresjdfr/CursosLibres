<%//@page import="logic.usuario.profesor.Profesor"%>
<%//@page import="logic.profesor.Service"%>

<%
    //Service lista = (Service) request.getAttribute("listaProfesores");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Administrar Profesores</title>
        <link rel="stylesheet" href="/CursosLibres/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="table-container">
                <table>
                    <tr>
                        <th>Profesores</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>Jose Sanchez</td>
                        <td>
                            <button onclick="location.href = 'ver_profesor.jsp'" class="table-btn">Ver informacion</button>
                        </td>
                        <td>
                            <button class="table-btn" onclick="location.href = 'editar_profesor.jsp'">Editar</button>
                        </td>
                        <td>
                            <button class="table-btn" onclick="location.href = 'borrar_profesor.jsp'" >Eliminar</button>
                        </td>
                    </tr>
                    <%// if (lista.cursosList() != null) {%>
                    <%//for (Profesor c : listaProfesores.profesoresList()) {%>
                    <tr>
                        <td><%//=c.getNombre()%></td>
                        <td>
                            <button onclick="location.href = 'ver_profesor.jsp'" class="table-btn">Ver informacion</button>
                        </td>
                        <td>
                            <button class="table-btn" onclick="location.href = 'editar_profesor.jsp'">Editar</button>
                        </td>
                        <td>
                            <button class="table-btn" onclick="location.href = 'borrar_profesor.jsp'" >Eliminar</button>
                        </td>
                    </tr>
                    <%//}%>
                    <%//}%>


                </table>
            </div>
            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/agregar_curso.jsp'">Agregar</button>
            </div>
        </div>
    </body>  
</html>
