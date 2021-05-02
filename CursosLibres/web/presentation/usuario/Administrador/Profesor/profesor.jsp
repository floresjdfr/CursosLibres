<%@page import="logic.usuario.profesor.Profesor"%>
<%@page import="logic.usuario.profesor.Service"%>

<%
   Service lista = (Service) request.getAttribute("listaProfesores");
   String nombreProfe = (String) request.getAttribute("nombreProfe");
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
        <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
      <div class="main-container">
         <%@ include file="/header.jsp" %>
        
         <div class="busqueda-wrapper">
                <form class="search_box" action="/CursosLibres/BuscarProfeAction" method="POST">
                    <button type="submit"class="search_btn"><i class="fas fa-search"></i></button>
                        <%
                            if (nombreProfe != null) {%>
                    <input name="nombreProfe" type="text" class="input_search" placeholder=<%=nombreProfe%>>
                    <%} else {%>
                    <input name="nombreProfe" type="text" class="input_search" placeholder="Buscar Profesor...">
                    <%}
                    %>
                </form>
            </div>
         
         
         

         <div class="table-container">

                <table>
                    <tr>
                        <th>Profesores</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    <% if (lista.profesoresList() != null) {
                            for (Profesor c : lista.profesoresList()) {
                                String URLeditar = "/CursosLibres/editarProfeShow?idProfesor=" + c.getCedula();
                                String URLeliminar = "/CursosLibres/eliminarProfeShow?idProfesor=" + c.getCedula();
                                String URLver="/CursosLibres/verProfeShow?idProfesor=" + c.getCedula();
                    %>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td>
                            <button type="button" onclick="location.href = '<%=URLver%>'" class="table-btn">Ver informacion</button>
                        </td>
                        <td>

                     <button type="button" class="table-btn" onclick="location.href = '<%=URLeditar%>'">Editar</button>
                  </td>
                  <td>
                     <button type="button" class="table-btn" onclick="location.href = '<%=URLeliminar%>'" >Eliminar</button>
                  </td>
               </tr>
               <%}%>
               <%}%>


            </table>

         </div>
               
         <div class="volver-btn">
            <button class="table-btn" onclick="location.href = '/CursosLibres/agregarProfesorShow'">Agregar</button>
         </div>
      </div>
   </body>  
</html>
