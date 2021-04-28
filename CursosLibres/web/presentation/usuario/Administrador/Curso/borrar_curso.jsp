
<%@page import="logic.curso.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        Curso curso=(Curso) request.getAttribute("curso_editar");
        int codigo= curso.getCodigo();
        String nombre= curso.getNombre();
        String tematica = curso.getTematica();
        String costo = curso.getCosto();
        int oferta = curso.getOferta();    
    %>
    
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Eliminar Curso</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">¿Desea eliminar curso?:</td>
                            <td class="curso-derecha"><%=nombre%></td>
                            <td class="curso-derecha"><%=tematica%></td>
                        </tr>
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='/CursosLibres/eliminarCursoAction?idCurso=<%=codigo%>'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href='/CursosLibres/Cursos'">Cancelar</button>
            </div>
        
        </div>
    </body>
</html>
