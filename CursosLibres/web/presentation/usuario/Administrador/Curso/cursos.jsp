
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
                        <%for (Curso c : lista.cursosList()) {
                        String URLeditar = "/CursosLibres/editarCursoShow?idCurso=" + c.getCodigo();
                                String URLeliminar = "/CursosLibres/eliminarCursoShow?idCurso=" + c.getCodigo();
                                String urlVer="/CursosLibres/ListarGrupos?idCurso=" + c.getCodigo();
                        
                        %>
                            <tr>
                                <td><%=c.getNombre()%></td>
                                <td>
                                    <button onclick="location.href='<%=urlVer%>'" class="table-btn">Ver Grupos</button>
                                </td>
                                <td>
                                    <button class="table-btn" onclick="location.href='<%=URLeditar%>'">Editar</button>
                                </td>
                                <td>
                                    <button class="table-btn" onclick="location.href='<%=URLeliminar%>'" >Eliminar</button>
                                </td>
                            </tr>
                        <%}%>
                    <%}%>
                    

                </table>
            </div>
            <div class="volver-btn">
            <button class="table-btn" onclick="location.href='/CursosLibres/agregarCursoShow'">Agregar</button>
            </div>
        </div>
    </body>  
</html>
