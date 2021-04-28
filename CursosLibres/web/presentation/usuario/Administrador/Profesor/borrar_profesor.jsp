

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

   <%
      Profesor profesor = (Profesor) request.getAttribute("profesor_eliminar");
      String nombre = profesor.getNombre();
      String apellido1 = profesor.getApellido1();
      String apellido2 = profesor.getApellido2();
      int cedula = profesor.getCedula();
      String cedulaString = String.valueOf(cedula);
      String correo = profesor.getCorreo();
      String telefono = profesor.getNumero();
      String especialidad = profesor.getEspecialidad();
      String password = profesor.getPassword();
   %>
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
      <title>Eliminar Profesor</title>
   </head>

   <body>
      <div class="main-container">
         <%@include file="/header.jsp"%>

         <div class="curso-container">
            <div class = "tabla-info-cursos">
               <table>
                  <tr>
                     <td class="curso-izquierda">¿Desea eliminar profesor?</td>
                     <td class="curso-derecha"><%=nombre%></td>

                  </tr>
               </table>

            </div>

         </div>

         <div class="volver-btn">
            <button class="table-btn" onclick="location.href = '/CursosLibres/eliminarProfeAction?idProfesor=<%=cedula%>'">Aceptar</button>
         </div>
         <div class="enviar-btn">
            <button class="table-btn" onclick="location.href = '/CursosLibres/mostrarProfesor'">Cancelar</button>
         </div>

      </div>
   </body>
</html>
