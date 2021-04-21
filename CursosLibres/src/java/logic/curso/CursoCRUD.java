package logic.curso;

public class CursoCRUD {
    protected static final String CMD_LISTAR
            = "SELECT * FROM Curso";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO curso (codigo, nombre, tematica, costo, oferta) "
            + "VALUES (?, ?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT codigo, nombre, tematica, costo, oferta FROM curso "
            + "WHERE nombre = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE curso SET codigo = ?, nombre = ?, tematica = ?, costo = ?, oferta = ?"
            + "WHERE nombre = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM curso "
            + "WHERE codigo = ?; ";
    
}