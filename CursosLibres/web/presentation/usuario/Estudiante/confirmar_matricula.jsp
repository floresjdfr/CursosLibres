<%-- 
    Document   : confirmar_matricula
    Created on : Apr 27, 2021, 12:17:05 AM
    Author     : josedf
--%>

<%@page import="logic.curso.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Curso curso = (Curso) request.getAttribute("curso");
        String idGrupo = (String) request.getAttribute("idGrupo");

        String urlConfirmar = "/CursosLibres/MatricularAction?idGrupo=" + idGrupo;
        String urlCancelar = "/CursosLibres/GruposMatricularShow?idCurso=" + curso.getCodigo();
    %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Confirmar Matricula</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">¿Desea matricular curso?:</td>
                            <td class="curso-derecha"><%=curso.getNombre()%></td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '<%=urlConfirmar%>'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href = '<%=urlCancelar%>'">Cancelar</button>
            </div>

        </div>
    </body>
</html>
