<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>CursosLibres</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="fonts/ionicons.min.css">
        <link rel="stylesheet" href="css/Login-Form-Dark.css">
    </head>
    <body style="background: rgb(21, 11, 33);">
        <%@ include file="header.jsp" %>
        
        <div style="margin-top: 81px;">
            <div class="container text-left" style="max-width: 1700px;">
                <div class="row">
                    <div class="col">
                        <div>
                            <h1 style="color: var(--white);">Cursos</h1>
                            <div class="table-responsive">
                                <table class="table table-borderless">
                                    <thead>
                                        <%
                                            Service listaCursos = (Service) request.getAttribute("listaCursos");
                                            if (listaCursos != null){
                                                for (Curso c: listaCursos.cursosList()){%>
                                                <th style="color: var(--white);font-size: 25px;"><%c.getNombre();%></th>
                                                <th style="color: var(--white);font-size: 25px;"><%c.getCosto();%></th>
                                            <%}%>
                                            <%}%>
                                            
                                         
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        
        <script src="js/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
