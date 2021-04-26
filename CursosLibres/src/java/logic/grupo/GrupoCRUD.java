
package logic.grupo;

public class GrupoCRUD {
    protected static final String CMD_LISTAR
            = "SELECT * FROM grupo";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO grupo (codigo, Profesor_Cedula, Curso_Codigo) "
            + "VALUES (?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT codigo, Profesor_Cedula, Curso_Codigo FROM grupo "
            + "WHERE nombre = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE grupo SET codigo = ?, Profesor_Cedula = ?, Curso_Codigo = ?"
            + "WHERE codigo = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM grupo "
            + "WHERE codigo = ?; ";
    
    
    // de aqui para abajo son los del grupo incluyendo a los estudiantes
    protected static final String CMD_AGREGAREG
            = "INSERT INTO grupo_has_estudiante (grupo_codigo, grupo_Curso_codigo, grupo_profesor_idProfesor, estudiante_idEstudiante) "
            + "VALUES (?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAREG
            = "SELECT grupo_codigo, grupo_Curso_codigo, grupo_profesor_idProfesor, estudiante_idEstudiante FROM grupo_has_estudiante "
            + "WHERE grupo_codigo = ?; ";
    
    protected static final String CMD_ELIMINAREG
            = "DELETE FROM grupo_has_estudiante "
            + "WHERE grupo_codigo = ?; ";
    
    
    protected static final String CMD_RECUPERARPG
            = "SELECT grupo_codigo, grupo_Curso_codigo, grupo_profesor_idProfesor, estudiante_idEstudiante FROM grupo_has_estudiante "
            + "WHERE grupo_profesor_idProfesor = ?; ";
    
}