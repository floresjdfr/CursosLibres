/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.usuario.Model;
import logic.usuario.Usuario;
import logic.usuario.administrador.AdministradorDAO;
import logic.usuario.estudiante.EstudianteDAO;
import logic.usuario.profesor.ProfesorDAO;

@WebServlet(name = "Login", urlPatterns = {"/Login", "/Logout", "/loginShow", "/Error"})
public class Login extends HttpServlet {

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
        Model model = new Model();
        request.setAttribute("model", model);
        String URL = "";

        switch (request.getServletPath()) {
            case "/Login": {
                URL = show(request);
                break;
            }
            case "/Logout": {
                URL = Logout(request);
                break;
            }
            case "/loginShow": {
                URL = loginShow(request);
                break;
            }
            case "/Error": {
                URL = loginError(request);
                break;
            }
            default:
                URL = "/index.jsp";
        }
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(URL).forward(request, response);

    }

    public String loginError(HttpServletRequest request) {

        Map<String, String> errores = null;
        try {
            errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                //return "/presentation/login/login.jsp";
                return "/Login";
            } else {
                request.setAttribute("errores", errores);
                //return "/presentation/login/login.jsp";
                return "/Login";
            }
        } catch (Exception e) {
            request.setAttribute("errores", errores);
            //return "/presentation/login/login.jsp";
            return "/Login";
        }
    }

    public Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("usernameText").isEmpty()) {
            errores.put("usernameText", "Cedula requerida");
        }

        if (request.getParameter("passwordText").isEmpty()) {
            errores.put("passwordText", "Clave requerida");
        }
        try {
            String a = request.getParameter("usernameText");
            int auz = Integer.parseInt(a);

        } catch (Exception ex) {
            errores.put("usernameText", "No se aceptan letras en el ID");
        }

        return errores;
    }

    public String loginShow(HttpServletRequest request) {
        return "/presentation/login/login.jsp";
    }

    public String show(HttpServletRequest request) {

        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.showAction(request);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/login/login.jsp";
            }
        } catch (Exception e) {
            return "/presentation/login/error.jsp";
        }

    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        String auxCedula = (String) request.getParameter("usernameText");
        int aux = Integer.parseInt(auxCedula);
        String auxPassword = (String) request.getParameter("passwordText");

        model.getUsr().setPassword(auxPassword);
        model.getUsr().setCedula(aux);

    }

    public String Logout(HttpServletRequest request) {
        return this.logoutAction(request);

    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usr");
        session.invalidate();
        return "/CursoDisplay";
    }

    private String showAction(HttpServletRequest request) {

        try {
            Model model = (Model) request.getAttribute("model");
            Usuario DBuser;
            HttpSession session = request.getSession(true);

            DBuser = EstudianteDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());
            if (DBuser != null) {
                if (DBuser.getPassword().equals(model.getUsr().getPassword())) {
                    session.setAttribute("usr", DBuser);
                    return "/CursoDisplay";
                   
                } else {
                    DBuser = null;
                }
            } else {
                DBuser = AdministradorDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());

                if (DBuser != null) {
                    if (DBuser.getPassword().equals(model.getUsr().getPassword())) {
                        session.setAttribute("usr", DBuser);
                        return "/CursoDisplay";
                       
                    } else {
                        DBuser = null;
                    }
                } else {
                    DBuser = ProfesorDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());
                    if (DBuser != null) {
                        if (DBuser.getPassword().equals(model.getUsr().getPassword())) {
                            session.setAttribute("usr", DBuser);
                            return "/CursoDisplay";
                            
                        } else {
                            DBuser = null;
                        }
                    }
                }
            }
            if (DBuser == null) {
                throw new Exception("ex");
            }
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("usernameText", "Usuario o clave incorrectos /solo numeros");
            errores.put("passwordText", "Usuario o clave incorrectos");
            return "/presentation/login/login.jsp";

        }

        return "/CursoDiaplay";

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
