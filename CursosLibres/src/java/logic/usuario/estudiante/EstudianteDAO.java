/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.usuario.estudiante;

import logic.usuario.estudiante.EstudianteCRUD;
import logic.usuario.estudiante.Estudiante;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Database;

/**
 *
 * @author flore
 */
public class EstudianteDAO {
    
    
    private EstudianteDAO(){
        db = Database.instance();
    }
    
    public static EstudianteDAO obtenerInstancia(){
        if (instancia == null)
            instancia = new EstudianteDAO();
        return instancia;
    }
    
    public Estudiante recuperar(int id) {
        Estudiante resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(EstudianteCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Estudiante(
                                rs.getInt("idEstudiante"),
                                rs.getString("nombre"),
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getString("direccion"),
                                rs.getString("password")
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
                return resultado;
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return resultado;
        }
        return resultado;
    }
    
    private Database db;
    private static EstudianteDAO instancia;
}
