

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
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/my-styles.css">
        <link rel="stylesheet" href="fonts/ionicons.min.css">
        <link rel="stylesheet" href="css/Login-Form-Dark.css">
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
                    <tr>
                        <th>Imagen curso</th>
                        <th>Curso</th>
                        <th>Oferta</th>
                        <th colspan="3">Precio</th>
                    </tr>


                    <% if (lista.cursosList() != null) {%>
                    <%for (Curso c : lista.cursosList()) {%>
                    <tr>

                    <form  class="formulario-container" method="POST" action=<%=URL%><%=c.getCodigo()%>>
                        <td> <img src='/CursosLibres/image?nombre=<%=c.getNombre()%>' width="100" height="100"> </td> 
                        <td><%=c.getNombre()%></td>
                        <td> <%= ofert(c.getOferta())%> </td>
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


        <script src="js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>


<%!
    public String ofert(int x) {
        if (x == 1) {
            return "Si";
        } else {
            return "No";
        }

    }


%>