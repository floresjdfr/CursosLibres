
package logic.usuario.profesor;

public class ProfesorCRUD {
    protected static final String CMD_LISTAR
            = "SELECT idProfesor, nombre, apellido1, apellido2, correo, telefono, especialidad, password FROM profesor "
            + "ORDER BY apellido1, nombre;";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO profesor (idProfesor, nombre, apellido1, apellido2, correo, telefono, especialidad, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT idProfesor, nombre, apellido1, apellido2, correo, telefono, especialidad, password FROM profesor "
            + "WHERE idProfesor = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE profesor SET nombre = ?, apellido1 = ?, apellido2 = ?, correo = ?, telefono = ?, especialidad = ?, password = ?"
            + "WHERE idProfesor = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM profesor "
            + "WHERE idProfesor = ?; ";
    
     protected static final String CMD_BUSCAR_NOMBRE = "SELECT idProfesor, nombre, apellido1, apellido2, correo, telefono, especialidad, password "
            + "FROM profesor "
            + "WHERE nombre LIKE ?;";
    
    
}
