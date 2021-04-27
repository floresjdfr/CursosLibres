<%@page import="logic.usuario.Usuario"%>
<%@page import="logic.usuario.estudiante.Estudiante"%>
<%@page import="logic.usuario.profesor.Profesor"%>
<%@page import="logic.usuario.administrador.Administrador"%>

<header class="header-container">               
   <h1 class="header-h1">CursosLibres.com</h1>
    <div class="dropdown">
        <button class="dropbtn">Menu</button>
        <div class="dropdown-content">
            <a href="/CursosLibres/CursoDisplay">Inicio</a>
                <% Usuario usuario = (Usuario) session.getAttribute("usr"); %>

                <% if (usuario!=null){ %>

                <% String tipoUsr = usuario.getClass().getSimpleName(); %>
                <% if (usuario.getClass().getSimpleName().equals("Estudiante")){ %>
                    <a href="#">Matricular</a>
                    <a href="#">Ver cursos actuales</a>
                    <a href="#">Ver historial</a>
                    <a href="/CursosLibres/Logout">Logout</a>
                <% } %>
                <% if (tipoUsr.equals("Profesor")){%>
                    <a href="#">Grupos y cursos</a>
                    <a href="/CursosLibres/Logout">Logout</a>
                <% }%>  
                <% if (tipoUsr.equals("Administrador")){%>
                    <a href="/CursosLibres/Cursos">Administrar Cursos y Grupos</a>
                    <a href="#">Administrar Profesores</a>
                    <a href="/CursosLibres/Logout">Logout</a>
                <% }%>  
                <% } else {%> 
                     <a href="/CursosLibres/loginShow">Login</a>
                <% }%>
        </div>
    </div> 
</header>