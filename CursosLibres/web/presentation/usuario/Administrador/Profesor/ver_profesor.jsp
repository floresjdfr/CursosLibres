

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
     <%
        Profesor profesor = (Profesor) request.getAttribute("Profemostrar");
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
                            <td class="curso-derecha"><%=nombre%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Primer Apellido:</td>
                            <td class="curso-derecha"><%=apellido1%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Segundo Apellisod:</td>
                            <td class="curso-derecha"><%=apellido2%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Cedula:</td>
                            <td class="curso-derecha"><%=cedulaString%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha"><%=correo%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Telefono:</td>
                            <td class="curso-derecha"><%=telefono%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Especialidad:</td>
                            <td class="curso-derecha"><%=especialidad%></td>
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
