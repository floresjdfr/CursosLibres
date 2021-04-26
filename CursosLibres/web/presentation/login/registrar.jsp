<%-- 
    Document   : registrr
    Created on : Apr 26, 2021, 1:02:49 PM
    Author     : josedf
--%>

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

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha" class="input-curso">
                                <input class = "curso-derecha" name="nombre-alumno" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Cédula:</td>
                            <td class="curso-derecha " class="input-curso">
                                <input class = "curso-derecha" name="cedula-alumno" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="correo-alumno" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Teléfono:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="telefono-alumno" type="text">
                            </td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='informacion_registro.jsp'">Registrar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href='login.jsp'">Volver</button>
            </div>

        </div>
    </body>
</html>
