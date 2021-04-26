<%-- 
    Document   : informacion-registro
    Created on : Apr 26, 2021, 1:24:20 PM
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
        <title>Informacion Registro</title>
    </head>

<body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Usuario:</td>
                            <td class="curso-derecha">Aqui va la cedula</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Password:</td>
                            <td class="curso-derecha">Aqui va la contraseña aleatoria</td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Nueva contraseña:</td>
                        
                            <td class="curso-derecha">
                                <form method="POST">
                                    <input type="text">
                                </form>
                            </td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='#'">Guardar</button>
            </div>
        
        </div>
    </body>
</html>
