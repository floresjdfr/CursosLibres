

<%@page import="logic.grupo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Grupo grupo = (Grupo) request.getAttribute("GrupoEL");
        int codigo = grupo.getCodigo();
        int codigocurso = grupo.getCurso_codigo();
        int IDProfesor = grupo.getProfesor_idPreofesor();
        String fecha = grupo.getFecha();
        request.setAttribute("idGrupo", codigo);
        
    %>
    
    
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
                            <td class="curso-derecha"><%= "Grupo N: " + codigo +" en el horario "+ fecha%></td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='#'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href='/CursosLibres/ListarGrupos?idCurso=<%=codigocurso%>'">Cancelar</button>
            </div>
        
        </div>
    </body>
</html>
