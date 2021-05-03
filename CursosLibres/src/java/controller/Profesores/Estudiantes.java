/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Profesores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.grupo.GrupoDAO;
import logic.usuario.Usuario;
import logic.usuario.estudiante.Estudiante;
import logic.usuario.estudiante.EstudianteDAO;

/**
 *
 * @author flore
 */
@WebServlet(name = "Estudiantes", urlPatterns = {
    "/Profesor/EstudiantesShow", 
    "/Profesor/CalificarEstudianteShow", 
    "/Profesor/CalificarEstudianteAction"
})
public class Estudiantes extends HttpServlet {

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
        String URL = "";
        switch (request.getServletPath()) {
            case"/Profesor/EstudiantesShow":{
                URL = estudiatesShow(request);
                break;
            }
            case "/Profesor/CalificarEstudianteShow":{
                URL = calificarEstudiateShow(request);
                break;
            }
            case "/Profesor/CalificarEstudianteAction":{
                URL = calificarEstudiateAction(request);
                break;
            }
            

        }
        request.getRequestDispatcher(URL).forward(request, response);
    }
    
    Boolean verificar(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usr");
        return usuario.getClass().getSimpleName().equals("Profesor");
    }

    private String estudiatesShow(HttpServletRequest request) {
        try {
            if (verificar(request)) {
                try {
                    logic.usuario.estudiante.Service service;
                    String idGrupo = request.getParameter("idGrupo");
                    int idGrupoint = Integer.parseInt(idGrupo);
                    service = GrupoDAO.obtenerInstancia().listarEstudiatesGrupo(idGrupoint);
                    if (service != null) {
                        request.setAttribute("listaEstudiantes", service);
                        request.setAttribute("idGrupo", idGrupo);
                        return "/presentation/usuario/Profesor/estudiantesShow.jsp";
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
    
    private String calificarEstudiateShow(HttpServletRequest request) {
        try {
            if (verificar(request)) {
                try {
                    Estudiante estudiante;
                    String idEstudianteString = request.getParameter("idEstudiante");
                    int idEstudiante = Integer.valueOf(idEstudianteString);
                    String idGrupo = request.getParameter("idGrupo");
                    
                    estudiante = EstudianteDAO.obtenerInstancia().recuperar(idEstudiante);   
                    
                    int nota = EstudianteDAO.obtenerInstancia().recuperarNota(estudiante.getCedula());
                    estudiante.setNota(nota);
                    
                    if (estudiante != null) {
                        request.setAttribute("estudiante", estudiante);
                        request.setAttribute("idGrupo", idGrupo);
                        return "/presentation/usuario/Profesor/calificarEstudianteShow.jsp";
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

        
    private String calificarEstudiateAction(HttpServletRequest request) {
        try {
            if (verificar(request)) {
                try {
                    
                    String idEstudianteString = request.getParameter("idEstudiante");
                    int idEstudiante = Integer.valueOf(idEstudianteString);
                    String idGrupoString = request.getParameter("idGrupo");
                    int IdGrupo = Integer.valueOf(idGrupoString);
                    String notaString = request.getParameter("nota");
                    int nota = Integer.valueOf(notaString);
                    
                    if (idEstudiante != 0 && IdGrupo != 0 && nota != 0){
                        EstudianteDAO.obtenerInstancia().actualizarNota(idEstudiante, IdGrupo, nota);
                        return "/Profesor/EstudiantesShow?idGrupo" + idGrupoString;
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
