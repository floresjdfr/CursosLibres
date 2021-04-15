

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <form action="presentation/login" method="post">    
        
            <div class="form-group boxlogin jumbotron container">
                        <div class="form-group">
                            <label for="username">NombreUsuariofghfgh:</label>
                            <input type="text" class="form-control" name="usernameText" aria-describedby="emailHelp" placeholder="Numero de Cedula" required="" >
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" name="passwordText" placeholder="Contrasena" required="" >
                        </div>
                            
                        <div class="alert alert-danger alert-dismissable">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>¡Error!</strong> EL Usuario o la contrasena son incorrectos.
                        
                        <button type="submit" class="btn btn-primary botton">LogIn</button>
                        </div>
                </div>
</form>
        
</html>
