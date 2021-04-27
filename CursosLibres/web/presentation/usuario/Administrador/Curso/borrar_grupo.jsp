<%-- 
    Document   : confirmacion_eliminacion_curso
    Created on : Apr 26, 2021, 3:10:40 PM
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
        <title>Eliminar Grupo</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">¿Desea eliminar Grupo?:</td>
                            <td class="curso-derecha">Aqui va el nombre del grupo a eliminar</td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='#'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href='#'">Cancelar</button>
            </div>
        
        </div>
    </body>
</html>
