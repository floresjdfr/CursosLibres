<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        int cursoID = (int) request.getAttribute("cursoID");
        String cursoIdString = String.valueOf(cursoID);
        String urlGruposShow = "/CursosLibres/GruposMatricularShow?idCurso="+cursoIdString;
        String nombreCurso = (String) request.getAttribute("nombreCurso");
        String nombreProfesor = (String) request.getAttribute("nombreProfesor");
        String horario = (String) request.getAttribute("horario");
    %>
    
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
                            <td class="curso-izquierda">Nombre del curso: aqui</td>
                            <td class="curso-derecha"><%=nombreCurso%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Nombre del Profesor:</td>
                            <td class="curso-derecha"><%=nombreProfesor%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Horario:</td>
                            <td class="curso-derecha"><%=horario%></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="volver-btn">
                <%
                    
                %>
                <button class="table-btn" onclick="location.href = '<%=urlGruposShow%>'">Volver</button>
            </div>

        </div>
    </body>
</html>
