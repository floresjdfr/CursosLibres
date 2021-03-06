<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Agregar Curso</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>

            <form  class="formulario-container" method="POST" action="/CursosLibres/agregarCurso" enctype="multipart/form-data">

                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nombre" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Tematica:</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="tematica" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Costo:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="costo" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Oferta:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="oferta" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Imagen:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="imagen" type="file" required>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="formulario-buttons">

                    <button class="formulario-btn1 table-btn" type="submit">Guardar</button>

                    <button type="button" class="formulario-btn2 table-btn" onclick="location.href = '/CursosLibres/Cursos'">Volver</button>

                </div>

            </form>




        </div>
    </body>
</html>
