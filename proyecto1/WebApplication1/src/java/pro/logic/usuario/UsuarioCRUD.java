/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.logic.usuario;

/**
 *
 * @author flore
 */
public class UsuarioCRUD {
    protected static final String CMD_LISTAR
            = "SELECT nombre, nombre_Completo, clave, ultimoAcceso FROM usuario "
            + "ORDER BY nombre_Completo; ";
    protected static final String CMD_AGREGAR
            = "INSERT INTO usuario (nombre, nombre_Completo, clave, ultimoAcceso) "
            + "VALUES (?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT cedula, nombre, password FROM usuario "
            + "WHERE cedula = ?; ";
    protected static final String CMD_ACTUALIZAR
            = "UPDATE usuario SET nombre_completo = ?, clave = ?, ultimoAcceso = ? "
            + "WHERE nombre = ?; ";
    protected static final String CMD_ELIMINAR
            = "DELETE FROM usuario "
            + "WHERE nombre = ?; ";
}
