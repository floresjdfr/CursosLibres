<%@page import="logic.usuario.Usuario"%>
<%@page import="logic.usuario.estudiante.Estudiante"%>
<html lang="es">


    <%
        Estudiante temp = (Estudiante) session.getAttribute("usr");

        int id = temp.getCedula();
        String nombre = temp.getNombre();
        String apellido1 = temp.getApellido1();
        String apellido2 = temp.getApellido2();
        String correo = temp.getCorreo();
        String telefono = temp.getNumero();
        String dirrecion = temp.getDireccion();
        String password = temp.getPassword();

    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Editar Cuenta</title>
    </head>

    <body>


        <div class="main-container">
            <%@include file="/header.jsp"%>
            <%            String URL = "/CursosLibres/updateEstudiante?idEstudiante=" + id;
            %>

            <form method="POST" action="<%=URL%>" class="formulario-container">
                <div class="formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Telefono:</td>
                            <td class="curso-derecha" class="input-curso">
                                <input class="curso-derecha" name="telefono" type="text" value="<%=telefono%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha " class="input-curso">
                                <input class="curso-derecha" name="correo" type="text" value="<%=correo%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Direccion:</td>
                            <td class="curso-derecha " class="input-curso">
                                <input class="curso-derecha" name="dirrecion" type="text" value="<%=dirrecion%>">
                            </td>
                        </tr>
                        <td class="curso-izquierda">Password:</td>
                        <td class="curso-derecha" class=" input-curso">
                            <input class="curso-derecha" name="password" type="text" value="<%=password%>">
                        </td>
                        </tr>

                    </table>
                </div>

                <div class="formulario-buttons">
                    <button type="submit" class="table-btn formulario-btn1">Actualizar</button>
                    <button type="button" class="table-btn formulario-btn2" onclick="location.href = '/CursosLibres/Cursos'">Volver</button>
                </div>

            </form>



        </div>
    </body>

</html>