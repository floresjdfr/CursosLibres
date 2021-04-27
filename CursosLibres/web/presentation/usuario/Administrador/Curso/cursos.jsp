<%-- 
    Document   : Cursos
    Created on : Apr 25, 2021, 1:55:44 AM
    Author     : josedf
--%>

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
                    <tr>
                        <th>Cursos</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <% if (lista.cursosList() != null) {%>
                        <%for (Curso c : lista.cursosList()) {%>
                            <tr>
                                <td><%=c.getNombre()%></td>
                                <td>
                                    <button onclick="location.href='presentation/misc/Grupos.jsp'" class="table-btn">Ver Grupos</button>
                                </td>
                                <td>
                                    <button class="table-btn" onclick="location.href='/CursosLibres/presentation/usuario/Administrador/Curso/editar_curso.jsp'">Editar</button>
                                </td>
                                <td>
                                    <button class="table-btn" onclick="location.href='/CursosLibres/presentation/usuario/Administrador/Curso/borrar_curso.jsp'" >Eliminar</button>
                                </td>
                            </tr>
                        <%}%>
                    <%}%>
                    

                </table>
            </div>
            <div class="volver-btn">
            <button class="table-btn" onclick="location.href='/CursosLibres/presentation/usuario/Administrador/Curso/agregar_curso.jsp'">Agregar</button>
            </div>
        </div>
    </body>  
</html>
