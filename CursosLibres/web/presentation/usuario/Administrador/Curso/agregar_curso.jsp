<%-- 
    Document   : agregar_curso
    Created on : Apr 26, 2021, 3:36:20 PM
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
        <title>Agregar Curso</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>

            <form  class="formulario-container" method="POST" action="/CursosLibres/Cursos">

                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nombre-curso" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Tematica:</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="tematica-curso" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Costo:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="costo-curso" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Imagen:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="imagen-curso" type="file">
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="formulario-buttons">

                    <button type="submit" class="formulario-btn1 table-btn"type="submit">Guardar</button>

                    <button type="button" class="formulario-btn2 table-btn" onclick="location.href = '/CursosLibres/Cursos'">Volver</button>

                </div>

            </form>




        </div>
    </body>
</html>
