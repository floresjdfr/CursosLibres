package logic.usuario.profesor;

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



public class ProfesorDAO {
    
    
    private ProfesorDAO(){
        db = Database.instance();
    }
    
    public static ProfesorDAO obtenerInstancia(){
        if (instancia == null)
            instancia = new ProfesorDAO();
        return instancia;
    }
       
    
    public void crear(Profesor p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(ProfesorCRUD.CMD_AGREGAR);
        //int aux=Integer.parseInt(request.getParameter("idProfesor"));
        
        stm.setInt(1, p.getCedula());
        stm.setString(2, p.getNombre());
        stm.setString(3, p.getApellido1());
        stm.setString(4, p.getApellido2());
        stm.setString(5, p.getCorreo());
        stm.setString(6, p.getNumero());
        stm.setString(7, p.getEspecialidad());
        stm.setString(8, p.getPassword());
        
//        stm.setInt(1, p.getCedula());
//        stm.setString(2, (String) request.getParameter("nombre"));
//        stm.setString(3, (String) request.getParameter("apellido1"));
//        stm.setString(4, (String) request.getParameter("apellido2"));
//        stm.setString(5, (String) request.getParameter("correo"));
//        stm.setString(6, (String) request.getParameter("telefono"));
//        stm.setString(7, (String) request.getParameter("especiaidad"));
//        stm.setString(8, (String) request.getParameter("password"));
//        
//        System.out.print(request.getParameter("nombre"));
//        System.out.print(request.getParameter("apellido1"));
//        System.out.print(request.getParameter("apellido2"));
//        System.out.print(request.getParameter("correo"));
//        System.out.print(request.getParameter("telefono"));
//        System.out.print(request.getParameter("especialidad"));
//        System.out.print(request.getParameter("password"));
//        
       
        int count = Database.instance().executeUpdate(stm);
//        if (count == 0) {
//            throw new Exception("duplicado");
//        }
    }
    
    
    
    
    public Profesor recuperar(int id) {
        Profesor resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(ProfesorCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Profesor(
                                 rs.getInt("idProfesor"),
                                rs.getString("nombre"),
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("correo"),
                                rs.getString("telefono"),
                                rs.getString("especialidad"),
                                rs.getString("password")
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
                return resultado;
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return resultado;
        }
        return resultado;
    }
    private Database db;
    private static ProfesorDAO instancia;
}