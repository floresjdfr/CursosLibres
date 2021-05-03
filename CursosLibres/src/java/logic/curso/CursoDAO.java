package logic.curso;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import logic.Database;

public class CursoDAO {

    private CursoDAO() {
        db = Database.instance();
    }
    
    public List<CursoActual> listarCursosActuales(int idEstudiante) throws SQLException{
        ArrayList<CursoActual> listaCursos = new ArrayList<>();
        
        try(PreparedStatement stm = db.prepareStatement(CursoCRUD.CMD_LISTAR_CURSOS_ACTUALES)){
            
            stm.clearParameters();
            stm.setInt(1, idEstudiante);
            
            try(ResultSet result = stm.executeQuery()){
                while(result.next()){
                    String nombre = result.getString(1);
                    int codigoGrupo = result.getInt(2);
                    String nombreProfesor = result.getString(3);
                    String apellidoProfesor = result.getString(4);
                    String horario = result.getString(5);
                    int nota = result.getInt(6);
                    String notaString = nota != 0 ? String.valueOf(nota) : "N/A";
                    
                    CursoActual cursoActual = new CursoActual(nombre, codigoGrupo,
                    nombreProfesor, apellidoProfesor, horario, notaString);
                    
                    listaCursos.add(cursoActual);
                }
                return listaCursos;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }      
        
    }
    
    public Service listarCursosProfesor(int idProfesor) throws SQLException{
        Service listaCursos = new Service();
        
        try(PreparedStatement stm = db.prepareStatement(CursoCRUD.CMD_LISTAR_CURSOS_PROFESOR)){
            
            stm.clearParameters();
            stm.setInt(1, idProfesor);
            
            try(ResultSet result = stm.executeQuery()){
                while(result.next()){
                    int codigo = result.getInt(1);
                    String nombre = result.getString(2);
                    String tematica = result.getString(3);
                    String costo = result.getString(4);
                    int oferta = result.getInt(5);
                    
                    Curso curso = new Curso(codigo, nombre,
                    tematica, costo, oferta);
                    
                    listaCursos.cursosAdd(curso);
                }
                return listaCursos;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            return listaCursos;
        }      
        
    }

    public static CursoDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new CursoDAO();
        }
        return instancia;
    }

    public void crear(Curso c) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(CursoCRUD.CMD_AGREGAR);

        

        stm.setString(1, c.getNombre());
        stm.setString(2, c.getTematica());
        stm.setString(3, c.getCosto());
        stm.setInt(4, c.getOferta());

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
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
                                rs.getString("costo"),
                                rs.getInt("oferta")
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
    
    public Service buscarPorNombre(String nombre){
        try {
            Service service = new Service();
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(CursoCRUD.CMD_BUSCAR_NOMBRE);
            stm.clearParameters();
            stm.setString(1, "%"+nombre+"%");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                int codigo = result.getInt("codigo");
                String nombreCurso = result.getString("nombre");
                String costo = result.getString("costo");
                
                Curso curso = new Curso();
                curso.setCodigo(codigo);
                curso.setNombre(nombreCurso);
                curso.setCosto(costo);
                
                service.cursos.add(curso);
            }
            return service;
        } catch (SQLException | URISyntaxException | IOException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Service listarCursos() {
        Service listaCursos = new Service();
        Curso auxCurso;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(CursoCRUD.CMD_LISTAR)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxCurso = new Curso(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("tematica"),
                            rs.getString("costo"),
                            rs.getInt("oferta")
                    );

                    listaCursos.cursosAdd(auxCurso);
                }
            } catch (Exception ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCursos;

    }
    
    public Service listarCursosEnOferta() {
        Service listaCursos = new Service();
        Curso auxCurso;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(CursoCRUD.CMD_LISTAR)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxCurso = new Curso(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("tematica"),
                            rs.getString("costo"),
                            rs.getInt("oferta")
                    );
                    if (auxCurso.getOferta() == 1)
                        listaCursos.cursosAdd(auxCurso);
                }
            } catch (Exception ex) {
                Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCursos;

    }

    public void eliminar(int p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(CursoCRUD.CMD_ELIMINAR);
        stm.setInt(1, p);

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }

    public void actualizar(Curso p) throws Exception {


        PreparedStatement stm = Database.instance().prepareStatement(CursoCRUD.CMD_ACTUALIZAR);
      
        stm.setString(1, p.getNombre());
        stm.setString(2, p.getTematica());
        stm.setString(3, p.getCosto());
        stm.setInt(4, p.getOferta());
        stm.setInt(5, p.getCodigo());
        
       

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }

    private Database db;
    private static CursoDAO instancia;
}
