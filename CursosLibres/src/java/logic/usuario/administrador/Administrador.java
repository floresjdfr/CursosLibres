package logic.usuario.administrador;

import logic.usuario.Usuario;


public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(int cedula, String nombre, String apellido1, String apellido2, String correo, String telefono, String password) {
        super(cedula, nombre, apellido1, apellido2, correo, telefono, password);
    }
    
}
