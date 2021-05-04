/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administradores;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import logic.curso.CursoDAO;
import logic.curso.Service;
import logic.usuario.Usuario;
import logic.usuario.profesor.ProfesorDAO;

/**
 *
 * @author flore
 */
@WebServlet(name = "Curso", urlPatterns = {
    "/Cursos",
    "/agregarCurso",
    "/agregarCursoShow",
    "/editarCursoShow", 
    "/verCursoShow", 
    "/eliminarCursoAction", 
    "/editarCursoAction",
    "/image"

})
@MultipartConfig(location = "C:/images")
public class Curso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getServletPath();
        String URL = "";
        switch (opcion) {
            case "/Cursos": {
                URL = display(request);
                break;
            }
            case "/agregarCurso": {

                URL = agregaCurso(request, response);
                break;
            }
            case "/agregarCursoShow": {

                URL = agregaCursoShow(request);
                break;
            }
            case "/editarCursoShow": {
                URL = displayEditarCurso(request);
                break;
            }
            case "/verCursoShow": {
                URL = eliminarProfeAction(request, response);
                break;
            }
            case "/editarCursoAction": {
                URL = editarCursoAction(request, response);
                break;
            }
            case "/image": {
                URL = image(request, response);
                break;
            }
        }
        
        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
        }

    }
    
    private String image(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre = request.getParameter("nombre");
        Path path = FileSystems.getDefault().getPath("C:/images", nombre);
        try (OutputStream out = response.getOutputStream()) {
            Files.copy(path, out);
            out.flush();
        } catch (IOException e) {
            return e.getMessage();
        }
        return null;
    }
    
    public String display(HttpServletRequest request) {

        CursoDAO dao = CursoDAO.obtenerInstancia();
        Service listaCursos = dao.listarCursos();
        request.setAttribute("listaCursos", listaCursos);
        return "/presentation/usuario/Administrador/Curso/cursos.jsp";
    }
    
    private String editarCursoAction(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (validarUsr(request)) {

            String idCurso = request.getParameter("idCurso");
            int codigo = Integer.parseInt(idCurso);
            String nombre = request.getParameter("nombre");
            String tematica = request.getParameter("tematica");
            String costo = request.getParameter("costo");
            String ofe = request.getParameter("oferta");
            int oferta = Integer.parseInt(ofe);

            logic.curso.Curso c = new logic.curso.Curso(codigo, nombre, tematica, costo, oferta);

            try {
                CursoDAO dao = CursoDAO.obtenerInstancia();
                dao.actualizar(c);
                response.sendRedirect("/CursosLibres/Cursos");
                
            } catch (Exception ex) {
                response.sendRedirect("/CursosLibres/Cursos");
            }
        }
        return null;
    }
    private String eliminarProfeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (validarUsr(request)) {
            String p = (String) request.getParameter("idProfesor");
            int cedula = Integer.parseInt(p);
            try {
                ProfesorDAO.obtenerInstancia().eliminar(cedula);
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            } catch (Exception ex) {
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            }
            
        }
        return null;
    }
    
    public String displayEditarCurso(HttpServletRequest request) {

        if (validarUsr(request)) {

            String CodigoCurso = request.getParameter("idCurso");
            int CursoID = Integer.parseInt(CodigoCurso);
            logic.curso.Curso c = CursoDAO.obtenerInstancia().recuperar(CursoID);
            request.setAttribute("curso_editar", c);
            return "/presentation/usuario/Administrador/Curso/editar_curso.jsp";
        }
        return "/Cursos";

    }

    public String agregaCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final Part imagen;
        try {
            String nombre = request.getParameter("nombre");
            String tematica = request.getParameter("tematica");
            String costo = request.getParameter("costo");
            String ofe = request.getParameter("oferta");
            int oferta = Integer.parseInt(ofe);
            logic.curso.Curso c = new logic.curso.Curso(nombre, tematica, costo, oferta);
            CursoDAO.obtenerInstancia().crear(c);

            imagen = request.getPart("imagen");
            imagen.write(request.getParameter("nombre"));

            response.sendRedirect("/CursosLibres/Cursos");
        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                response.sendRedirect("/CursosLibres/agregarCurso");
            }
        }
        return null;
    }

    private String agregaCursoShow(HttpServletRequest request) {
        if (validarUsr(request)) {
            return "/presentation/usuario/Administrador/Curso/agregar_curso.jsp";
        }
        return "/loginShow";
    }

    private Boolean validarUsr(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Usuario usr = (Usuario) session.getAttribute("usr");
        if (usr != null) {
            String tipoUsuario = usr.getClass().getSimpleName();
            if (tipoUsuario.equals("Administrador")) {
                return true;
            }
            return false;
        }
        return false;

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

}
