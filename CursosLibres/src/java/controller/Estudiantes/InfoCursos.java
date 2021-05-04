/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Estudiantes;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.pdfa.PdfADocument;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyleConstants;
import logic.curso.CursoActual;
import logic.curso.CursoDAO;
import logic.curso.Service;
import logic.usuario.Usuario;
import logic.usuario.estudiante.Estudiante;

/**
 *
 * @author flore
 */
@WebServlet(name = "InfoCursos", urlPatterns = {"/ListaCursosShow", "/ImprimirHistorialAction"})
public class InfoCursos extends HttpServlet {

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
            case "/ListaCursosShow": {
                URL = listaCursosShow(request);
                break;
            }

            case "/ImprimirHistorialAction": {
                URL = imprimirHistorialAction(request, response);
                break;
            }

        }
        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
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

    private String listaCursosShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {

                List<CursoActual> listaCursos;

                Estudiante estudiante = (Estudiante) request.getSession().getAttribute("usr");
                int idEstudiante = estudiante.getCedula();

                listaCursos = (ArrayList<CursoActual>) CursoDAO.obtenerInstancia().listarCursosActuales(idEstudiante);

                if (listaCursos != null) {
                    request.setAttribute("listaCursos", listaCursos);
                    return "/presentation/usuario/Estudiante/cursosActualesShow.jsp";
                }

                throw new Exception("Error al recuperar de la base de datos");
            }
        } catch (Exception ex) {
            return "/CursoDisplay";
        }
        return "";
    }

    private boolean validarEstudiante(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario usr = (Usuario) session.getAttribute("usr");
        return usr != null;

    }

    private String imprimirHistorialAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (validarEstudiante(request)) {
                try {
                    HttpSession session = request.getSession(true);

                    PdfDocument pdf = new PdfDocument(new PdfWriter(response.getOutputStream()));
                    Document doc = new Document(pdf, PageSize.A4.rotate());
                    doc.setMargins(100, 50, 100, 50);

                    PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

                    ArrayList<CursoActual> listaCursos = (ArrayList<CursoActual>) session.getAttribute("listaCursos");
                    
                    Text text = new Text("Historial cursos");
                    PdfFont bold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
                    
                    text.setFont(bold);
                    text.setFontSize(25);
                    
                    Paragraph title = new Paragraph();
                    title.add(text);
                    title.setTextAlignment(TextAlignment.CENTER);
                    
                    doc.add(title);
                    
                    float[] pointColumnWidths = {150F, 150F, 150F, 150F, 150F};
                    Table table = new Table(pointColumnWidths);
                    
                    Cell imageCell = new Cell();
                    Paragraph imagenTitle = new Paragraph("Imagen");
                    imageCell.add(imagenTitle);
                    
                    Cell cursoCell = new Cell();
                    Paragraph cursoTitle = new Paragraph("Curso");
                    cursoCell.add(cursoTitle);
                    
                    Cell profesorCell = new Cell();
                    Paragraph profesorTitle = new Paragraph("Profesor");
                    profesorCell.add(profesorTitle);
                    
                    Cell horarioCell = new Cell();
                    Paragraph horarioTitle = new Paragraph("Horario");
                    horarioCell.add(horarioTitle);
                    
                    Cell notaCell = new Cell();
                    Paragraph notaTitle = new Paragraph("Nota");
                    notaCell.add(notaTitle);
                    
                    table.addCell(imageCell);
                    table.addCell(cursoCell);
                    table.addCell(profesorCell);
                    table.addCell(horarioCell);
                    table.addCell(notaCell);
                    
                    
                    
                    for (CursoActual c : listaCursos) {
                        
                        
                        Cell imageContentCell = new Cell();
                        Cell cursoContentCell = new Cell();
                        Cell profesorContentCell = new Cell();
                        Cell horarioContentCell = new Cell();
                        Cell notaContentCell = new Cell();
                        
                        Paragraph imageContent = new Paragraph();
                        Paragraph cursoContent = new Paragraph();
                        Paragraph profesorContent = new Paragraph();
                        Paragraph horarioContent = new Paragraph();
                        Paragraph notaContent = new Paragraph();
                        
                        ImageData data = ImageDataFactory.create("C:/images/" + c.getNombre());
                        Image img = new Image(data);
                        img.scaleAbsolute(50, 50);
                        
                        String curso = c.getNombre();
                        String profesor = c.getNombreProfesor() + " " + c.getApellidoProfesor();
                        String horario = c.getHorario();
                        String nota = c.getNota();
                        
                        cursoContent.add(curso);
                        profesorContent.add(profesor);
                        horarioContent.add(horario);
                        notaContent.add(nota);
                        
                        imageContentCell.add(img);
                        cursoContentCell.add(cursoContent);
                        profesorContentCell.add(profesorContent);
                        horarioContentCell.add(horarioContent);
                        notaContentCell.add(notaContent);
                        
                        table.addCell(imageContentCell);
                        table.addCell(cursoContentCell);
                        table.addCell(profesorContentCell);
                        table.addCell(horarioContentCell);
                        table.addCell(notaContentCell);
                        
                        
                        
                        
                        
//                        
//                        
                        
//                        doc.add(new Paragraph(""));

                        //return null;
                    }
                    
                    doc.add(table);
                   
                    response.setContentType("application/pdf");
                    response.addHeader("Content-disposition", "inline");
                    doc.close();
                    
                    return null;

                } catch (Exception ex) {
                    return "/ListaCursosShow";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/ListaCursosShow";
        }
        return "/ListaCursosShow";

    }

}
