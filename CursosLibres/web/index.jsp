<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>

<%
    Service lista = (Service) request.getAttribute("listaCursos");
    String nombreCurso = (String) request.getAttribute("nombreCurso");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>CursosLibres</title>
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/my-styles.css">
    </head>
    <body>      

        <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
        <div class="main-container">
            <%@ include file="header.jsp" %>
            <%
                String URL = "/CursosLibres/GruposMatricularShow?idCurso=";
            %>

            <div class="busqueda-wrapper">
                <form class="search_box" action="/CursosLibres/BuscarCursoAction" method="POST">
                    <button type="submit"class="search_btn"><i class="fas fa-search"></i></button>
                        <%
                            if (nombreCurso != null) {%>
                    <input name="nombreCurso" type="text" class="input_search" placeholder=<%=nombreCurso%>>
                    <%} else {%>
                    <input name="nombreCurso" type="text" class="input_search" placeholder="Buscar curso...">
                    <%}
                    %>
                </form>
            </div> 
            <div class="table-container">
                <table>
                    
                     <tr class = "titulo-tabla">
                         <th colspan="5"><h1>Cursos en oferta</h1></th>
                    </tr>
                    <tr class = "titulo-tabla">
                        <th></th>
                        <th>Curso</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>


                    <% if (lista.cursosList() != null) {%>
                    <%for (Curso c : lista.cursosList()) {%>
                    <tr>

                    <form  class="formulario-container" method="POST" action=<%=URL%><%=c.getCodigo()%>>
                        <td> <img src='/CursosLibres/image?nombre=<%=c.getNombre()%>' width="60" height="60"> </td> 
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getCosto()%></td>


                        <td><button type="submit" class="table-btn">Ver/Matricular</button></td>
                        </tr>
                        <%}%>
                        <%}%>

                        <%-- <% if (lista.cursosList() != null) {%>
                         <%for (Curso c : lista.cursosList()) {%>
                         <tr>
                             <td> <img src='/CursosLibres/image?nombre=<%=c.getNombre()%>' width="50" height="50"> </td>
                             <td><%=c.getNombre()%></td>
                             <td><%=c.getCosto()%></td>

                        <td><button class="table-btn" onclick="location.href = 'presentation/misc/Grupos.jsp'">Ver</button></td>
                    </tr>
                    <%}%>
                    <%}%>--%>
                </table>
            </div>
        </div>
    </body>
</html>

