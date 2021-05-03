package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.curso.CursoDAO;
import logic.curso.Curso;
import logic.curso.Service;
import logic.usuario.Usuario;
import logic.usuario.profesor.ProfesorDAO;
import logic.usuario.profesor.Profesor;
import javax.servlet.http.Part;
import logic.curso.CursoActual;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@WebServlet(name = "Administrador", urlPatterns = {"/Cursos", "/agregarProfesor", "/Estudiantes", "/agregarCurso", "/agregarCursoShow",
    "/mostrarProfesor", "/agregarProfesorShow", "/verProfeShow", "/editarProfeShow", "/eliminarProfeShow", "/editarProfeAction", "/eliminarProfeAction",
    "/editarCursoShow", "/verCursoShow", "/eliminarCursoAction", "/editarCursoAction", "/image", "/print"
})

@MultipartConfig(location = "C:/images")

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

            case "/agregarProfesor": {

                URL = agregarProfesor(request, response);
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
                URL = editarProfeAction(request, response);
                break;
            }
            case "/eliminarProfeAction": {
                URL = eliminarProfeAction(request, response);
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

            case "/print": {

                URL = print(request, response);
                break;
            }

            default:
                break;
        }
        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
        }

    }

    public String display(HttpServletRequest request) {

        CursoDAO dao = CursoDAO.obtenerInstancia();
        Service listaCursos = dao.listarCursos();

        request.setAttribute("listaCursos", listaCursos);

        return "/presentation/usuario/Administrador/Curso/cursos.jsp";

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

    public String agregaCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        final Part imagen;
        try {
            String nombre = request.getParameter("nombre");
            String tematica = request.getParameter("tematica");
            String costo = request.getParameter("costo");
            String ofe = request.getParameter("oferta");
            int oferta = Integer.parseInt(ofe);
            Curso c = new Curso(nombre, tematica, costo, oferta);
            CursoDAO.obtenerInstancia().crear(c);

            imagen = request.getPart("imagen");
            imagen.write(request.getParameter("nombre"));

            response.sendRedirect("/CursosLibres/Cursos");           
        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                response.sendRedirect("/CursosLibres/agregarCurso");
            }
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

        Profesor p = new Profesor(aux, n, n1, n2, n3, n4, n5, n6);

        try {
            ProfesorDAO.obtenerInstancia().crear(p);
            response.sendRedirect("/CursosLibres/mostrarProfesor");

        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            }
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            return "/presentation/usuario/Administrador/Profesor/borrar_profesor.jsp";
        }
        return "/presentation/usuario/Administrador/Profesor/profesor.jsp";
    }

    public String displayEliminarProfesor(HttpServletRequest request) {
        if (validarUsr(request)) {
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

            Profesor p = new Profesor(cedula, nombre, apellido1, apellido2, correo, telefono, especialidad, password);

            try {
                ProfesorDAO.obtenerInstancia().actualizar(p);
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            } catch (Exception ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("/CursosLibres/mostrarProfesor");
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
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("/CursosLibres/mostrarProfesor");
            }
            
        }
        return null;
    }

    public String displayEditarCurso(HttpServletRequest request) {

        if (validarUsr(request)) {

            String CodigoCurso = request.getParameter("idCurso");
            int CursoID = Integer.parseInt(CodigoCurso);
            Curso c = CursoDAO.obtenerInstancia().recuperar(CursoID);
            request.setAttribute("curso_editar", c);
            return "/presentation/usuario/Administrador/Curso/editar_curso.jsp";
        }
        return "/Cursos";

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

            Curso c = new Curso(codigo, nombre, tematica, costo, oferta);

            try {
                CursoDAO dao = CursoDAO.obtenerInstancia();
                dao.actualizar(c);
                response.sendRedirect("/CursosLibres/Cursos");
                
            } catch (Exception ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("/CursosLibres/Cursos");
            }
        }
        return null;
    }

    private String print(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            HttpSession session = request.getSession(true);

            PdfDocument pdf = new PdfDocument(new PdfWriter(response.getOutputStream()));
            Document doc = new Document(pdf, PageSize.A4.rotate());

            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

            ArrayList<CursoActual> listaCursos = (ArrayList<CursoActual>) session.getAttribute("listaCursos");
            for (CursoActual c : listaCursos) {

                doc.add(new Paragraph("Curso: " + c.getNombre()));
                doc.add(new Paragraph("Profesor: " + c.getNombreProfesor() + c.getApellidoProfesor()));
                doc.add(new Paragraph("Horario: " + c.getHorario()));
                doc.add(new Paragraph("Nota: " + c.getNota()));
                // ImageData data = ImageDataFactory.create("C:/images" + c.getNombre());
                //Image img = new Image(data);
                //doc.add(img);
                doc.add(new Paragraph(""));
                doc.close();
                response.setContentType("application/pdf");
                response.addHeader("Content-disposition", "inline");
                //return null;
            }
            return null;

        } catch (IOException ex) {
            response.sendRedirect("/CursosLibres/ListaCursosShow");            
        }
        return null;

    }
}
