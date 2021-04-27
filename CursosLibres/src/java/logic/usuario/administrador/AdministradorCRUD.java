
package logic.usuario.administrador;


public class AdministradorCRUD {
    protected static final String CMD_LISTAR
            = "SELECT idAdministrador, nombre, apellido1, apellido2, correo, telefono, password FROM administrador "
            + "ORDER BY apellido1, nombre;";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO administrador (idAdministrador, nombre,  apellido1, apellido2, correo, telefono, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT idAdministrador, nombre, apellido1, apellido2, correo, telefono, password FROM administrador "
            + "WHERE idAdministrador = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE administrador SET idAdministrador = ?, nombre = ?, apellido1 = ?, apellido2 = ?, correo = ?, telefono = ?, password = ?"
            + "WHERE idAdministrador = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM administrador "
            + "WHERE idAdministrador = ?; ";
    
}
