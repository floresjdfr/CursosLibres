
package logic.matricula;

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
import logic.matricula.Matricula;
import logic.matricula.MatriculaCRUD;
import logic.matricula.Service;


public class MatriculaDAO {

    private MatriculaDAO() {
        db = Database.instance();
    }

    public static MatriculaDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new MatriculaDAO();
        }
        return instancia;
    }

    public Matricula recuperar(int id) {
        Matricula resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(MatriculaCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Matricula(
                                rs.getInt("Curso_Codigo"),
                                rs.getInt("estudiante_idEstudiante")  
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return resultado;
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return resultado;
        }
        return resultado;
    }

    public Service listarMatriculas() {
        Service listaMatriculas = new Service();
        Matricula auxMatricula;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(MatriculaCRUD.CMD_LISTAR)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxMatricula = new Matricula(
                            rs.getInt("Curso_Codigo"),
                            rs.getInt("estudiante_idEstudiante")
                           
                    );

                    listaMatriculas.matriculaAdd(auxMatricula);
                }
            } catch (Exception ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaMatriculas;

    }
    
    
    public void matricular(HttpServletRequest request) throws Exception{
    
     PreparedStatement stm = Database.instance().prepareStatement(MatriculaCRUD.CMD_AGREGAR);
        int aux= Integer.parseInt(request.getParameter("Curso_Codigo"));
        int aux2=Integer.parseInt(request.getParameter("estudiante_idEstudiante"));
       
        stm.setInt(1, aux);
        stm.setInt(2, aux2);
        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("xxxxxxxxxxxxxxxxxxxx");
        }
    
    }
    

    private Database db;
    private static MatriculaDAO instancia;
}
