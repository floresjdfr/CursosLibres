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
import javax.servlet.http.HttpServletRequest;
import logic.Database;
import logic.matricula.MatriculaCRUD;
import logic.matricula.Matricula;
import logic.matricula.MatriculaDAO;
import logic.matricula.Service;

public class EstudianteDAO {

    private EstudianteDAO() {
        db = Database.instance();
    }

    public static EstudianteDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new EstudianteDAO();
        }
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

    
   
    public void crear(HttpServletRequest request) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(EstudianteCRUD.CMD_AGREGAR);
        int aux=Integer.parseInt(request.getParameter("idEstudiante"));
        
        stm.setInt(1, aux);
        stm.setString(2, (String) request.getParameter("nombre"));
        stm.setString(3, (String) request.getParameter("apellido1"));
        stm.setString(4, (String) request.getParameter("apellido2"));
        stm.setString(5, (String) request.getParameter("correo"));
        stm.setString(6, (String) request.getParameter("telefono"));
        stm.setString(7, (String) request.getParameter("direccion"));
        stm.setString(8, randomPassword());
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }

    public void matricular(HttpServletRequest request) throws Exception {

        logic.matricula.Service srv = new Service();
        srv.matricular(request);
    }

    public String randomPassword() {

        String pswd = "";
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 4; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd;
    }

     public void actualizar(Estudiante p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(EstudianteCRUD.CMD_ACTUALIZARPass);

        stm.setString(1, p.getCorreo());
        stm.setString(2, p.getNumero());
        stm.setString(3, p.getDireccion());
        stm.setString(4, p.getPassword());
        stm.setInt(5, p.getCedula());
 
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }
     
    public void actualizarNota(int idEstudiante, int idGrupo, int nota) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(EstudianteCRUD.CMD_ACTUALIZAR_NOTA);

        stm.setInt(1, nota);
        stm.setInt(2, idGrupo);
        stm.setInt(3, idEstudiante);
         
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    } 
    
    public int recuperarNota(int idEstudiante) throws Exception {

        int resultado = 0;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(EstudianteCRUD.CDM_RECUPERAR_NOTA)) {
                stm.clearParameters();
                stm.setInt(1, idEstudiante);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = rs.getInt(1);
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
    
    
//    public void updatePassword(HttpServletRequest request) throws Exception {
//
//        PreparedStatement stm = Database.instance().prepareStatement(EstudianteCRUD.CMD_ACTUALIZARPass);
//        stm.setInt(1, (int) request.getAttribute("idEstudiante"));
//        stm.setString(2, (String) request.getAttribute("password"));
//    }

    private Database db;
    private static EstudianteDAO instancia;
}
