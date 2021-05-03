/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administradores;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.grupo.GrupoDAO;
import logic.grupo.Service;
import logic.usuario.Usuario;

/**
 *
 * @author flore
 */
@WebServlet(name = "Grupo", urlPatterns = {"/ListarGrupos", "/agregarGrupo", "/editarGrupoShow", "/VerGrupo", "/editarGrupoAction", 
    "/borrarGrupoShow", "/borrarGrupoAction"
})
public class Grupo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "";

        switch (request.getServletPath()) {
            case "/ListarGrupos": {
                URL = listarGrupos(request);
                break;
            }
            case "/agregarGrupo": {
                URL = agregarGrupo(request);
                break;
            }
            case "/editarGrupoShow": {
                URL = editarGrupoShow(request);
                break;
            }
            case "/editarGrupoAction": {
                URL = editarGrupoAction(request);
                break;
            }
            case "/borrarGrupoShow": {
                URL = borrarGrupoShow(request);
                break;
            }
            case "/borrarGrupoAction": {
                URL = borrarGrupoShow(request);
                break;
            }
            case "/VerGrupo": {
                URL = verGrupo(request);
                break;
            }
        }
        request.getRequestDispatcher(URL).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String listarGrupos(HttpServletRequest request) {
        if (validarAdmin(request)) {
            try {
                String idCursoString = request.getParameter("idCurso");
                Service listaGrupos = GrupoDAO.obtenerInstancia().listarGrupos(idCursoString);
                request.setAttribute("listaGrupos", listaGrupos);
                return "/presentation/misc/Grupos.jsp";
            } catch (Exception ex) {
                Logger.getLogger(Grupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "/Cursos";
    }

    private String agregarGrupo(HttpServletRequest request) {

        try {

            if (validarAdmin(request)) {
                logic.grupo.Grupo g = new logic.grupo.Grupo();
                String idCurso = request.getParameter("idCurso");
                g.setCurso_codigo(Integer.parseInt(idCurso));
                g.setProfesor_idPreofesor(Integer.parseInt(request.getParameter("idProfesor")));
                g.setFecha(request.getParameter("fecha"));
                GrupoDAO.obtenerInstancia().crearGrupo(g);
                return "/ListarGrupos?idCurso=" + idCurso;

            }
        } catch (Exception e) {
            return "/Cursos";
        }
        return "/Cursos";
    }

    private String editarGrupoAction(HttpServletRequest request) {
        if (validarAdmin(request)) {
            

            try {
                logic.grupo.Grupo g = new logic.grupo.Grupo();
                g.setCodigo(Integer.parseInt(request.getParameter("idGrupo")));
                g.setCurso_codigo(Integer.parseInt(request.getParameter("idCurso")));
                g.setProfesor_idPreofesor(Integer.parseInt(request.getParameter("idProfesor")));
                g.setFecha(request.getParameter("fecha"));
                GrupoDAO.obtenerInstancia().updateGrupo(g);
            } catch (Exception ex) {
                Logger.getLogger(Grupo.class.getName()).log(Level.SEVERE, null, ex);
                return "/ListarGrupos?idCurso="+ request.getParameter("idCurso");
            }
        }
        return "/ListarGrupos?idCurso="+ request.getParameter("idCurso");
    }

    private String editarGrupoShow(HttpServletRequest request) {
        try {
            if (validarAdmin(request)) {
                String id = request.getParameter("idGrupo");
                int x = Integer.parseInt(id);
                logic.grupo.Grupo profesor = GrupoDAO.obtenerInstancia().recuperar(x);
                request.setAttribute("GrupoED", profesor);
                return "/presentation/usuario/Administrador/Curso/editar_grupo.jsp";
            }
        } catch (Exception e) {

        }
        return "/Cursos";
    }

    private Boolean validarAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario usr = (Usuario) session.getAttribute("usr");
        if (usr != null) {
            if (usr.getClass().getSimpleName().equals("Administrador")) {
                if (usr != null) {
                    if (usr.getClass().getSimpleName().equals("Administrador")) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
    
    private String borrarGrupoShow(HttpServletRequest request){
    
    try {
            if (validarAdmin(request)) {
                String id = request.getParameter("idGrupo");
                int x = Integer.parseInt(id);
                logic.grupo.Grupo profesor = GrupoDAO.obtenerInstancia().recuperar(x);
                request.setAttribute("GrupoEL", profesor);
                return "/presentation/usuario/Administrador/Curso/borrar_grupo.jsp";
            }
        } catch (Exception e) {

        }
        return "/Cursos";
    
    }
    

    public String verGrupo(HttpServletRequest request) {

        if (validarAdmin(request)) {
            try {
                String idGrupo = request.getParameter("idGrupo");
                request.setAttribute("idGrupo", idGrupo);
                return "/presentation/usuario/Administrador/Curso/ver_grupo.jsp";
            } catch (Exception ex) {
                Logger.getLogger(Grupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "/Cursos";

    }

}
