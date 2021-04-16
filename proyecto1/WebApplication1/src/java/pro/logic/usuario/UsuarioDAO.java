/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.logic.usuario;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pro.logic.Database;

/**
 *
 * @author flore
 */
public class UsuarioDAO {
    
    
    private UsuarioDAO(){
        db = Database.instance();
    }
    
    public static UsuarioDAO obtenerInstancia(){
        if (instancia == null)
            instancia = new UsuarioDAO();
        return instancia;
    }
    
    public Usuario recuperar(String id) {
        Usuario resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(UsuarioCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setString(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Usuario(
                                rs.getString("cedula"),
                                rs.getString("nombre"),
                                rs.getString("password")
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return resultado;
    }
    
    private Database db;
    private static UsuarioDAO instancia;
}
