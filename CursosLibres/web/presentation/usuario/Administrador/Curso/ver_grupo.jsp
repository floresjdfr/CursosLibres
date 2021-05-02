<%-- 
    Document   : Ver_Curso
    Created on : Apr 25, 2021, 6:58:01 PM
    Author     : josedf
--%>

<%@page import="logic.grupo.GrupoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.usuario.profesor.ProfesorDAO"%>
<%@page import="logic.curso.CursoDAO"%>
<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Curso"%>
<%@page import="logic.grupo.Grupo"%>
<%@page import="logic.grupo.Service"%>
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
            <%
                String aux = request.getParameter("idGrupo");
                int id = Integer.parseInt(aux);

                Grupo gg = GrupoDAO.obtenerInstancia().recuperar(id);
                Curso c = new Curso();
                Profesor p = new Profesor();
                int id1 = gg.getCurso_codigo();
                int id2 = gg.getProfesor_idPreofesor();
                c = CursoDAO.obtenerInstancia().recuperar(id1);
                p = ProfesorDAO.obtenerInstancia().recuperar(id2);
                String nombreC = c.getNombre();
                int idC=c.getCodigo();
                



            %>
            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <tr>
                            <td class="curso-izquierda">ID del curso:</td>
                            <td class="curso-derecha"><%= idC%> </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Nombre del curso:</td>
                            <td class="curso-derecha"> <%= nombreC%> </td>
                        </tr>
                       
                        <tr>
                            <td class="curso-izquierda">Nombre del Profesor:</td>
                            <td class="curso-derecha"><%= p.getNombre() +" "+ p.getApellido1()%> </td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Horaio:</td>
                            <td class="curso-derecha"><%= gg.getFecha() %></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/ListarGrupos?idCurso=<%=idC%>'">Volver</button>
            </div>

        </div>


    </body>
</html>
