<%-- 
    Document   : agregar_profesor
    Created on : Apr 26, 2021, 11:35:41 PM
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
        <title>Agregar Profesor</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>

            <form  class="formulario-container" method="POST" action="#">

                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nombre" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Cedula:</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="cedula" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="correo" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Telefono</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="telefono" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Especialidad</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="especialidad" type="text">
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="formulario-buttons"> 
                    <button type="submit" class="table-btn formulario-btn1" onclick="location.href = '#'">Guardar</button>

                    <button type="button" class="table-btn formulario-btn2" onclick="location.href = 'profesor.jsp'">Volver</button>
                </div>
            </form>


        </div>
    </body>
</html>
