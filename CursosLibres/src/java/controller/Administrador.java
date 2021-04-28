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
import logic.curso.Curso;
import logic.curso.Service;
import logic.usuario.Usuario;
import logic.usuario.profesor.ProfesorDAO;
import logic.usuario.profesor.Profesor;

@WebServlet(name = "Administrador", urlPatterns = {"/Cursos", "/Grupos", "/agregarProfesor", "/Estudiantes", "/agregarCurso", "/agregarCursoShow",
    "/mostrarProfesor", "/agregarProfesorShow", "/verProfeShow", "/editarProfeShow", "/eliminarProfeShow", "/editarProfeAction", "/eliminarProfeAction",
        "/editarCursoShow", "/eliminarCursoShow", "/verCursoShow", "/eliminarCursoAction", "/editarCursoAction"
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

         case "/eliminarProfeShow": {

            URL = displayProfesorEliminar(request);
            break;
         }

            case "/editarProfeAction": {
                URL = editarProfeAction(request);
                break;
            }
            case "/eliminarProfeAction": {
                URL = eliminarProfeAction(request);
                break;
            }
            
            
            case "/eliminarCursoShow": {
                URL = displayEliminarCurso(request);
                break;
            }
            
            case "/editarCursoShow": {
                URL = displayEditarCurso(request);
                break;
            }
            
            case "/verCursoShow": {
                URL = eliminarProfeAction(request);
                break;
            }
            
            case "/eliminarCursoAction": {
                URL = EliminarCursoAction(request);
                break;
            }

            
             case "/editarCursoAction": {
                URL = editarCursoAction(request);
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
      int aux = Integer.parseInt(request.getParameter("idProfesor"));
      String n = request.getParameter("nombre");
      String n1 = request.getParameter("apellido1");
      String n2 = request.getParameter("apellido2");
      String n3 = request.getParameter("correo");
      String n4 = request.getParameter("telefono");
      String n5 = request.getParameter("especialidad");
      String n6 = request.getParameter("password");

      Profesor p = new Profesor(aux, n, n1, n2, n3, n4, n5, n6);

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

   private String agregaCursoShow(HttpServletRequest request) {
      if (validarUsr(request)) {
         return "/presentation/usuario/Administrador/Curso/agregar_curso.jsp";
      }
      return "/loginShow";
   }

   public String displayProfesorAgregar(HttpServletRequest request) {
      return "/presentation/usuario/Administrador/Profesor/agregar_profesor.jsp";
   }

   public String displayProfesorVer(HttpServletRequest request) {
      if (validarUsr(request)) {
         String idProfesor = request.getParameter("idProfesor");
         int cedula = Integer.parseInt(idProfesor);
         Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(cedula);
         request.setAttribute("profesor", profesor);
         return "/presentation/usuario/Administrador/Profesor/ver_profesor.jsp";
      }
      return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
   }

   public String displayProfesorEliminar(HttpServletRequest request) {

       if (validarUsr(request)) {

            String idProfesorString = request.getParameter("idProfesor");
            int profesorID = Integer.parseInt(idProfesorString);
            Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(profesorID);
            request.setAttribute("Profemostrar", profesor);
            return "/presentation/usuario/Administrador/Profesor/ver_profesor.jsp";
        }
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }

         String idProfesorString = request.getParameter("idProfesor");
         int profesorID = Integer.parseInt(idProfesorString);
         Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(profesorID);
         request.setAttribute("profesor_eliminar", profesor);
         return "/presentation/usuario/Administrador/Profesor/borrar_profesor.jsp";
      }
      return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
   }

   public String displayProfesorEditar(HttpServletRequest request) {

      if (validarUsr(request)) {

         String idProfesorString = request.getParameter("idProfesor");
         int profesorID = Integer.parseInt(idProfesorString);
         Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(profesorID);
         request.setAttribute("profesor_editar", profesor);
         return "/presentation/usuario/Administrador/Profesor/editar_profesor.jsp";
      }
      return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
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

   private String editarProfeAction(HttpServletRequest request) {
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

         Profesor p = new Profesor(cedula, nombre, apellido1, apellido2, correo, telefono, especialidad, password);

         try {
            ProfesorDAO.obtenerInstancia().actualizar(p);
            return "/verProfeShow";
         } catch (Exception ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return "/verProfeShow";
         }
      }
      return "/verProfeShow";
   }

   private String eliminarProfeAction(HttpServletRequest request) {
      if (validarUsr(request)) {
         String p = (String) request.getParameter("idProfesor");
         int cedula = Integer.parseInt(p);
         try {
            ProfesorDAO.obtenerInstancia().eliminar(cedula);
         } catch (Exception ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return "/mostrarProfesor";
         }
         return "/mostrarProfesor";
      }
      return "/mostrarProfesor";

    }
    
   public String displayEliminarCurso(HttpServletRequest request){
       
       if (validarUsr(request)) {

            String CodigoCurso = request.getParameter("idCurso");
            int CursoID = Integer.parseInt(CodigoCurso);
            Curso c = CursoDAO.obtenerInstancia().recuperar(CursoID);
            request.setAttribute("curso_editar", c);
            return "/presentation/usuario/Administrador/Curso/borrar_curso.jsp";
        }
        return "/presentation/usuario/Administrador/Curso/curso.jsp";
   
   }
   
   public String EliminarCursoAction(HttpServletRequest request){
       
       if (validarUsr(request)) {
           String CodigoCurso = (String) request.getParameter("idCurso");
           int CursoID = Integer.parseInt(CodigoCurso);
           
           try{
               CursoDAO.obtenerInstancia().eliminar(CursoID);
           
           } catch (Exception ex){
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return "/CursosLibres/Curso";
           }
            return "/CursosLibres/Cursos";
        }
        return "/CursosLibres/Cursos";
   
   }
   
   
    public String displayEditarCurso(HttpServletRequest request){
       
       if (validarUsr(request)) {

            String CodigoCurso = request.getParameter("idCurso");
            int CursoID = Integer.parseInt(CodigoCurso);
            Curso c = CursoDAO.obtenerInstancia().recuperar(CursoID);
            request.setAttribute("curso_editar", c);
            return "/presentation/usuario/Administrador/Curso/editar_curso.jsp";
        }
        return "/presentation/usuario/Administrador/Curso/curso.jsp";
   
   }
    
    private String editarCursoAction(HttpServletRequest request) {
        
        if (validarUsr(request)) {
            
            String idCurso = request.getParameter("idCurso");
            int codigo = Integer.parseInt(idCurso);
            String nombre = request.getParameter("nombre");
            String tematica = request.getParameter("tematica");
            String costo = request.getParameter("costo");
            String ofe = request.getParameter("oferta");
            int oferta = Integer.parseInt(ofe);
            
            Curso c= new Curso(codigo,nombre,tematica,costo,oferta);

            try {
                CursoDAO.obtenerInstancia().actualizar(c);
                return "/verProfeShow";
            } catch (Exception ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                return "/verProfeShow";
            }
        }
        return "/verProfeShow";
    }
    

}
