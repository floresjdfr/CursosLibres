/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.logic;

import pro.logic.usuario.Usuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Model {

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    public Model() {
        db = Database.instance();
    }

// public void create(Cliente o) throws Exception{
//        String sql="insert into Cliente (id, nombre) "+
//                "values(?,?)";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, o.getId());
//        stm.setString(2, o.getNombre());        
//        int count=Database.instance().executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente ya existe");
//        }
//    }
//    
//    public usuario read(String id,String pass) throws Exception{
//        String sql="select * from administrador where id=? && pass=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, id);
//        ResultSet rs =  Database.instance().executeQuery(stm);           
//        if (rs.next()) {
//            return from(rs);
//        }
//        else{
//            throw new Exception ("usuario no Existe");
//        }
//    }
//    
    public Usuario recuperar(String id) {
        Usuario resultado = null;

        try (Connection cnx = Database.instance().getConnection();
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
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;

    }

//    public void update(Cliente o) throws Exception{
//        String sql="update Cliente set nombre=? "+
//                "where id=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, o.getNombre());
//        stm.setString(2, o.getId());        
//        int count=Database.instance().executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        }
//    }    
//
//    public void delete(Cliente o) throws Exception{
//        String sql="delete from Cliente where id=?";
//        PreparedStatement stm = Database.instance().prepareStatement(sql);
//        stm.setString(1, o.getId());        
//        int count=Database.instance().executeUpdate(stm);        
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        }
//    }
//    
//    public List<Cliente> findAll(){
//        List<Cliente> r= new ArrayList<>();
//        String sql="select * from Cliente";
//        try {        
//            PreparedStatement stm = Database.instance().prepareStatement(sql);
//            ResultSet rs =  Database.instance().executeQuery(stm);     
//            while (rs.next()) {
//                r.add(from(rs));
//            }
//        } catch (SQLException ex) { }
//        return r;
//    }
//
//    public List<Cliente> findByNombre(Cliente o){
//        List<Cliente> r= new ArrayList<>();
//        String sql="select * from Cliente where nombre like ?";
//        try {        
//            PreparedStatement stm = Database.instance().prepareStatement(sql);
//            stm.setString(1, "%"+o.getNombre()+"%");   
//            ResultSet rs =  Database.instance().executeQuery(stm); 
//            while (rs.next()) {
//                r.add(from(rs));
//            }
//        } catch (SQLException ex) { }
//        return r;
//    }
//    
//    public Cliente from (ResultSet rs){
//        try {
//            Cliente r= new Cliente();
//            r.setId(rs.getString("id"));
//            r.setNombre(rs.getString("nombre"));
//            return r;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
//
//    public  void close(){
//    }
    private Usuario from(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class UsuarioCRUD {

        protected static final String CMD_LISTAR
                = "SELECT nombre, nombre_Completo, clave, ultimoAcceso FROM usuario "
                + "ORDER BY nombre_Completo; ";
        protected static final String CMD_AGREGAR
                = "INSERT INTO usuario (nombre, nombre_Completo, clave, ultimoAcceso) "
                + "VALUES (?, ?, ?, ?); ";

        protected static final String CMD_RECUPERAR
                = "SELECT cedula, nombre, password FROM usuario "
                + "WHERE cedula = ?; ";
        protected static final String CMD_ACTUALIZAR
                = "UPDATE usuario SET nombre_completo = ?, clave = ?, ultimoAcceso = ? "
                + "WHERE nombre = ?; ";
        protected static final String CMD_ELIMINAR
                = "DELETE FROM usuario "
                + "WHERE nombre = ?; ";
    }

    private Database db;
    private static Model uniqueInstance = null;

}
