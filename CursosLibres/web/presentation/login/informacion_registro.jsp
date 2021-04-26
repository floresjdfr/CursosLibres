<%@page import="logic.usuario.estudiante.Estudiante"%>
<%@page import="logic.usuario.estudiante.Service"%>

<% Service lista = (Service) request.getAttribute("estudiante");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/my-styles.css">
        <title>Informacion Registro</title>
    </head>

<body>
        <div class="main-container">
            <%@include file="/header.jsp"%>
            

            <div class="curso-container">
                <div class = "tabla-info-cursos">
                    <table>
                        <% if (lista.estudiantesList() != null) %>
                        <% for (Estudiante e : lista.estudiantesList()){ %>
                        
                        <tr>
                            <td class="curso-izquierda">Usuario:</td>
                            <td class="curso-derecha" ><%= e.getCedula() %></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Password Temporal</td>
                            <td class="curso-derecha"><%= e.getPassword() %></td>
                            <%}%>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Se recomienda cambiar esta password en el perfil</td>
                          
                        </tr>
                        
                    </table>

                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href='/CursosLibres/CursoDisplay'">Inicio</button>
            </div>
        </div>
    </body>
</html>
