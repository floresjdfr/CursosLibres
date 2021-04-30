/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.usuario.estudiante;

/**
 *
 * @author flore
 */
public class EstudianteCRUD {

    protected static final String CMD_LISTAR
            = "SELECT idEstudiante, nombre, apellido1, apellido2, correo, telefono, direccion, password FROM estudiante "
            + "ORDER BY apellido1, nombre;";

    protected static final String CMD_AGREGAR
            = "INSERT INTO estudiante (idEstudiante, nombre, apellido1, apellido2, correo, telefono, direccion, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT idEstudiante, nombre, apellido1, apellido2, correo, telefono, direccion, password FROM estudiante "
            + "WHERE idEstudiante = ?; ";

    protected static final String CMD_ACTUALIZAR
            = "UPDATE estudiante SET nombre = ?, apellido1 = ?, apellido2 = ?, correo = ?, telefono = ?, direccion = ?, password = ?"
            + "WHERE idEstudiante = ?;";

    protected static final String CMD_ELIMINAR
            = "DELETE FROM estudiante "
            + "WHERE idEstudiante = ?; ";

    protected static final String CMD_ACTUALIZARPass
            = "UPDATE estudiante SET correo = ?, telefono = ?, direccion = ?, password = ?"
            + "WHERE idEstudiante = ?;";

    

}
