package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.grupo.GrupoDAO;
import logic.usuario.profesor.ProfesorDAO;
import logic.usuario.profesor.Service;

@WebServlet(name = "Profesor", urlPatterns = {"/notas", "/BuscarProfeAction"})
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
            case "/notas": {
                URL = notas(request);
                break;
            }
            case "/grupos": {
              
                URL = displayGrupos(request);
                break;
            }
            
             case "/BuscarProfeAction": {
              
                URL = buscarProfeAction(request);
                break;
            }
            default:
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(URL).forward(request, response);

    }

    
    public String notas(HttpServletRequest request){
    
        return ".";
    } 
    
    
    public String displayGrupos(HttpServletRequest request) {

        GrupoDAO dao = GrupoDAO.obtenerInstancia();
        logic.grupo.Service listaGrupos = dao.listaGruposProfe(request);
        request.setAttribute("listaGrupos", listaGrupos);
        return "/presentation/usuario/Profesor/Grupos.jsp";

    }
    
   private String buscarProfeAction(HttpServletRequest request) {
        
        ProfesorDAO dao = ProfesorDAO.obtenerInstancia();
        String nombreProfe = request.getParameter("nombreProfe");
        Service listaProfe = dao.buscarPorNombre(nombreProfe);
                
        request.setAttribute("listaProfesores", listaProfe);
        request.setAttribute("nombreProfe", nombreProfe);

        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }
    
    
    
    
    
    

//    public String Singin(HttpServletRequest request) {
//
//        return "/presentation/usuario/Estudiante/Signin.jsp";
//    }
//
//    public String Singup(HttpServletRequest request) {
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
//    }

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
