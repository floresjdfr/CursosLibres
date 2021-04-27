<%-- 
    Document   : Ver_Curso
    Created on : Apr 25, 2021, 6:58:01 PM
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
    <title>Ver Grupo</title>
</head>

<body>
    <div class="main-container">
        <%@include file="/header.jsp"%>

        <div class="curso-container">
            <div class = "tabla-info-cursos">
                <table>
                    <tr>
                        <td class="curso-izquierda">Nombre del curso:</td>
                        <td class="curso-derecha">Programacion 4 </td>
                    </tr>
                    <tr>
                        <td class="curso-izquierda">ID del curso:</td>
                        <td class="curso-derecha">EIF404 </td>
                    </tr>
                    <tr>
                        <td class="curso-izquierda">Nombre del Profesor:</td>
                        <td class="curso-derecha">Jose Sanchez</td>
                    </tr>
                    <tr>
                        <td class="curso-izquierda">Cantidad de alumnos:</td>
                        <td class="curso-derecha">25</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="volver-btn">
            <button class="table-btn" onclick="location.href='/CursosLibres/presentation/misc/Grupos.jsp'">Volver</button>
        </div>
        
    </div>





</body>
</html>
