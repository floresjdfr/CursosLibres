<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Administrador</title>
        <link rel="stylesheet" href="/CursosLibres/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="table-container">
                <table>
                    <tr>
                        <th>Cursos</th>
                        <th></th>
                    </tr>

                    <tr>
                        <td>Aqui va nombre del curso</td>
                        <td>
                            <button onclick="location.href = '/CursosLibres/presentation/misc/Grupos.jsp'" class="table-btn">Ver Grupos</button>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </body>  
</html>
