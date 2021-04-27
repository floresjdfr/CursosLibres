<%-- 
    Document   : ver_informacion
    Created on : Apr 26, 2021, 10:41:11 PM
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
                            <td class="curso-derecha">Aqui va el nombre</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Cedula:</td>
                            <td class="curso-derecha">Aqui va la cedula</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha">Aqui va el correo</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Telefono:</td>
                            <td class="curso-derecha">Aqui va el telefono</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Especialidad:</td>
                            <td class="curso-derecha">Aqui va la especialidad</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = 'profesor.jsp'">Volver</button>
            </div>

        </div>





    </body>
</html>
