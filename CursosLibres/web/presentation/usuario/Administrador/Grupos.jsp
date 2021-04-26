<%-- 
    Document   : Grupos
    Created on : Apr 25, 2021, 6:46:58 PM
    Author     : josedf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    <title>Document</title>
</head>
<body>
    <div class="main-container">
        <%@include file="/header.jsp"%>
        <div class="table-container">
            <table>
                <tr>
                    <th>Grupos</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td>Grupo 1</td>
                    <td>
                        <button class="table-btn" onclick="location.href='/CursosLibres/presentation/usuario/Administrador/Ver_Grupo.jsp'" >Ver Informacion de Grupo</button>
                    </td>
                    <td>
                        <button class="table-btn" onclick="location.href='/CursosLibres/presentation/usuario/Administrador/Editar_Grupo.jsp'">Editar</button>
                    </td>
                    <td>
                        <button class="table-btn">Eliminar</button>
                    </td>
                </tr>
                <tr>
                    <td>Grupo 2</td>
                    <td>
                        <button class="table-btn">Ver Informacion de Grupo</button>
                    </td>
                    <td>
                        <button class="table-btn">Editar</button>
                    </td>
                    <td>
                        <button class="table-btn">Eliminar</button>
                    </td>
                </tr>
                <tr>
                    <td>Grupo 3</td>
                    <td>
                        <button class="table-btn">Ver Informacion de Grupo</button>
                    </td>
                    <td>
                        <button class="table-btn">Editar</button>
                    </td>
                    <td>
                        <button class="table-btn">Eliminar</button>
                    </td>
                </tr>

            </table>
        </div>
    </div>
</body>

</html>
