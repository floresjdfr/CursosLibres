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

    private ProfesorDAO() {
        db = Database.instance();
    }

    public static ProfesorDAO obtenerInstancia() {
        if (instancia == null) {
            instancia = new ProfesorDAO();
        }
        return instancia;
    }

    public void crear(Profesor p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(ProfesorCRUD.CMD_AGREGAR);

        stm.setInt(1, p.getCedula());
        stm.setString(2, p.getNombre());
        stm.setString(3, p.getApellido1());
        stm.setString(4, p.getApellido2());
        stm.setString(5, p.getCorreo());
        stm.setString(6, p.getNumero());
        stm.setString(7, p.getEspecialidad());
        stm.setString(8, p.getPassword());

        
        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }

    public void actualizar(Profesor p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(ProfesorCRUD.CMD_ACTUALIZAR);

        stm.setString(1, p.getNombre());
        stm.setString(2, p.getApellido1());
        stm.setString(3, p.getApellido2());
        stm.setString(4, p.getCorreo());
        stm.setString(5, p.getNumero());
        stm.setString(6, p.getEspecialidad());
        stm.setString(7, p.getPassword());
        stm.setInt(8, p.getCedula());

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
    }

    public void eliminar(int p) throws Exception {

        PreparedStatement stm = Database.instance().prepareStatement(ProfesorCRUD.CMD_ELIMINAR);

        stm.setInt(1, p);

        int count = Database.instance().executeUpdate(stm);
        if (count == 0) {
            throw new Exception("duplicado");
        }
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

    public Service listarProfes() {
        Service listaProfes = new Service();
        Profesor auxCurso;
        try (Connection cnx = db.getConnection(); PreparedStatement stm = cnx.prepareStatement(ProfesorCRUD.CMD_LISTAR)) {

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    auxCurso = new Profesor(
                            rs.getInt("idProfesor"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("apellido2"),
                            rs.getString("correo"),
                            rs.getString("telefono"),
                            rs.getString("especialidad"),
                            rs.getString("password")
                    );

                    listaProfes.profesoresAdd(auxCurso);
                }
            } catch (Exception ex) {
                Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException | IOException | SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProfes;

    }

    public Service buscarPorNombre(String nombre) {
        try {
            Service service = new Service();
            Connection connection = db.getConnection();
            PreparedStatement stm = connection.prepareStatement(ProfesorCRUD.CMD_BUSCAR_NOMBRE);
            stm.clearParameters();
            stm.setString(1, "%" + nombre + "%");
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                int codigo = result.getInt("idProfesor");
                String nombreProfe = result.getString("nombre");
                String apellido1 = result.getString("apellido1");
                String apellido2 = result.getString("apellido2");
                String correo = result.getString("correo");
                String telefono = result.getString("telefono");
                String especialidad = result.getString("especialidad");
                String password = result.getString("password");

                Profesor pr = new Profesor();
                pr.setNombre(nombreProfe);
                pr.setApellido1(apellido1);
                pr.setApellido2(apellido2);
                pr.setCorreo(correo);
                pr.setNumero(telefono);
                pr.setEspecialidad(especialidad);
                pr.setPassword(password);
                pr.setCedula(codigo);
                service.profesores.add(pr);
            }
            return service;
        } catch (SQLException | URISyntaxException | IOException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Database db;
    private static ProfesorDAO instancia;
}
