<%@page import="logic.usuario.Usuario"%>
<%@page import="logic.usuario.estudiante.Estudiante"%>
<%@page import="logic.usuario.profesor.Profesor"%>
<%@page import="logic.usuario.administrador.Administrador"%>

<header class="d-flex flex-row" style="margin-top: 70px;margin-left: 30px;border-style: none;">
    <div class="container">
        <div class="row">
            <div class="col-9">
                <div>
                    <h1 style="color: var(--light);">CursosLibres.com</h1>
                </div>
            </div>
            <div class="col">
               
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" name="Menu" type="button" id="dropdownMenuButton" 
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" 
                            style="color: var(--light);background: rgb(81, 0, 44);">
                        Menu
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <% Usuario usuario = (Usuario) session.getAttribute("usr"); %>
                        
                        <a class="dropdown-item" href="/CursosLibres/CursoDisplay">Inicio</a>
                        
                        
                        <% if (usuario!=null){ %>
                        
                        <% String tipoUsr = usuario.getClass().getSimpleName(); %>
                        <% if (usuario.getClass().getSimpleName().equals("Estudiante")){ %>
                            <a class="dropdown-item" href="#">Matricular</a>
                            <a class="dropdown-item" href="#">Ver cursos actuales</a>
                            <a class="dropdown-item" href="#">Ver historial</a>
                            <a class="dropdown-item" href="/CursosLibres/Logout">Logout</a>
                        <% } %>
                        <% if (tipoUsr.equals("Profesor")){%>
                            <a class="dropdown-item" href="#">Grupos y cursos</a>
                            <a class="dropdown-item" href="/CursosLibres/Logout">Logout</a>
                        <% }%>  
                        <% if (tipoUsr.equals("Administrador")){%>
                            <a class="dropdown-item" href="/CursosLibres/Cursos">Administrar Cursos y Grupos</a>
                            <a class="dropdown-item" href="#">Administrar Estudiantes</a>
                            <a class="dropdown-item" href="#">Administrar Profesores</a>
                            <a class="dropdown-item" href="/CursosLibres/Logout">Logout</a>
                        <% }%>  
                        <% } else {%> 
                             <a class="dropdown-item" href="/CursosLibres/loginShow">Login</a>
                        <% }%>

                    </div>

                </div>
            </div>
        </div>
    </div>

</header>