<%-- 
    Document   : editar_profesor
    Created on : Apr 26, 2021, 10:41:20 PM
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
        <title>Editar Profresor</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>

            <form method="POST" action="#" class="formulario-container">
                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nombre" type="text" value="Aqui va el nombre">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Cedula:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="cedula" type="text" value="Aqui va la cedula">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Correo:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="correo" type="text" value="Aqui va el correo">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Telefono:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="telefono" type="text" value="Aqui va el telefono">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Especialidad</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="especialidad" type="text" value="Aqui va la especialidad">
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
