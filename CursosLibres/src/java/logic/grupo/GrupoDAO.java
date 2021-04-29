package logic.grupo;

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

public class GrupoDAO {

    private GrupoDAO() {
        db = Database.instance();
    }

    public static GrupoDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new GrupoDAO();
        }
        return instancia;
    }

    public Grupo recuperar(int id) {
        Grupo resultado = null;
        try {
            try (Connection cnx = db.getConnection();
                    PreparedStatement stm = cnx.prepareStatement(GrupoCRUD.CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        resultado = new Grupo(
                                rs.getInt("codigo"),
                                rs.getInt("Curso_codigo"),
                                rs.getInt("profesor_idProfesor"),
                                rs.getString("fecha")
                        );
                    }
                }
            } catch (URISyntaxException | IOException ex) {
                Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return resultado;
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return resultado;
        }
        return resultado;
    }

    public Service listarGrupos(String codigoCurso) throws IOException, URISyntaxException, SQLException {

        Service listaGrupos = new Service();
        int codigoCursoInt = Integer.parseInt(codigoCurso);
        Connection connection = db.getConnection();
        PreparedStatement stm = connection.prepareStatement(GrupoCRUD.CMD_Listar_CODIGO);
        stm.setInt(1, codigoCursoInt);
        ResultSet result = stm.executeQuery();
        while (result.next()) {
            Grupo aux = new Grupo(result.getInt("codigo"), result.getInt("Curso_codigo"), result.getInt("profesor_idProfesor"), result.getString("fecha"));
            listaGrupos.gruposAdd(aux);
    public Service listarGrupos(String codigoCurso) {
        try {
            Service listaGrupos = new Service();
            int codigoCursoInt = Integer.parseInt(codigoCurso);
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(GrupoCRUD.CMD_Listar_CODIGO);
            stm.setInt(1, codigoCursoInt);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                Grupo aux = new Grupo(result.getInt("codigo"), result.getInt("Curso_codigo"), result.getInt("profesor_idProfesor"), result.getString("fecha"));
                listaGrupos.gruposAdd(aux);
            }
            return listaGrupos;
        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaGrupos;
    }

    public Service listarGrupos() {

        Service listaGrupos = new Service();
        Grupo auxGrupo;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(GrupoCRUD.CMD_LISTAR)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxGrupo = new Grupo(
                            rs.getInt("codigo"),
                            rs.getInt("profeid"),
                            rs.getInt("cursoid"),
                            rs.getString("fecha")
                    );

                    listaGrupos.gruposAdd(auxGrupo);
                }
            } catch (Exception ex) {
                Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGrupos;

    }

    public void matricular(HttpServletRequest request) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(GrupoCRUD.CMD_AGREGAREG);
        stm.setInt(1, (int) request.getAttribute("grupo_codigo"));
        stm.setInt(2, (int) request.getAttribute("grupo_Curso_codigo"));
        stm.setInt(3, (int) request.getAttribute("grupo_profesor_idProfesor"));
        stm.setInt(4, (int) request.getAttribute("estudiante_idEstudiante"));

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("xxxxxxxxxxxxxxxxxxxx");
        }
    }

    public Service listaGruposProfe(HttpServletRequest request) {
        Service listaGrupos = new Service();
        Grupo auxGrupo;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(GrupoCRUD.CMD_RECUPERARPG)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxGrupo = new Grupo(
                            rs.getInt("grupo_codigo"),
                            rs.getInt("grupo_Curso_codigo")
                    );

                    listaGrupos.gruposAdd(auxGrupo);
                }
            } catch (Exception ex) {
                Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaGrupos;
    }

    public void updateGrupo(Grupo g) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(GrupoCRUD.CMD_ACTUALIZARG);
        stm.setInt(1, g.getCurso_codigo());
        stm.setInt(2, g.getProfesor_idPreofesor());
        stm.setString(3, g.getFecha());
        stm.setInt(4, g.getCodigo());

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("xxxxxxxxxxxxxxxxxxxx");
        }
    }

    public void crearGrupo(Grupo g) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(GrupoCRUD.CMD_AGREGAR);
//        stm.setInt(1, g.getCodigo());
//        stm.setInt(2, g.getCurso_codigo());
//        stm.setInt(3, g.getProfesor_idPreofesor());
//        stm.setString(4, g.getFecha());
        stm.setInt(1, g.getCurso_codigo());
        stm.setInt(2, g.getProfesor_idPreofesor());
        stm.setString(3, g.getFecha());
        

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("xxxxxxxxxxxxxxxxxxxx");
        }
    }

>>>>>>> Stashed changes
    private Database db;
    private static GrupoDAO instancia;
}
