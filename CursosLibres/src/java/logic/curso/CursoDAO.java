package logic.curso;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Database;


public class CursoDAO {
    
    
    private CursoDAO(){
        db = Database.instance();
    }
    
    public static CursoDAO obtenerInstancia(){
        if (instancia == null)
            instancia = new CursoDAO();
        return instancia;
    }
    
    public Curso recuperar(int id) {
        Curso resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(CursoCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Curso(
                                rs.getInt("codigo"),
                                rs.getString("nombre"),
                                rs.getString("tematica"),
                                rs.getFloat("costo"),
                                rs.getBoolean("oferta")
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return resultado;
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return resultado;
        }
        return resultado;
    }
    
    private Database db;
    private static  CursoDAO instancia;
}