package logic.curso;

public class CursoCRUD {
    protected static final String CMD_LISTAR
            = "SELECT * FROM curso";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO curso (nombre, tematica, costo, oferta) "
            + "VALUES (?, ?, ?, ?)";

    protected static final String CMD_RECUPERAR
            = "SELECT codigo, nombre, tematica, costo, oferta FROM curso "
            + "WHERE codigo = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE curso SET nombre = ?, tematica = ?, costo = ?, oferta = ? "
            + "WHERE codigo = ?;";
    
   
    
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM curso "
            + "WHERE codigo = ?; ";
    
    
    protected static final String CMD_LISTAR_CURSOS_ACTUALES
            = "SELECT curso.nombre, grupo.codigo, profesor.nombre, profesor.apellido1, grupo.fecha, grupo_has_estudiante.nota "
            + "from grupo_has_estudiante "
            + "inner join grupo "
            + "on grupo_has_estudiante.grupo_codigo = grupo.codigo "
            + "inner join curso "
            + "on grupo.Curso_codigo = curso.codigo "
            + "inner join profesor "
            + "on grupo.profesor_idProfesor = profesor.idProfesor "
            + "where grupo_has_estudiante.codigo = ?;";
    
    protected static final String CMD_BUSCAR_NOMBRE = "SELECT codigo, nombre, costo "
            + "FROM curso "
            + "WHERE nombre LIKE ?;";
    
    protected static final String CMD_LISTAR_CURSOS_PROFESOR = ""
            + "SELECT curso.codigo, curso.nombre, curso.tematica, curso.costo, curso.oferta "
            + "FROM grupo "
            + "INNER JOIN curso "
            + "ON grupo.Curso_codigo = curso.codigo "
            + "WHERE profesor_idProfesor = ?;";
}