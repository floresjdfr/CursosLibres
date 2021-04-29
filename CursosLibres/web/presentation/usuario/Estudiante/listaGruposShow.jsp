<%@page import="logic.grupo.Grupo"%>
<%@page import="logic.grupo.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%
        Usuario usr = (Usuario) session.getAttribute("usr");
        Service service = (Service) request.getAttribute("listaGrupos");
        

    %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Grupos</title>
    </head>
    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>
            <div class="table-container">
                <table>
                    <tr>
                        <th>Grupos</th>
                        <th>Horario</th>
                        <th></th><!-- comment -->
                        <th></th>
                    </tr>
                    <%
                        if (usr != null) {
                            for (Grupo g : service.gruposList()) {
                                String urlVerInfo = "/CursosLibres/InfoGrupoShow?idGrupo=" + g.getCodigo() + 
                                        "&idCurso=" + g.getCurso_codigo() + "&idProfesor=" + g.getProfesor_idPreofesor();
                    
                    %>
                    <tr>
                        <td>Grupo <%=g.getCodigo()%></td>
                        <td>Grupo <%=g.getFecha()%></td>
                        <td>
                            <button class="table-btn" onclick="location.href = '<%=urlVerInfo%>'" >Ver Informacion de Grupo</button>
                        </td>

                        <%

                            String tipoUsuario = usuario.getClass().getSimpleName();
                            switch (tipoUsuario) {
                                case "Estudiante": {%>
                        <td>
                            <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Estudiante/confirmar_matricula.jsp'">Matricular</button>
                        </td>
                        <%break;
                                        }

                                    }
                                }
                            }%>


                </table>
            </div>
        </div>
    </body>

</html>
