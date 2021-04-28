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
                    <tr>
                        <td>Grupo 1</td>
                        <td>
                            <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/ver_grupo.jsp'" >Ver Informacion de Grupo</button>
                        </td>
                        <%
                            if (usuario != null){
                            String tipoUsuario = usuario.getClass().getSimpleName();
                            switch (tipoUsuario) {
                                case "Estudiante": {%>
                                    <td>
                                        <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Estudiante/confirmar_matricula.jsp'">Matricular</button>
                                    </td>
                        <%      break;
                            }
                                case "Administrador": {%>
                                    <td>
                                        <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/editar_grupo.jsp'">Editar</button>
                                    </td>
                                    <td>
                                        <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/borrar_grupo.jsp'" >Eliminar</button>
                                    </td>
                                <%break;
                                }
                            }   
                            }
                            %>
                    </tr>
                </table>
            </div>
            <%
                if (usuario != null){
                    if (usuario.getClass().getSimpleName().equals("Administrador")){%>
                        <div class="volver-btn">
                            <button class="table-btn" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/agregar_grupo.jsp'">Agregar</button>
                        </div>
            <%
                    }
                }
            %>
            
        </div>
    </body>

</html>
