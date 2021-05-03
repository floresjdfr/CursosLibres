/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administradores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.usuario.Usuario;
import logic.usuario.profesor.ProfesorDAO;
import logic.usuario.profesor.Service;

/**
 *
 * @author flore
 */
@WebServlet(name = "Profesores", urlPatterns = {
    "/agregarProfesor",
    "/mostrarProfesor",
    "/agregarProfesorShow",
    "/verProfeShow",
    "/editarProfeShow",
    "/eliminarProfeShow",
    "/editarProfeAction",
    "/eliminarProfeAction",
    "/BuscarProfeAction"
})
public class Profesor extends HttpServlet {

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
            case "/agregarProfesor": {
                URL = agregarProfesor(request, response);
                break;
            }
            case "/mostrarProfesor": {
                URL = displayProfesor(request);
                break;
            }
            case "/agregarProfesorShow": {
                URL = displayProfesorAgregar(request);
                break;
            }
            case "/verProfeShow": {
                URL = displayProfesorVer(request);
                break;
            }
            case "/editarProfeShow": {
                URL = displayProfesorEditar(request);
                break;
            }
            case "/eliminarProfeShow": {
                URL = displayProfesorEliminar(request);
                break;
            }
            case "/editarProfeAction": {
                URL = editarProfeAction(request, response);
                break;
            }
            case "/eliminarProfeAction": {
                URL = eliminarProfeAction(request, response);
                break;
            }
            case "/BuscarProfeAction": {
                URL = buscarProfeAction(request);
                break;
            }
        }

        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
        }
    }

    private String buscarProfeAction(HttpServletRequest request) {

        ProfesorDAO dao = ProfesorDAO.obtenerInstancia();
        String nombreProfe = request.getParameter("nombreProfe");
        Service listaProfe = dao.buscarPorNombre(nombreProfe);

        request.setAttribute("listaProfesores", listaProfe);
        request.setAttribute("nombreProfe", nombreProfe);

        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
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

    private String editarProfeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (validarUsr(request)) {
            String cedulaString = request.getParameter("cedula");
            int cedula = Integer.parseInt(cedulaString);
            String nombre = request.getParameter("nombre");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String especialidad = request.getParameter("especialidad");
            String password = request.getParameter("password");

            logic.usuario.profesor.Profesor p = new logic.usuario.profesor.Profesor(cedula, nombre, apellido1, apellido2, correo, telefono, especialidad, password);

            try {
                ProfesorDAO.obtenerInstancia().actualizar(p);
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            } catch (Exception ex) {
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            }
        }
        return null;
    }

    public String displayProfesorEliminar(HttpServletRequest request) {

        if (validarUsr(request)) {

            String idProfesorString = request.getParameter("idProfesor");
            int profesorID = Integer.parseInt(idProfesorString);
            logic.usuario.profesor.Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(profesorID);
            request.setAttribute("Profemostrar", profesor);
            return "/presentation/usuario/Administrador/Profesor/borrar_profesor.jsp";
        }
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }

    public String displayProfesorEditar(HttpServletRequest request) {

        if (validarUsr(request)) {

            String idProfesorString = request.getParameter("idProfesor");
            int profesorID = Integer.parseInt(idProfesorString);
            logic.usuario.profesor.Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(profesorID);
            request.setAttribute("profesor_editar", profesor);
            return "/presentation/usuario/Administrador/Profesor/editar_profesor.jsp";
        }
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }

    public String displayProfesorVer(HttpServletRequest request) {
        if (validarUsr(request)) {
            String idProfesor = request.getParameter("idProfesor");
            int cedula = Integer.parseInt(idProfesor);
            logic.usuario.profesor.Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(cedula);
            request.setAttribute("profesor", profesor);
            return "/presentation/usuario/Administrador/Profesor/ver_profesor.jsp";
        }
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }

    public String displayProfesorAgregar(HttpServletRequest request) {
        return "/presentation/usuario/Administrador/Profesor/agregar_profesor.jsp";
    }

    public String displayProfesor(HttpServletRequest request) {
        ProfesorDAO dao = ProfesorDAO.obtenerInstancia();
        logic.usuario.profesor.Service listaProfes = dao.listarProfes();
        request.setAttribute("listaProfesores", listaProfes);
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
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

    public String agregarProfesor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String URL = "index.jsp";
        int aux = Integer.parseInt(request.getParameter("idProfesor"));
        String n = request.getParameter("nombre");
        String n1 = request.getParameter("apellido1");
        String n2 = request.getParameter("apellido2");
        String n3 = request.getParameter("correo");
        String n4 = request.getParameter("telefono");
        String n5 = request.getParameter("especialidad");
        String n6 = request.getParameter("password");

        logic.usuario.profesor.Profesor p = new logic.usuario.profesor.Profesor(aux, n, n1, n2, n3, n4, n5, n6);

        try {
            ProfesorDAO.obtenerInstancia().crear(p);
            response.sendRedirect("/CursosLibres/mostrarProfesor");

        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            }
        }
        return null;
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
