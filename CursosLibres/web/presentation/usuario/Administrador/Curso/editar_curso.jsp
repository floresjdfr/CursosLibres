
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
        <title>Editar Curso</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>
            
            <%
                String URL = "/CursosLibres/editarCursoAction?idCurso=" + codigo;
            %>

            <form method="POST" action="<%=URL%>" class="formulario-container">
                <div class = "formulario-form">
                    <table>
                        <tr>
                            <td class="curso-izquierda">Nombre:</td>
                            <td class="curso-derecha" class="input-curso">
                                <input class = "curso-derecha" name="nombre" type="text" value="<%=nombre%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Tematica:</td>
                            <td class="curso-derecha " class="input-curso">
                                <input class = "curso-derecha" name="tematica" type="text" value="<%=tematica%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Costo:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="costo" type="text" value="<%=costo%>">
                            </td>
                        </tr>
                         <td class="curso-izquierda">Oferta:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="oferta" type="text" value="<%=oferta%>">
                            </td>
                        </tr>
                        <%--<tr>
                            <td class="curso-izquierda">Imagen:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="imagen-curso" type="file" >
                            </td>
                        </tr>--%>
                    </table>
                </div>
                
                <div class="formulario-buttons">
                    <button type="submit"class="table-btn formulario-btn1">Guardar</button>
                    <button type="button" class="table-btn formulario-btn2" onclick="location.href = '/CursosLibres/Cursos'">Volver</button>
                </div>
               
            </form>



        </div>
    </body>
</html>
