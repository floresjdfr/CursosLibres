

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="/header.jsp" %>
        
        <form name="form" action="/CursosLibres/Login" method="post">    
            <div>
                <div>
                    <label for="username">Nombre Usuario:</label>
                    <input type="number" name="usernameText" placeholder="Numero de Cedula" required="" >
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" name="passwordText" placeholder="Contrasena" required="" >
                </div>
                <div>
                    <button type="submit">LogIn</button>
                </div>
            </div>
        </form>
        
        <%@ include file="/footer.jsp" %>

    </body>


</html>
