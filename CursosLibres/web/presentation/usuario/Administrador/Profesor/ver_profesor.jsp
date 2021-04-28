<%-- 
    Document   : ver_informacion
    Created on : Apr 26, 2021, 10:41:11 PM
    Author     : josedf
--%>
<%@page import="logic.usuario.profesor.Profesor" %>" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
   <%
      Profesor profesor = (Profesor) request.getAttribute("profesor");
   %>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
      <title>Ver Profesor</title>
   </head>

   <body>
      <div class="main-container">
         <%@include file="/header.jsp"%>

         <div class="curso-container">
            <div class = "tabla-info-cursos">
               <table>
                  <tr>
                     <td class="curso-izquierda">Nombre:</td>
                     <td class="curso-derecha"><%=profesor.getNombre()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Primer apellido</td>
                     <td class="curso-derecha"><%=profesor.getApellido1()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Segundo apellido:</td>
                     <td class="curso-derecha"><%=profesor.getApellido2()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Cedula:</td>
                     <td class="curso-derecha"><%=profesor.getCedula()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Correo:</td>
                     <td class="curso-derecha"><%=profesor.getCorreo()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Telefono:</td>
                     <td class="curso-derecha"><%=profesor.getNumero()%></td>
                  </tr>
                  <tr>
                     <td class="curso-izquierda">Especialidad:</td>
                     <td class="curso-derecha"><%=profesor.getEspecialidad()%></td>
                  </tr>
               </table>
            </div>
         </div>
         <div class="volver-btn">
            <button class="table-btn" onclick="location.href = '/CursosLibres/mostrarProfesor'">Volver</button>
         </div>

      </div>





   </body>
</html>
