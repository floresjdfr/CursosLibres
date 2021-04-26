
package logic.matricula;

public class MatriculaCRUD {
    protected static final String CMD_LISTAR
            = "SELECT * FROM curso_has_estudiante";
    
    public static final String CMD_AGREGAR
            = "INSERT INTO curso_has_estudiante (Curso_codigo, Estudiante_idEstudiante) "
            + "VALUES (?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT Curso_codigo, Estudiante_idEstudiante FROM curso "
            + "WHERE nombre = ?; ";
    
//    protected static final String CMD_ACTUALIZAR
//            = "UPDATE curso_has_estudiante SET Curso_codigo = ?, Estudiante_idEstudiante = ?"
//            + "WHERE codigo = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM curso_has_estudiante "
            + "WHERE Curso_codigo = ? && Estudiante_idEstudiante = ?; ";
    
}