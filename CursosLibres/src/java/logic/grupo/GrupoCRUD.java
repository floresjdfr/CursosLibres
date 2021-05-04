package logic.grupo;

public class GrupoCRUD {

    protected static final String CMD_LISTAR
            = "SELECT * FROM grupo";

    protected static final String CMD_Listar_CODIGO = "SELECT * from grupo WHERE Curso_codigo = ?;";

    protected static final String CMD_AGREGAR
            = "INSERT INTO grupo (Curso_codigo,profesor_idProfesor,fecha) "
            + "VALUES (?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT codigo, Curso_codigo,profesor_idProfesor,fecha FROM grupo "
            + "WHERE codigo = ?; ";

    protected static final String CMD_ACTUALIZAR
            = "UPDATE grupo SET codigo = ?, Curso_codigo = ?, profesor_idProfesor = ?,fecha = ?"
            + "WHERE codigo = ?;";

    protected static final String CMD_ELIMINAR
            = "DELETE FROM grupo "
            + "WHERE codigo = ?; ";

    protected static final String CMD_LISTAR_GRUPOS_PROFESOR = ""
            + "SELECT codigo, fecha "
            + "FROM grupo "
            + "WHERE profesor_idProfesor = ?;";

    protected static final String CMD_LISTAR_ESTUDIANTES_GRUPO = "SELECT codigo, nombre, apellido1, apellido2, nota "
            + "FROM grupo_has_estudiante "
            + "INNER JOIN estudiante "
            + "ON grupo_has_estudiante.codigo = estudiante.idEstudiante "
            + "WHERE grupo_has_estudiante.grupo_codigo = ?;";

    // de aqui para abajo son los del grupo incluyendo a los estudiantes
    protected static final String CMD_MATRICULAR = "INSERT INTO grupo_has_estudiante (grupo_codigo, codigo) VALUES (?, ?);";

    protected static final String CMD_RECUPERAREG
            = "SELECT grupo_codigo, grupo_Curso_codigo, grupo_profesor_idProfesor, estudiante_idEstudiante FROM grupo_has_estudiante "
            + "WHERE grupo_codigo = ?; ";

    protected static final String CMD_ELIMINAREG
            = "DELETE FROM grupo_has_estudiante "
            + "WHERE grupo_codigo = ?; ";

    protected static final String CMD_RECUPERARPG
            = "SELECT grupo_codigo, grupo_Curso_codigo, grupo_profesor_idProfesor, estudiante_idEstudiante FROM grupo_has_estudiante "
            + "WHERE grupo_profesor_idProfesor = ?; ";

    protected static final String CMD_ACTUALIZARG
            = "UPDATE grupo SET Curso_codigo = ?, profesor_idProfesor = ?,fecha = ?"
            + "WHERE codigo = ?;";

}
