package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
import logic.usuario.profesor.Profesor;


@WebServlet(name = "Administrador", urlPatterns = {"/Cursos", "/Grupos", "/agregarProfesor", "/Estudiantes", "/agregarCurso", "/agregarCursoShow",
"/mostrarProfesor", "/agregarProfesorShow", "/verProfeShow", "/editarProfeShow", "/eliminiarProfeShow"
})
public class Administrador extends HttpServlet {

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

                URL = agregaCurso(request);
                break;
            }
            
            case "/agregarCursoShow": {

                URL = agregaCursoShow(request);
                break;
            }

            case "/agregarProfesor": {

                URL = agregarProfesor(request);
                break;
            }
            
            case "/agregarProfesorShow": {

                URL = displayProfesorAgregar(request);
                break;
            }
            
            case "/mostrarProfesor": {

                URL = displayProfesor(request);
                break;
            }

            
            case "/editarProfeShow": {

                URL = displayProfesorEditar(request);
                break;
            }
            
             case "/verProfeShow": {

                URL = displayProfesorVer(request);
                break;
            }
             
              case "/eliminiarProfeShow": {

                URL = displayProfesorEliminar(request);
                break;
            }
            
//            case "/image": {
//
//                URL = image(request, response);
//                break;
//            }
            default:
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(URL).forward(request, response);

    }

    public String display(HttpServletRequest request) {

        CursoDAO dao = CursoDAO.obtenerInstancia();
        Service listaCursos = dao.listarCursos();

        request.setAttribute("listaCursos", listaCursos);

        return "/presentation/usuario/Administrador/Curso/cursos.jsp";

    }

    private String image(HttpServletRequest request, HttpServletResponse response) {
        String codigo = request.getParameter("nombre");
        Path path = FileSystems.getDefault().getPath("/imagenes", codigo + ".jpg");
        try (OutputStream out = response.getOutputStream()) {
            Files.copy(path, out);
            out.flush();
        } catch (IOException e) {
            // handle exception
        }
        return null;
    }

    public String agregaCurso(HttpServletRequest request) {
        String URL = "index.jsp";
//        final Part imagen;
        try {

            CursoDAO.obtenerInstancia().crear(request);
//            imagen = request.getPart("imagen");
//            imagen.write(request.getParameter("nombre"));
            URL = "/Cursos";

        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                URL = "/agregarCurso";
            }
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return URL;
    }

    public String agregarProfesor(HttpServletRequest request) {
        String URL = "index.jsp";
        int aux=Integer.parseInt(request.getParameter("idProfesor"));
        String n=request.getParameter("nombre");
        String n1=request.getParameter("apellido1");
        String n2=request.getParameter("apellido2");
        String n3=request.getParameter("correo");
        String n4=request.getParameter("telefono");
        String n5=request.getParameter("especialidad");
        String n6=request.getParameter("password");
        
        Profesor p= new Profesor(aux,n,n1,n2,n3,n4,n5,n6);
     
        try {
            ProfesorDAO.obtenerInstancia().crear(p);
            URL = "/mostrarProfesor";

        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                URL = "/presentation/usuario/Administrador/Profesor/agregar_profesor.jsp";
            }
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return URL;

    }

    private Boolean validarUsr(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Usuario usr = (Usuario) session.getAttribute("usr");
        if (usr != null){
            String tipoUsuario = usr.getClass().getSimpleName();
            if (tipoUsuario.equals("Administrador"))
                return true;
            return false;
        }
        return false;
            
    }
    private String agregaCursoShow(HttpServletRequest request) {
        if (validarUsr(request)){
            return "/presentation/usuario/Administrador/Curso/agregar_curso.jsp";
        }
        return "/loginShow";
    }
  public String displayProfesorAgregar(HttpServletRequest request){
    
    return "/presentation/usuario/Administrador/Profesor/agregar_profesor.jsp";
    }
    
     public String displayProfesorVer(HttpServletRequest request){
    
    return "/presentation/usuario/Administrador/Profesor/ver_profesor.jsp";
    }
     
      public String displayProfesorEliminar(HttpServletRequest request){
    
    return "/presentation/usuario/Administrador/Profesor/borrar_profesor.jsp";
    }
      
       public String displayProfesorEditar(HttpServletRequest request){
    
    return "/presentation/usuario/Administrador/Profesor/editar_profesor.jsp";
    }

     public String displayProfesor(HttpServletRequest request) {
        ProfesorDAO dao = ProfesorDAO.obtenerInstancia();
        logic.usuario.profesor.Service listaProfes = dao.listarProfes();
        request.setAttribute("listaProfesores", listaProfes);
         return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
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
