<%-- 
    Document   : agregar_grupo
    Created on : Apr 26, 2021, 3:44:40 PM
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

            <form  class="formulario-container" method="POST" action="#">

                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nombre-grupo" type="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Profesor:</td>
                            <td class="curso-derecha ">
                                <input class = "curso-derecha" name="profesor-grupo" type="text">
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="formulario-buttons"> 
                    <button class="table-btn formulario-btn1" onclick="location.href = '/CursosLibres/Cursos'">Guardar</button>

                    <button class="table-btn formulario-btn2" onclick="location.href = '/CursosLibres/presentation/misc/Grupos.jsp'">Volver</button>
                </div>
            </form>






        </div>
    </body>
</html>
