/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.logic.usuario.estudiante;

/**
 *
 * @author flore
 */
public class EstudianteCRUD {
    protected static final String CMD_LISTAR
            = "SELECT idEstudiante, nombre, apellido1, apellido2, correo, numero, direccion, password FROM estudiante "
            + "ORDER BY apellido1, nombre;";
    
    protected static final String CMD_AGREGAR
            = "INSERT INTO estudiante (idEstudiantenombre, apellido1, apellido2, correo, numero, direccion, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";

    protected static final String CMD_RECUPERAR
            = "SELECT idEstudiante, nombre, apellido1, apellido2, correo, numero, direccion, password FROM estudiante "
            + "WHERE idEstudiante = ?; ";
    
    protected static final String CMD_ACTUALIZAR
            = "UPDATE estudiante SET idEstudiante = ?, nombre = ?, apellido1 = ?, apellido2 = ?, correo = ?, numero = ?, direccion = ?, password = ?"
            + "WHERE idEstudiante = ?;";
    
    protected static final String CMD_ELIMINAR
            = "DELETE FROM estudiante "
            + "WHERE idEstudiante = ?; ";
}
