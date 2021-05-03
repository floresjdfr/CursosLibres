/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Estudiantes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.usuario.Usuario;
import logic.usuario.estudiante.EstudianteDAO;
import logic.usuario.estudiante.Service;

/**
 *
 * @author flore
 */
@WebServlet(name = "AdministrarCuenta", urlPatterns = {"/AdministrarCuenta", "/signup", "/updateEstudiante"})
public class AdministrarCuenta extends HttpServlet {

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
            case "/signup": {
                URL = Singup(request);
                break;
            }
            case "/updateEstudiante": {
                URL = updatePassword(request);
                break;
            }
            default:
                break;
        }
        
        request.getRequestDispatcher(URL).forward(request, response);
    }
    
    public String Singup(HttpServletRequest request) {
        String URL = "index.jsp";
        try {
            
            
            EstudianteDAO.obtenerInstancia().crear(request);
            URL = muesttatemporal(request);
            
        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                URL = "/presentation/login/registrar.jsp";
            }
        }
        return URL;
    }
    
    public String updatePassword(HttpServletRequest request) {
        
         if (validarUsr(request)) {
            String cedulaString = request.getParameter("idEstudiante");
            int cedula = Integer.parseInt(cedulaString);
//            String nombre = request.getParameter("nombre");
//            String apellido1 = request.getParameter("apellido1");
//            String apellido2 = request.getParameter("apellido2");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String dirrecion = request.getParameter("dirrecion");
            String password = request.getParameter("password");

            logic.usuario.estudiante.Estudiante p = new  logic.usuario.estudiante.Estudiante(cedula, "", "", "", correo, telefono, dirrecion, password);

            try {
                EstudianteDAO.obtenerInstancia().actualizar(p);
                Usuario DBuser;
                HttpSession session = request.getSession(true);
                DBuser = EstudianteDAO.obtenerInstancia().recuperar(cedula);
                session.setAttribute("usr", DBuser);
                return "/MatricularShow";
                
            } catch (Exception ex) {
                return "/editarInfoShow";
            }
        }
        return "/CursoDisplay";
        
        
//        String URL = "index.jsp";
//        try {
//            EstudianteDAO.obtenerInstancia().crear(request);
//
//        } catch (Exception ex) {
//            if (ex.getMessage().equals("duplicado")) {
//                URL = "/presentation/usuario/Estudiante/Signin.jsp";
//            }
//            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return URL;
    }

    public String muesttatemporal(HttpServletRequest request) {
        
        int id = Integer.parseInt(request.getParameter("idEstudiante"));
        Service srv = new Service();

        logic.usuario.estudiante.Estudiante aux = EstudianteDAO.obtenerInstancia().recuperar(id);
        srv.estudiantesAdd(aux);
        request.setAttribute("estudiante", srv);
        return "/presentation/login/informacion_registro.jsp";
    }
    
    
     private Boolean validarUsr(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Usuario usr = (Usuario) session.getAttribute("usr");
        if (usr != null) {
            String tipoUsuario = usr.getClass().getSimpleName();
            return tipoUsuario.equals("Estudiante");
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
