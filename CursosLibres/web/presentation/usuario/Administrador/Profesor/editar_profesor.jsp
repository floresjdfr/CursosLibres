<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Profesor profesor = (Profesor) request.getAttribute("profesor_editar");
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
        <title>Editar Profresor</title>
    </head>

    <body>



        <div class="main-container">
            <%@include file="/header.jsp" %>

            <%
                String URL = "/CursosLibres/editarProfeAction?cedula=" + cedulaString;
            %>
            <form method="POST" action=<%=URL%> class="formulario-container">
                <div class = "formulario-form">
                    <table>

                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">

                                <input class = "curso-derecha" name="nombre" type="text" value=<%=nombre%>>
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Primer apellido:</td>
                            <td class="curso-derecha">

                                <input class = "curso-derecha" name="apellido1" type="text" value=<%=apellido1%>>
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Segundo apellido:</td>

                            <%
                                if (apellido2 != null) {%>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="apellido2" type="text" value=<%=apellido2%>>
                            </td>
                            <%    } else{ %>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="apellido2" type="text">
                            </td>
                            <%}
                            %>


                        </tr>


                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="correo" type="text" value=<%=correo%>>
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Telefono:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="telefono" type="text" value=<%=telefono%>>
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Especialidad</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="especialidad" type="text" value=<%=especialidad%>>
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Password:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="password" type="text" value=<%=password%>>
                            </td>
                        </tr>
                    </table>

                </div>

                <div class="formulario-buttons">
                    <button type="submit" class="table-btn formulario-btn1">Guardar</button>
                    <button type="button" class="table-btn formulario-btn2" onclick="location.href = '/CursosLibres/mostrarProfesor'">Volver</button>
                </div>


            </form>



        </div>
    </body>
</html>
