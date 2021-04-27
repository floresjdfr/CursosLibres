

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Registrar</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>
            <form name="regristro" action="/CursosLibres/signup" method="post">
                <div class="curso-container">
                    <div class = "tabla-info-cursos">

                        <table>
                            <tr>
                                <td class="curso-izquierda">Nombre:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="nombre" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Primer apellido:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="apellido1" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Segundo apellido:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="apellido2" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Cédula:</td>
                                <td class="curso-derecha "> <input class = "curso-derecha" name="idEstudiante" type="number">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Correo:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="correo" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Teléfono:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="telefono" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Direccion:</td>
                                <td class="curso-derecha"> <input class = "curso-derecha" name="direccion" type="text">
                                </td>
                            </tr>
                        </table>


                    </div>

                </div>

                <div class="volver-btn">
                    <button class="table-btn" type="submit">Registrar</button>
                </div>
                <div class="enviar-btn">
                    <button class="table-btn" onclick="location.href = '/CursosLibres/loginShow'">Volver</button>
                </div>
            </form>
        </div>
    </body>
</html>
