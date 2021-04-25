<%-- 
    Document   : Cursos
    Created on : Apr 25, 2021, 1:55:44 AM
    Author     : josedf
--%>

<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>

<%
    Service lista = (Service) request.getAttribute("listaCursos");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Administrador</title>
        <link rel="stylesheet" href="/CursosLibres/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
    </head>
    <body style="background: rgb(21, 11, 33);">
        <%@ include file="/header.jsp" %>

        <div style="margin-top: 81px;">
            <div class="container text-left" style="max-width: 1700px;">
                <div class="row">
                    <div class="col">
                        <div>

                            <div class="table-responsive" style="width: 683px;margin-left: 462px;">

                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th style="color: rgb(255,255,255);padding-left: 75px;width: 173px;padding-right: -8px;max-width: 200px;min-width: -26px;">
                                                <p style="margin-top: 15px;font-size: 32px;width: 97px;margin-left: 199px;">Curso</p>
                                            </th>
                                            <th style="color: rgb(255,255,255);width: 361px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% if (lista.cursosList() != null) {%>
                                        <%for (Curso c : lista.cursosList()) {%>
                                        <tr>
                                            <td style="color: rgb(255,255,255);padding-left: 120px;width: 505px;"><%=c.getNombre()%></td>
                                            <td class="float-left" style="color: rgb(255,255,255);margin-right: 0px;margin-left: 51px;"><button class="btn btn-primary" type="button">Ver</button></td>

                                        </tr>
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
