<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Historial Cursos</title>
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
                        <th >Historial Cursos</th>
                        <th class="curso-derecha">Nota</th>
                    </tr>
                    
                    <tr>
                        <td class="curso-centro">Nombre del curso aqui</td>
                        <td class="curso-derecha">Nota del curso aqui</td>
                    </tr>
                </table>
            </div>
        </div>
    </body>  
</html>
