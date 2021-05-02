<%@page import="logic.grupo.Grupo"%>
<%@page import="logic.grupo.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%

        Usuario usr = (Usuario) session.getAttribute("usr");

    %>
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
                        <th colspan="4">Grupos</th>
                    </tr>

                    <%
                        if (usr != null) {
                            Service service = (Service) request.getAttribute("listaGrupos");

                            for (Grupo g : service.gruposList()) {%>

                    <tr>
                        <td>Grupo <%=+g.getCodigo()%></td>
                        <td>
                            <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/ver_grupo.jsp?idGrupo=<%=g.getCodigo()%>'">Ver Informacion de Grupo</button>
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
                            case "Administrador": {%>
                        <td>
                            <button class="table-btn" onclick="location.href = '/CursosLibres/editarGrupoShow?idGrupo=<%= g.getCodigo() %>'">Editar</button>
                        </td>
                        <td>
                            <button class="table-btn" onclick="location.href = '/CursosLibres/borrarGrupoShow?idGrupo=<%= g.getCodigo() %>'" >Eliminar</button>
                        </td>
                        <%break;
                                }
                            }%>

                    </tr>
                    <%}
                        }
                    %>
                    
                </table>

            </div>

            <%
                if (usuario != null) {
                    if (usuario.getClass().getSimpleName().equals("Administrador")) {%>
            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/agregar_grupo.jsp'">Agregar</button>

                <div>  <button class="table-btn" onclick="location.href = '/CursosLibres/Cursos'">Volver  .jsp 78 arregalr </button> </div>

            </div>
            
            <%
                    }
                }
            %>

        </div>
    </body>

</html>
