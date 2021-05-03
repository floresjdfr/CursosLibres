/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Profesores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.curso.CursoDAO;
import logic.curso.Service;
import logic.grupo.GrupoDAO;
import logic.usuario.Usuario;
import logic.usuario.estudiante.Estudiante;
import logic.usuario.estudiante.EstudianteDAO;
import logic.usuario.profesor.Profesor;

/**
 *
 * @author flore
 */
@WebServlet(name = "CursosGrupos", urlPatterns = {"/Profesor/CursosShow", "/Profesor/GruposShow",
   
})
public class CursosGrupos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            case "/Profesor/CursosShow": {
                URL = cursosShow(request);
                break;
            }
            case "/Profesor/GruposShow": {
                URL = gruposShow(request);
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

    private String cursosShow(HttpServletRequest request) {
        try {
            if (verificar(request)) {
                try {
                    Service service;
                    Profesor profesor = (Profesor) request.getSession().getAttribute("usr");
                    int idProfesor = profesor.getCedula();
                    service = CursoDAO.obtenerInstancia().listarCursosProfesor(idProfesor);
                    if (service != null) {
                        request.setAttribute("listaCursos", service);
                        return "/presentation/usuario/Profesor/cursosShow.jsp";
                    }
                    throw new Exception("Error al obtener de la base de datos");
                } catch (Exception e) {
                    e.printStackTrace();
                    return "/CursoDisplay";
                }
            }
            throw new Exception("Debe iniciar sesion como profesor");

        } catch (Exception e) {
            e.printStackTrace();
            return "/CursoDisplay";
        }
    }
    
    Boolean verificar(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usr");
        return usuario.getClass().getSimpleName().equals("Profesor");
    }

    private String gruposShow(HttpServletRequest request) {
        try {
            if (verificar(request)) {
                try {
                    logic.grupo.Service service;
                    String idCurso = (String) request.getParameter("idCurso");
                    
                    service = GrupoDAO.obtenerInstancia().listarGrupos(idCurso);
                    
                    if (service != null) {
                        request.setAttribute("listaGrupos", service);
                        return "/presentation/usuario/Profesor/gruposShow.jsp";
                    }
                    throw new Exception("Error al obtener de la base de datos");
                } catch (Exception e) {
                    e.printStackTrace();
                    return "/CursoDisplay";
                }
            }
            throw new Exception("Debe iniciar sesion como profesor");

        } catch (Exception e) {
            e.printStackTrace();
            return "/loginShow";
        }
    }

    
}
